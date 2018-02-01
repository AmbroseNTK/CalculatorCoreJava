package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Null;


public class Body extends ExpressionComponent {
    public Body(){
        componentType= ExprComponentType.Function;
        priority=1;
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new Body());
    }

    @Override
    public ExpressionComponent process() {
        double retAdd=0;
        if(args.size()>1) {
            if(args.peek().getComponentType()==ExprComponentType.Number) {
                retAdd = (Double)args.pop().getValue();
                if(retAdd!=-1) {
                    int step = 0;
                    while (!args.isEmpty()) {
                        if (step == retAdd) {
                            return args.pop().process();
                        } else {
                            args.pop().process();
                        }
                        step++;
                    }
                }
                else{
                    ExpressionComponent ret=new Null();
                    while (!args.isEmpty()) {
                        if(args.peek().getComponentType()!=ExprComponentType.Null) {
                            ret = args.peek().process();
                        }
                        args.pop();
                    }
                    return ret;
                }
            }
            else if(args.peek().getComponentType()==ExprComponentType.Null) {
                while (!args.isEmpty()) {
                    args.pop().process();
                }
            }
            else{
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getName()+": "+locale.incorrectArgument());
            }
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getName()+": "+locale.incorrectArgumentList());
        }
        return new Null();

    }
}

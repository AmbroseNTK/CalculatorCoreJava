package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Number;


public class Average extends ExpressionComponent {
    public Average(){
        componentType= ExprComponentType.Function;
        priority=0;
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new Average());
    }

    @Override
    public ExpressionComponent process() {
        int size=args.size();
        double result=0;
        if(size!=0){
            while(!args.isEmpty()){
                if(args.peek().getComponentType()==ExprComponentType.Number){
                    result+=(Double)args.pop().getValue();
                }
                else{
                    ErrorHandle.getInstance().setErrorFlag(true);
                    ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getName()+": "+locale.incorrectArgumentType()+": "+args.peek().getValue().toString());
                    break;
                }
            }
        }
        return new Number(size==0?0:result/size);
    }
}

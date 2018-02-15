package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Null;
import ntk.ambrose.calculatorcoremodule.operands.Number;


public class If extends ExpressionComponent {
    public If(){
        componentType= ExprComponentType.Function;
        priority=0;
        identify="if";
        identify =locale.getIdentify(getClass().getSimpleName());
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new If());
    }

    @Override
    public ExpressionComponent process() {

        if(args.size()==2){
            if(args.get(1).getComponentType()==ExprComponentType.Boolean){
                boolean flag=(Boolean)(args.get(1).getValue());
                if(flag){
                    args.get(0).process();
                }
            }
            else{
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, "If: Incorrect conditional");
            }
        }
        else if(args.size()==3){

            if(args.get(2).getComponentType()==ExprComponentType.Boolean){
                boolean flag=(Boolean)(args.get(2).getValue());
                if(flag){
                    args.get(1).process();
                }
                else{
                    args.get(0).process();
                }
            }
            else{
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, "If: Incorrect conditional");
            }
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, "If: Incorrect argument quantity");
        }

        return new Null();
    }
}

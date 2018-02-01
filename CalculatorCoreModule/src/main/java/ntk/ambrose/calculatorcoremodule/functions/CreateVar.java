package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MemoryZone;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Null;
import ntk.ambrose.calculatorcoremodule.operands.Number;


public class CreateVar extends ExpressionComponent {
    public CreateVar(){
        componentType= ExprComponentType.Function;
        priority=1;
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new CreateVar());
    }

    @Override
    public ExpressionComponent process() {
        int size=args.size();
        if(size==1){
            if(args.peek().getComponentType()==ExprComponentType.String) {
                MemoryZone.getInstance().createVar((String)args.pop().getValue(),new Null());
            }
            else{
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getName()+": "+locale.incorrectArgument());
            }
        }
        else if(size ==2){
            if(args.peek().getComponentType()==ExprComponentType.String) {
                String varName = (String) args.pop().getValue();
                MemoryZone.getInstance().createVar(varName, args.pop());
            }
            else{
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getName()+": "+locale.incorrectArgumentType());
            }
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, "Create Number: Incorrect argument quantity");
        }
        return new Null();
    }
}

package ntk.ambrose.calculatorcoremodule.functions;


import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MemoryZone;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Null;

public class GetVar extends ExpressionComponent {
    public GetVar(){
        componentType= ExprComponentType.Function;
        priority=1;
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new GetVar());
    }

    @Override
    public ExpressionComponent process() {
        if(args.size()==1){
            if(args.peek().getComponentType()==ExprComponentType.String){
                return MemoryZone.getInstance().getVar((String)args.pop().getValue());
            }
            else{
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getName()+": "+locale.incorrectArgumentType());
            }
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getName()+": "+locale.incorrectArgumentList());
        }
        return new Null();
    }
}

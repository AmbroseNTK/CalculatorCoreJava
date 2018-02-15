package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MemoryZone;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Null;


public class SetVar extends ExpressionComponent {
    public SetVar(){
        componentType= ExprComponentType.Function;
        priority=1;
        identify =locale.getIdentify(getClass().getSimpleName());
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new SetVar());
    }

    @Override
    public ExpressionComponent process() {
        if(args.size()==2){
            if(args.peek().getComponentType()==ExprComponentType.String){
                String varName = (String)args.pop().getValue();
                MemoryZone.getInstance().setVar(varName,args.pop());
            }
            else{
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName()+": "+locale.incorrectArgumentType());
            }
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName()+": "+locale.incorrectArgumentList());
        }
        return new Null();
    }
}

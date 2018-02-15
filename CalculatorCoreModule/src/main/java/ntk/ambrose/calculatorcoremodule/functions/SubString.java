package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Str;

public class SubString extends ExpressionComponent {
    public SubString(){
        componentType= ExprComponentType.Function;
        priority=1;
        identify =locale.getIdentify(getClass().getSimpleName());
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new SubString());
    }

    @Override
    public ExpressionComponent process() {
        if(args.size()==3){
            if(args.peek().getComponentType()==ExprComponentType.String){
                String value = ((String) args.pop().getValue());
                if(args.peek().getComponentType()==ExprComponentType.Number){
                    double start = ((double) args.pop().getValue());
                    if(args.peek().getComponentType()==ExprComponentType.Number){
                        double stop= ((double) args.pop().getValue());
                        return new Str(value.substring(((int) start), ((int) stop)));
                    }
                    else{
                        ErrorHandle.getInstance().setErrorFlag(true);
                        ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName() + ": " + locale.incorrectArgumentType() + ": " + args.peek());
                    }
                }
                else{
                    ErrorHandle.getInstance().setErrorFlag(true);
                    ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName() + ": " + locale.incorrectArgumentType() + ": " + args.peek());
                }
            }
            else{
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName() + ": " + locale.incorrectArgumentType() + ": " + args.peek());
            }
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName() + ": " + locale.incorrectArgumentList());

        }
        return new Str("");
    }
}

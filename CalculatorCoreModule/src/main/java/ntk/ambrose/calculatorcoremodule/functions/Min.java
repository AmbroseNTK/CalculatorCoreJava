package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Null;
import ntk.ambrose.calculatorcoremodule.operands.Number;

/**
 * Created by ambrose on 15/02/2018.
 */

public class Min extends ExpressionComponent {
    public Min() {
        componentType = ExprComponentType.Function;
        priority = 1;
        identify =locale.getIdentify(getClass().getSimpleName());
    }

    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new Min());
    }

    @Override
    public ExpressionComponent process() {
        if(args.size()>0){
            if(args.peek().getComponentType()==ExprComponentType.Number){
                double min= ((double) args.pop().getValue());
                double current=0;
                while(!args.isEmpty()){
                    if(args.peek().getComponentType()==ExprComponentType.Number){
                        current = ((double) args.pop().getValue());
                        if(min>current)
                            min=current;
                    }
                    else{
                        ErrorHandle.getInstance().setErrorFlag(true);
                        ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName() + ": " + locale.incorrectArgumentType() + ": " + args.peek());
                        break;
                    }
                }
                return new Number(min);
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
        return new Null();
    }
}

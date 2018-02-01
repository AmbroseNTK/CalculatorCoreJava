package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;


public class Or extends ExpressionComponent {
    public Or(){
        componentType= ExprComponentType.Function;
        priority=0;
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new Or());
    }

    @Override
    public ExpressionComponent process() {
        boolean result = false;
        if (args.size() > 0) {
            while (args.size() > 0) {
                if (args.peek().getComponentType() == ExprComponentType.Boolean)
                    result = result || (Boolean) args.pop().getValue();
                else {
                    ErrorHandle.getInstance().setErrorFlag(true);
                    ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getName()+": "+locale.incorrectArgumentType());
                    break;
                }
            }
        } else {
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getName()+": "+locale.incorrectArgumentList());
        }
        return result == true ? new True() : new False();
    }
}

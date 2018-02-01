package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;


public class Greater extends ExpressionComponent {
    public Greater(){
        componentType= ExprComponentType.Function;
        priority=1;
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new Greater());
    }

    @Override
    public ExpressionComponent process() {
        if (args.size() == 2) {
            ExpressionComponent paraA = args.pop();
            ExpressionComponent paraB = args.pop();
            if (paraA.getComponentType() == ExprComponentType.Number && paraB.getComponentType() == ExprComponentType.Number) {
                if ((Double) paraA.getValue()>(Double) paraB.getValue())
                    return new True();
                else
                    return new False();

            } else {
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error,getClass().getName()+": "+locale.incorrectArgumentType());
            }

        } else {
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getName()+": "+locale.incorrectArgumentList());
        }
        return new False();
    }
}

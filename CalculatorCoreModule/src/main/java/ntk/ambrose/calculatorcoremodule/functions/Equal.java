package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;


public class Equal extends ExpressionComponent {
    public Equal() {
        componentType = ExprComponentType.Function;
        priority=1;
        identify =locale.getIdentify(getClass().getSimpleName());
    }

    @Override
    public void parse(Expression expression) {
        parseFunction(expression, new Equal());
    }

    @Override
    public ExpressionComponent process() {
        if (args.size() == 2) {
            ExpressionComponent paraA = args.pop();
            ExpressionComponent paraB = args.pop();
            if (paraA.getComponentType() == ExprComponentType.Number && paraB.getComponentType() == ExprComponentType.Number) {
                if (((Double) paraA.getValue()).equals((Double) paraB.getValue()))
                    return new True();
            } else if (paraA.getComponentType() == ExprComponentType.String && paraB.getComponentType() == ExprComponentType.String) {
                if (((String) paraA.getValue()).equals((String) paraB.getValue()))
                    return new True();
            } else if (paraA.getComponentType() == ExprComponentType.Boolean && paraB.getComponentType() == ExprComponentType.Boolean) {
                if (((Boolean) paraA.getValue()).equals((Boolean) paraB.getValue()))
                    return new True();
            } else {
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName()+": "+locale.incorrectArgumentType());
            }

        } else {
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName()+": "+locale.incorrectArgumentList());
        }
        return new False();
    }
}

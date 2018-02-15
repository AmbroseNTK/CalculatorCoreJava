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

public class Logarithm extends ExpressionComponent {
    public Logarithm() {
        componentType = ExprComponentType.Function;
        priority = 1;
        identify =locale.getIdentify(getClass().getSimpleName());
    }

    @Override
    public void parse(Expression expression) {
        parseFunction(expression, new Logarithm());
    }

    @Override
    public ExpressionComponent process() {
        if (args.size() == 1) {
            if (args.peek().getComponentType() == ExprComponentType.Number) {
                double num = ((double) args.pop().getValue());
                return new Number(Math.log(num));
            } else {
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName() + ": " + locale.incorrectArgumentType() + ": " + args.peek());
            }

        } else if (args.size() == 2) {
            if (args.peek().getComponentType() == ExprComponentType.Number) {
                double x = ((double) args.pop().getValue());
                if (args.peek().getComponentType() == ExprComponentType.Number) {
                    double base = ((double) args.pop().getValue());
                    return new Number(Math.log(x) / Math.log(base));
                } else {
                    ErrorHandle.getInstance().setErrorFlag(true);
                    ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName() + ": " + locale.incorrectArgumentType() + ": " + args.peek());
                }
            } else {
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName() + ": " + locale.incorrectArgumentType() + ": " + args.peek());
            }
        } else {
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName() + ": " + locale.incorrectArgumentList());
        }
        return new Null();
    }
}

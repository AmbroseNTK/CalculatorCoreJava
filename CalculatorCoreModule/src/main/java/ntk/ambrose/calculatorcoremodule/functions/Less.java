package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;


public class Less extends ExpressionComponent {
    public Less(){
        componentType= ExprComponentType.Function;
        priority=1;
        identify="less";
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new Less());
    }

    @Override
    public ExpressionComponent process() {
        if (args.size() == 2) {
            ExpressionComponent paraA = args.pop();
            ExpressionComponent paraB = args.pop();
            if (paraA.getComponentType() == ExprComponentType.Number && paraB.getComponentType() == ExprComponentType.Number) {
                if ((Double) paraA.getValue()<(Double) paraB.getValue())
                    return new True();
                else
                    return new False();

            } else {
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, "Less: Incorrect arguments");
            }

        } else {
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, "Less: Too many arguments");
        }
        return new False();
    }
}

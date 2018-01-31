package ntk.ambrose.calculatorcoremodule.operators;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;


public class PatheR extends ExpressionComponent {
    public PatheR(){
        componentType= ExprComponentType.PatheR;
        priority=0;
    }
    @Override
    public void parse(Expression expression) {
        boolean isInStr=false;
        char[] chExpr=expression.getRawExpression().toCharArray();
        for(int i=0;i<chExpr.length;i++) {
            if (chExpr[i] == '"') {
                if((i > 0 && chExpr[i - 1] != '\\')||(i==0)) {
                    isInStr = !isInStr;
                }
            }
            if (!isInStr) {
                if (chExpr[i] == ')') {
                    expression.getExpr().put(i, new PatheR());
                    ErrorHandle.getInstance().setMessage(MessageType.Info, "PatheR operator");
                }
            }
        }
    }

    @Override
    public ExpressionComponent process() {
        return this;
    }
}

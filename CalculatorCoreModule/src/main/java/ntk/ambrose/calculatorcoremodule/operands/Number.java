package ntk.ambrose.calculatorcoremodule.operands;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;


public class Number extends ExpressionComponent {

    public Number() {
        componentType = ExprComponentType.Number;
        value = new Double(0);
        priority=0;
    }

    public Number(String strNum) {
        componentType = ExprComponentType.Number;
        try {
            value = new Double(strNum);
        } catch (Exception e) {
            ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName()+": "+locale.operandNumberError()+": "+strNum);
        }
    }

    public Number(double num){
        componentType=ExprComponentType.Number;
        value=num;
        priority=0;
    }

    @Override
    public void parse(Expression expression) {
        boolean isInStr = false;
        int digitCount = 0;
        char[] chExpr = expression.getRawExpression().toCharArray();
        int exLen = chExpr.length;
        for (int i = 0; i <= exLen; i++) {
            if (i != exLen && chExpr[i] == '"') {
                if((i > 0 && chExpr[i - 1] != '\\')||(i==0)) {
                    isInStr = !isInStr;
                }
            }
            if (!isInStr) {
                if ((i != exLen) && (Character.isDigit(chExpr[i]) || chExpr[i] == '.')) {
                    digitCount++;
                } else {
                    if (digitCount > 0) {
                        String num = expression.getRawExpression().substring(i - digitCount, i);
                        expression.addComponent(i - digitCount, new Number(num));
                        digitCount = 0;
                    }
                }
            }
        }
    }

    @Override
    public ExpressionComponent process() {
        return this;
    }

}
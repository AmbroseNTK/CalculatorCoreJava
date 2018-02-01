package ntk.ambrose.calculatorcoremodule.operators;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Null;
import ntk.ambrose.calculatorcoremodule.operands.Number;


public class Multiple extends ExpressionComponent {
    public Multiple(){
        componentType= ExprComponentType.Operator;
        priority=2;
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
                if (chExpr[i] == '*') {
                    expression.getExpr().put(i, new Multiple());
                    ErrorHandle.getInstance().setMessage(MessageType.Info, "Multiple operator");
                }
            }
        }
    }
    @Override
    public ExpressionComponent process() {
        ExpressionComponent result=new Null();
        if(args.size()>=2) {
            ExpressionComponent paraA = args.pop();
            ExpressionComponent paraB = args.pop();
            if (paraA.getComponentType() == ExprComponentType.Number && paraB.getComponentType() == ExprComponentType.Number) {
                result = new Number((Double) paraA.getValue() * (Double) paraB.getValue());
            } else {
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, locale.incorrectArgument());
            }
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, locale.missingOperand());
        }
        return result;
    }
}

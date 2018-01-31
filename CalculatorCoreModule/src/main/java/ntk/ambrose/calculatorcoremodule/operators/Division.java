package ntk.ambrose.calculatorcoremodule.operators;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Number;


public class Division extends ExpressionComponent {
    public Division(){
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
                if (chExpr[i] == '/') {
                    expression.getExpr().put(i, new Division());
                    ErrorHandle.getInstance().setMessage(MessageType.Info, "Division operator");
                }
            }
        }
    }

    @Override
    public ExpressionComponent process() {
        ExpressionComponent result=null;
        if(args.size()>=2) {
            ExpressionComponent paraA = args.pop();
            ExpressionComponent paraB = args.pop();
            if (paraA.getComponentType() == ExprComponentType.Number && paraB.getComponentType() == ExprComponentType.Number) {
                if ((Double) paraB.getValue() != 0) {
                    result = new Number((Double) paraA.getValue() / (Double) paraB.getValue());
                } else {
                    ErrorHandle.getInstance().setErrorFlag(true);
                    ErrorHandle.getInstance().setMessage(MessageType.Error, "Division by zero");
                }
            } else {
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, "Args have incorrect type");
            }
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, "Missing some operand");
        }
        return result;
    }
}
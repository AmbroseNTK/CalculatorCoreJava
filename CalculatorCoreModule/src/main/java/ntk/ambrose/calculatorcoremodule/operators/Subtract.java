package ntk.ambrose.calculatorcoremodule.operators;


import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Number;

public class Subtract extends ExpressionComponent{
    public Subtract(){
        componentType= ExprComponentType.Operator;
        priority=1;
        identify="subtract_operator";
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
                if (chExpr[i] == '-') {
                    expression.getExpr().put(i, new Subtract());
                    ErrorHandle.getInstance().setMessage(MessageType.Info, "Subtract operator");
                }
            }
        }
    }

    @Override
    public ExpressionComponent process() {
        ExpressionComponent result=null;
        ExpressionComponent paraA=args.pop();
        ExpressionComponent paraB=args.pop();
        if(paraA.getComponentType()==ExprComponentType.Number&&paraB.getComponentType()==ExprComponentType.Number){
            result=new Number((Double)paraA.getValue()-(Double)paraB.getValue());
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error,"Args have incorrect type");
        }
        return result;
    }
}

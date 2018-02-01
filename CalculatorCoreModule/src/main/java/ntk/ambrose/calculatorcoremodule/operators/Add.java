package ntk.ambrose.calculatorcoremodule.operators;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Null;
import ntk.ambrose.calculatorcoremodule.operands.Number;
import ntk.ambrose.calculatorcoremodule.operands.Str;


public class Add extends ExpressionComponent {

    public Add() {
        componentType = ExprComponentType.Operator;
        priority = 1;
        identify="add_operator";
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
                if (chExpr[i] == '+') {
                    expression.getExpr().put(i, new Add());
                }
            }
        }

    }

    @Override
    public ExpressionComponent process() {
        ExpressionComponent result=new Null();
        ExpressionComponent paraA=args.pop();
        ExpressionComponent paraB=args.pop();
        if(paraA.getComponentType()==ExprComponentType.Number&&paraB.getComponentType()==ExprComponentType.Number) {
            double numA = (Double)paraA.getValue();
            double numB=(Double)paraB.getValue();
            result = new Number(numA+numB);

        }
        else if(paraA.getComponentType()==ExprComponentType.String&&paraB.getComponentType()==ExprComponentType.String) {
            String strA = (String) paraA.getValue();
            String strB = (String) paraB.getValue();
            result = new Str(strA + strB);
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error,getClass().getName()+": "+locale.operatorAddError()+" between "+paraA.toString()+" and "+paraB.toString());
        }

        return result;
    }
}

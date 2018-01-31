package ntk.ambrose.calculatorcoremodule.operands;

import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.operators.Subtract;

/**
 * Created by Nguyen Tuan Kiet on 1/31/2018.
 */

public class Str extends ExpressionComponent {
    public Str(){
        componentType= ExprComponentType.String;
        priority=-1;
        value="";
    }
    public Str(String str) {
        componentType = ExprComponentType.String;
        priority = -1;
        value = str;
    }
    @Override
    public void parse(Expression expression) {
        boolean isInStr=false;
        int archor=0;
        char[] chExpr=expression.getRawExpression().toCharArray();
        for(int i=0;i<chExpr.length;i++) {
            if(chExpr[i]=='"') {
                if ((i > 0 && chExpr[i - 1] != '\\') || (i == 0)) {
                    if (!isInStr) {
                        isInStr = true;
                        archor=i;
                    } else {
                        String str = expression.getRawExpression().substring(archor+1,i);
                        expression.addComponent(archor,new Str(str));
                        isInStr = false;
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

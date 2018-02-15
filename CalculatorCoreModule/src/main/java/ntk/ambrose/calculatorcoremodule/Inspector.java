package ntk.ambrose.calculatorcoremodule;

import java.util.HashMap;

/**
 * Created by ambrose on 15/02/2018.
 */

public class Inspector {
    private Expression expression;
    private HashMap<Integer,String> inspectorMap;

    public void setExpression(Expression expression) {
        this.expression = expression;
        inspectorMap = new HashMap<>();
        for(Integer key: expression.getExpr().keySet()){
            int len =expression.getExpr().get(key).identify.length();
            for(int i=key;i<len;i++) {
                inspectorMap.put(i, expression.getExpr().get(key).identify);
            }
        }
        for(int i=0;i<expression.getRawExpression().length();i++){
            if(!inspectorMap.containsKey(i)){
                inspectorMap.put(i,"Nothing");
            }
        }
    }

    public Inspector(){

    }

    public String inspect(int target) {
        return ExpressionComponent.locale.getDocument(inspectorMap.get(target));
    }
}

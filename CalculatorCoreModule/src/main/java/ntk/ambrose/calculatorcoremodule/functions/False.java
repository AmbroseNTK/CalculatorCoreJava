package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;


public class False extends ExpressionComponent {
    public False(){
        componentType= ExprComponentType.Boolean;
        value=false;
        priority=0;
        identify="false";
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new False());
    }

    @Override
    public ExpressionComponent process() {
        return new False();
    }
}

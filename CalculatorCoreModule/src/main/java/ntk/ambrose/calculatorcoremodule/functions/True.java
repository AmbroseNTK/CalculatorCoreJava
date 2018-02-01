package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;


public class True extends ExpressionComponent {
    public True(){
        componentType= ExprComponentType.Boolean;
        value=true;
        priority=0;
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new True());
    }

    @Override
    public ExpressionComponent process() {
        return new True();
    }
}

package ntk.ambrose.calculatorcoremodule.operators;

import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;


public class Wall extends ExpressionComponent {
    public Wall(){
        componentType= ExprComponentType.WallO;
        priority=0;
    }
    @Override
    public void parse(Expression expression) {

    }

    @Override
    public ExpressionComponent process() {
        return this;
    }
}

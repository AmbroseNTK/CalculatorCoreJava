package ntk.ambrose.calculatorcoremodule.operands;


import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;

public class Null extends ExpressionComponent {
    public Null(){
        componentType= ExprComponentType.Null;
        priority=0;
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new Null());
    }

    @Override
    public ExpressionComponent process() {
        return new Null();
    }
}

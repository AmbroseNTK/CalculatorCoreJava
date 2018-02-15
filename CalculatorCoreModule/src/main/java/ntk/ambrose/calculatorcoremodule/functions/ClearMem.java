package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MemoryZone;
import ntk.ambrose.calculatorcoremodule.operands.Null;


public class ClearMem extends ExpressionComponent {
    public ClearMem(){
        componentType= ExprComponentType.Function;
        priority=0;
        identify =locale.getIdentify(getClass().getSimpleName());
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new ClearMem());
    }

    @Override
    public ExpressionComponent process() {
        MemoryZone.getInstance().clearData();
        return new Null();
    }
}

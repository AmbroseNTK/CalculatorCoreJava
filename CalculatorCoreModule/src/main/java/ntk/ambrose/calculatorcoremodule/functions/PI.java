package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Number;


public class PI extends ExpressionComponent {
    public PI(){
        componentType= ExprComponentType.Function;
        priority=0;
        identify="PI";
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new PI());
    }

    @Override
    public ExpressionComponent process() {
        if(args.size()==0)
            return new Number(3.14159265359);
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, "PI: Too many arguments");
        }
        return new Number(0);
    }
}

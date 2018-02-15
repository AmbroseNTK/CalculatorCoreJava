package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Number;


public class Sum extends ExpressionComponent {

    public Sum() {
        componentType = ExprComponentType.Function;
        priority = 0;
        identify =locale.getIdentify(getClass().getSimpleName());
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new Sum());
    }

    @Override
    public ExpressionComponent process() {
        double result = 0;
        while(!args.isEmpty()){
            ExpressionComponent current=args.pop();
            if(current.getComponentType()==ExprComponentType.Number){
                result+=(Double)current.getValue();
            }
            else{
                ErrorHandle.getInstance().setErrorFlag(true);
                ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName()+": "+locale.incorrectArgumentType()+": "+current);
            }
        }
        return new Number(result);
    }
}

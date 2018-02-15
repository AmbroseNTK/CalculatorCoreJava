package ntk.ambrose.calculatorcoremodule.functions;

import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.ExprComponentType;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.ExpressionComponent;
import ntk.ambrose.calculatorcoremodule.MessageType;
import ntk.ambrose.calculatorcoremodule.operands.Null;
import ntk.ambrose.calculatorcoremodule.operands.Number;


public class Cosine extends ExpressionComponent {
    public Cosine(){
        componentType = ExprComponentType.Function;
        priority=1;
        identify =locale.getIdentify(getClass().getSimpleName());
    }
    @Override
    public void parse(Expression expression) {
        parseFunction(expression,new Cosine());
    }

    @Override
    public ExpressionComponent process() {
        if(args.size()==1){
            if(args.peek().getComponentType()==ExprComponentType.Number){
                return new Number(Math.cos(((double) (args.pop().getValue()))));
            }
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName()+": "+locale.incorrectArgumentType()+": "+args.peek());
        }
        else
        {
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, getClass().getSimpleName()+": "+locale.incorrectArgumentList());
        }
        return new Null();
    }
}

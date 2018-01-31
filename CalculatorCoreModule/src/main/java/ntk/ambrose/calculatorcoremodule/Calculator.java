package ntk.ambrose.calculatorcoremodule;

import java.util.ArrayList;

import ntk.ambrose.calculatorcoremodule.operands.*;
import ntk.ambrose.calculatorcoremodule.operands.Number;
import ntk.ambrose.calculatorcoremodule.operators.*;
import ntk.ambrose.calculatorcoremodule.functions.*;

public class Calculator {
    private String rawExpression;
    private String result;
    private Expression expression;
    private ArrayList<ExpressionComponent> parser;
    public String getRawExpression() {
        return rawExpression;
    }

    public void setRawExpression(String rawExpression) {
        this.rawExpression = rawExpression;
        expression = new Expression(rawExpression);
    }

    public String getResult() {
        return result;
    }
    public Calculator(){
        init();
    }
    private void init(){
        parser = new ArrayList<>();
        parser.add(new Number());
        parser.add(new Str());
        parser.add(new Add());
        parser.add(new Subtract());
        parser.add(new Multiple());
        parser.add(new Division());

        parser.add(new PatheL());
        parser.add(new PatheR());
        parser.add(new Sum());
        parser.add(new Negative());
        parser.add(new True());
        parser.add(new False());
        parser.add(new PI());
        parser.add(new And());
        parser.add(new Or());
        parser.add(new Equal());
        parser.add(new Greater());
        parser.add(new Less());
    }
    public void calculate(){
        for(ExpressionComponent component: parser){
            component.parse(expression);
        }
        expression.toPostfix();
        ErrorHandle.getInstance().setMessage(MessageType.Info,"Result = "+expression.calculate().toString());

    }
}

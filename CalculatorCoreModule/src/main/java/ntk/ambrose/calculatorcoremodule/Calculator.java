package ntk.ambrose.calculatorcoremodule;

import java.util.ArrayList;
import java.util.TreeMap;

import ntk.ambrose.calculatorcoremodule.operands.*;
import ntk.ambrose.calculatorcoremodule.operands.Number;
import ntk.ambrose.calculatorcoremodule.operators.*;
import ntk.ambrose.calculatorcoremodule.functions.*;

public class Calculator {
    private String rawExpression;
    private String result;
    private TreeMap<Integer,Expression> expressions;
    private int numOfExpr;
    private ArrayList<ExpressionComponent> parser;
    private Inspector inspector;

    public Calculator(){
        init();
    }
    public void extension(ArrayList<ExpressionComponent> parser){

    }
    private void init(){
        inspector = new Inspector();
        MemoryZone.getInstance().clearData();
        ExpressionComponent.setLocale(new LocaleEn());
        numOfExpr=0;
        expressions=new TreeMap<>();
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
        parser.add(new Not());

        parser.add(new Average());
        parser.add(new CreateVar());
        parser.add(new GetVar());
        parser.add(new SetVar());
        parser.add(new Body());
        parser.add(new ClearMem());
        parser.add(new Sine());
        parser.add(new Cosine());
        parser.add(new Tangent());
        parser.add(new ArcSine());
        parser.add(new ArcCosine());
        parser.add(new ArcTangent());
        parser.add(new Logarithm());
        parser.add(new Max());
        parser.add(new Min());
        parser.add(new ToNumber());
        parser.add(new ToString());
        parser.add(new SubString());
        parser.add(new Pow());
        extension(parser);

    }
    public Inspector getInspector(){
        return inspector;
    }
    public void addExpression(int id, String rawExpression){
        expressions.put(id,new Expression(rawExpression));

    }
    public void addExpression(String rawExpression){
        addExpression(numOfExpr,rawExpression);
        numOfExpr++;
    }
    public ExpressionComponent calculate() {
        ExpressionComponent result = null;
        for(Expression expression: expressions.values()) {

            for (ExpressionComponent component : parser) {
                component.parse(expression);
            }

            expression.toPostfix();
            result = expression.calculate();
            ErrorHandle.getInstance().setMessage(MessageType.Info, "Result = " + (result == null ? "Unknow" : result.toString()));

        }
        return result;
    }

    public String inspect(String exprText, int target){
        Expression temp=new Expression(exprText);
        for(ExpressionComponent component:parser){
            component.parse(temp);
        }
        inspector.setExpression(temp);
        return inspector.inspect(target);
    }

}

package ntk.ambrose.calculatorcoremodule;

import java.util.ArrayList;
import java.util.Stack;

import ntk.ambrose.calculatorcoremodule.functions.Sum;

public abstract class ExpressionComponent {
    protected ExprComponentType componentType;
    protected Object value;
    protected int priority;
    protected Stack<ExpressionComponent> args;
    protected String identify;
    protected static Locale locale;
    public static void setLocale(Locale loc){
        locale=loc;
    }
    public ExpressionComponent() {
        componentType = ExprComponentType.Unknown;
        args=new Stack<>();
        value = null;
        identify="";
    }

    @Override
    public String toString() {

        return value==null?"Null":value.toString();
    }

    public abstract void parse(Expression expression);

    public ExprComponentType getComponentType() {
        return componentType;
    }

    public int getPriority(){
        return priority;
    }

    public void setArgs(Stack<ExpressionComponent> args) {
        this.args = args;
    }
    public void parseFunction(Expression expression,ExpressionComponent component) {
        identify = locale.getIdentify(getClass().getSimpleName());
        boolean isInStr = false;
        int start = 0;
        char[] chExpr = expression.getRawExpression().toCharArray();
        for (int i = 0; i < chExpr.length; i++) {
            if (chExpr[i] == '"') {
                if((i > 0 && chExpr[i - 1] != '\\')||(i==0)) {
                    isInStr = !isInStr;
                }
            }
            if (!isInStr) {
                if (start < identify.length()) {
                    if (chExpr[i] == identify.toCharArray()[start]) {
                        start++;
                    } else {
                        start = 0;
                    }
                }
                if (start == identify.length()) {
                    expression.addComponent(i - start+1,component);
                    start=0;
                }
            }
        }
    }
    public abstract ExpressionComponent process();
    public Object getValue(){
        return value;
    }
}

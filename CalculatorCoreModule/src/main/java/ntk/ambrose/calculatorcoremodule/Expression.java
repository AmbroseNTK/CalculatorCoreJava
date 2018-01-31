package ntk.ambrose.calculatorcoremodule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

import ntk.ambrose.calculatorcoremodule.operands.Number;
import ntk.ambrose.calculatorcoremodule.operators.Wall;

public class Expression {
    private String rawExpression;
    private TreeMap<Integer,ExpressionComponent> expr;
    private ArrayList<ExpressionComponent> postfix;
    public Expression() {
        rawExpression = "";
        expr = new TreeMap<>();
    }
    public Expression(String rawExpression){
        setRawExpression(rawExpression);
        expr = new TreeMap<>();
    }

    public String getRawExpression() {
        return rawExpression;
    }

    public void setRawExpression(String rawExpression) {
        this.rawExpression = rawExpression;
    }

    public TreeMap<Integer, ExpressionComponent> getExpr() {
        return expr;
    }

    public void setExpr(TreeMap<Integer, ExpressionComponent> expr) {
        this.expr = expr;
    }

    public void addComponent(int pos, ExpressionComponent component){
            if(!expr.containsKey(pos))
                expr.put(pos,component);
            else{
                ErrorHandle.getInstance().setMessage(MessageType.Info,component.toString()+" cannot overrided");
            }
    }
    public ArrayList<ExpressionComponent> getPostfix(){
        return postfix;
    }
    public void toPostfix() {
        postfix = new ArrayList<>();
        Stack<ExpressionComponent> operators = new Stack<>();
        for (ExpressionComponent component : expr.values()) {
            if(component.componentType==ExprComponentType.Number ||component.componentType==ExprComponentType.String||component.componentType==ExprComponentType.Boolean)
                postfix.add(component);
            else if(component.componentType==ExprComponentType.PatheL)
                operators.push(component);
            else if(component.componentType==ExprComponentType.Operator) {
                ExpressionComponent top=null;
                if(!operators.isEmpty())
                    top = operators.peek();
                if (top != null && top.componentType == ExprComponentType.Operator) {
                    if (top.getPriority() >= component.getPriority())
                        postfix.add(operators.pop());
                }
                operators.push(component);
            }
            else if(component.componentType==ExprComponentType.PatheR) {
                ExpressionComponent top = null;
                if (!operators.isEmpty())
                    top = operators.peek();
                while (top != null && top.componentType != ExprComponentType.PatheL) {
                    postfix.add(operators.pop());
                    top = operators.peek();
                }
                operators.pop();
            }
            else if(component.componentType==ExprComponentType.Function){
                ExpressionComponent top =null;
                if(!operators.isEmpty())
                    top = operators.peek();
                if(top!=null && top.componentType==ExprComponentType.Function){
                    if(top.getPriority()>=component.getPriority())
                        postfix.add(operators.pop());
                }
                operators.push(component);
                postfix.add(new Wall());
            }
        }
        while(!operators.isEmpty())
            postfix.add(operators.pop());
    }
    public ExpressionComponent calculate(){
        Stack<ExpressionComponent> result=new Stack<>();
        ExpressionComponent next=null;
        for(int i=0;i<postfix.size()&&!ErrorHandle.getInstance().getErrorFlag();i++) {
            next = postfix.get(i);
            if (next.componentType == ExprComponentType.Number || next.componentType == ExprComponentType.String || next.componentType == ExprComponentType.Boolean || next.componentType == ExprComponentType.WallO) {
                result.push(next);
            } else if (next.componentType == ExprComponentType.Operator) {
                if (next.identify.equals("add_operator") || next.identify.equals("subtract_operator")) {
                    if (!result.isEmpty()) {
                        next.args.push(result.pop());
                    } else {
                        ErrorHandle.getInstance().setErrorFlag(true);
                        ErrorHandle.getInstance().setMessage(MessageType.Error, "Missing some operand");
                    }
                    if (!result.isEmpty()) {
                        next.args.push(result.pop());
                    } else {
                        next.args.push(new Number(0));
                    }
                } else {
                    if (result.size() >= 2) {
                        next.args.push(result.pop());
                        next.args.push(result.pop());
                    } else {
                        ErrorHandle.getInstance().setErrorFlag(true);
                        ErrorHandle.getInstance().setMessage(MessageType.Error, "Missing some operand");
                    }
                }
                result.push(next.process());
            } else if (next.componentType == ExprComponentType.Function) {
                ExpressionComponent funcArg = null;
                if (!result.isEmpty()) {
                    funcArg = result.peek();
                } else {
                    ErrorHandle.getInstance().setErrorFlag(true);
                    ErrorHandle.getInstance().setMessage(MessageType.Error, "Missing some argument");
                }
                while (funcArg.componentType != ExprComponentType.WallO) {
                    next.args.push(result.pop());
                    if(!result.isEmpty()) {
                        funcArg = result.peek();
                    }
                    else{
                        ErrorHandle.getInstance().setErrorFlag(true);
                        ErrorHandle.getInstance().setMessage(MessageType.Error, "Missing some argument");
                        break;
                    }
                }
                result.pop();
                result.push(next.process());
            }
        }

        if(result.size()==1){
            return result.pop();
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error,"Expression cannot calculate completly");
            return null;
        }

    }

}

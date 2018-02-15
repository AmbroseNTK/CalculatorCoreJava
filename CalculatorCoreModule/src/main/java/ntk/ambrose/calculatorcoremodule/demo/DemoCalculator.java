package ntk.ambrose.calculatorcoremodule.demo;


import ntk.ambrose.calculatorcoremodule.Calculator;
import ntk.ambrose.calculatorcoremodule.ErrorHandle;
import ntk.ambrose.calculatorcoremodule.Expression;
import ntk.ambrose.calculatorcoremodule.Inspector;

public class DemoCalculator {
    public static void main(String[] args){
        Calculator calculator = new Calculator();
        calculator.addExpression("log(4,2)");
        calculator.calculate();
        ErrorHandle.getInstance().showAll();
    }
}

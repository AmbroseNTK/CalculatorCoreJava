package ntk.ambrose.calculatorcoremodule.demo;


import ntk.ambrose.calculatorcoremodule.Calculator;
import ntk.ambrose.calculatorcoremodule.ErrorHandle;

public class DemoCalculator {
    public static void main(String[] args){
        Calculator calculator = new Calculator();
        calculator.setRawExpression("less(2,3-5)");
        calculator.calculate();
        ErrorHandle.getInstance().showAll();
    }
}

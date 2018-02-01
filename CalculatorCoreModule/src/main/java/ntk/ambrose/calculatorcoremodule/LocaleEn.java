package ntk.ambrose.calculatorcoremodule;


import java.util.HashMap;

import ntk.ambrose.calculatorcoremodule.functions.And;
import ntk.ambrose.calculatorcoremodule.functions.Average;
import ntk.ambrose.calculatorcoremodule.functions.Body;
import ntk.ambrose.calculatorcoremodule.functions.ClearMem;
import ntk.ambrose.calculatorcoremodule.functions.CreateVar;
import ntk.ambrose.calculatorcoremodule.functions.Equal;
import ntk.ambrose.calculatorcoremodule.functions.False;
import ntk.ambrose.calculatorcoremodule.functions.GetVar;
import ntk.ambrose.calculatorcoremodule.functions.Greater;
import ntk.ambrose.calculatorcoremodule.functions.Less;
import ntk.ambrose.calculatorcoremodule.functions.Negative;
import ntk.ambrose.calculatorcoremodule.functions.Not;
import ntk.ambrose.calculatorcoremodule.functions.Or;
import ntk.ambrose.calculatorcoremodule.functions.PI;
import ntk.ambrose.calculatorcoremodule.functions.SetVar;
import ntk.ambrose.calculatorcoremodule.functions.Sum;
import ntk.ambrose.calculatorcoremodule.functions.True;
import ntk.ambrose.calculatorcoremodule.operands.Null;

public class LocaleEn extends Locale {
    @Override
    public String missingOperand() {
        return "Missing some operand";
    }

    @Override
    public String incorrectArgument() {
        return "Incorrect argument";
    }

    @Override
    public String incorrectArgumentType() {
        return "Incorrect argument type";
    }

    @Override
    public String incorrectArgumentList() {
        return "Incorrect argument list";
    }

    @Override
    public String operatorAddError() {
        return "Operator + error";
    }

    @Override
    public String operatorSubError() {
        return "Operator - error";
    }

    @Override
    public String operatorMulError() {
        return "Operator * error";
    }

    @Override
    public String operatorDivError() {
        return "Operator / error";
    }

    @Override
    public String operandNumberError() {
        return "Cannot parse a number";
    }

    @Override
    public String operandStrError() {
        return "Cannot parse a string";
    }

    @Override
    public String operandDivisionByZero() {
        return "Division by zero";
    }

    @Override
    public String variableExisted() {
        return "This variable existed";
    }

    @Override
    public String variableNotFound() {
        return "Variable not found";
    }

    @Override
    public String failExpression() {
        return "Misunderstanded this expression";
    }

    @Override
    public void createIdentify(HashMap<String, String> identifyList) {
        identifyList.put(And.class.getName(), "and");
        identifyList.put(Average.class.getName(), "average");
        identifyList.put(Body.class.getName(), "body");
        identifyList.put(ClearMem.class.getName(), "clearData");
        identifyList.put(CreateVar.class.getName(), "createVar");
        identifyList.put(Equal.class.getName(), "equal");
        identifyList.put(False.class.getName(), "false");
        identifyList.put(GetVar.class.getName(), "get");
        identifyList.put(Greater.class.getName(), "greater");
        identifyList.put(Less.class.getName(), "less");
        identifyList.put(Negative.class.getName(), "neg");
        identifyList.put(Not.class.getName(), "not");
        identifyList.put(Or.class.getName(), "or");
        identifyList.put(PI.class.getName(), "PI");
        identifyList.put(SetVar.class.getName(), "set");
        identifyList.put(Sum.class.getName(), "sum");
        identifyList.put(True.class.getName(), "true");
        identifyList.put(Null.class.getName(),"null");
    }


}

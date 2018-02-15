package ntk.ambrose.calculatorcoremodule;


import java.util.HashMap;

import ntk.ambrose.calculatorcoremodule.functions.And;
import ntk.ambrose.calculatorcoremodule.functions.ArcCosine;
import ntk.ambrose.calculatorcoremodule.functions.ArcSine;
import ntk.ambrose.calculatorcoremodule.functions.ArcTangent;
import ntk.ambrose.calculatorcoremodule.functions.Average;
import ntk.ambrose.calculatorcoremodule.functions.Body;
import ntk.ambrose.calculatorcoremodule.functions.ClearMem;
import ntk.ambrose.calculatorcoremodule.functions.Cosine;
import ntk.ambrose.calculatorcoremodule.functions.CreateVar;
import ntk.ambrose.calculatorcoremodule.functions.Equal;
import ntk.ambrose.calculatorcoremodule.functions.False;
import ntk.ambrose.calculatorcoremodule.functions.GetVar;
import ntk.ambrose.calculatorcoremodule.functions.Greater;
import ntk.ambrose.calculatorcoremodule.functions.Less;
import ntk.ambrose.calculatorcoremodule.functions.Logarithm;
import ntk.ambrose.calculatorcoremodule.functions.Max;
import ntk.ambrose.calculatorcoremodule.functions.Min;
import ntk.ambrose.calculatorcoremodule.functions.Negative;
import ntk.ambrose.calculatorcoremodule.functions.Not;
import ntk.ambrose.calculatorcoremodule.functions.Or;
import ntk.ambrose.calculatorcoremodule.functions.PI;
import ntk.ambrose.calculatorcoremodule.functions.Pow;
import ntk.ambrose.calculatorcoremodule.functions.SetVar;
import ntk.ambrose.calculatorcoremodule.functions.Sine;
import ntk.ambrose.calculatorcoremodule.functions.SubString;
import ntk.ambrose.calculatorcoremodule.functions.Sum;
import ntk.ambrose.calculatorcoremodule.functions.Tangent;
import ntk.ambrose.calculatorcoremodule.functions.ToNumber;
import ntk.ambrose.calculatorcoremodule.functions.ToString;
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
        return "Invalid expression";
    }

    @Override
    public void createIdentify(HashMap<String, String> identifyList) {
        identifyList.put(And.class.getSimpleName(), "and");
        identifyList.put(Average.class.getSimpleName(), "average");
        identifyList.put(Body.class.getSimpleName(), "body");
        identifyList.put(ClearMem.class.getSimpleName(), "clearData");
        identifyList.put(CreateVar.class.getSimpleName(), "createVar");
        identifyList.put(Equal.class.getSimpleName(), "equal");
        identifyList.put(False.class.getSimpleName(), "false");
        identifyList.put(GetVar.class.getSimpleName(), "get");
        identifyList.put(Greater.class.getSimpleName(), "greater");
        identifyList.put(Less.class.getSimpleName(), "less");
        identifyList.put(Negative.class.getSimpleName(), "neg");
        identifyList.put(Not.class.getSimpleName(), "not");
        identifyList.put(Or.class.getSimpleName(), "or");
        identifyList.put(PI.class.getSimpleName(), "PI");
        identifyList.put(SetVar.class.getSimpleName(), "set");
        identifyList.put(Sum.class.getSimpleName(), "sum");
        identifyList.put(True.class.getSimpleName(), "true");
        identifyList.put(Null.class.getSimpleName(),"null");
        identifyList.put(Sine.class.getSimpleName(),"sin");
        identifyList.put(Cosine.class.getSimpleName(),"cos");
        identifyList.put(Tangent.class.getSimpleName(),"tan");
        identifyList.put(ArcSine.class.getSimpleName(),"asin");
        identifyList.put(ArcCosine.class.getSimpleName(),"acos");
        identifyList.put(ArcTangent.class.getSimpleName(),"atan");
        identifyList.put(Logarithm.class.getSimpleName(),"log");
        identifyList.put(Max.class.getSimpleName(),"max");
        identifyList.put(Min.class.getSimpleName(),"min");
        identifyList.put(Pow.class.getSimpleName(),"pow");
        identifyList.put(SubString.class.getSimpleName(),"subString");
        identifyList.put(ToNumber.class.getSimpleName(),"toNumber");
        identifyList.put(ToString.class.getSimpleName(),"toString");
    }

    @Override
    public void createDocument(HashMap<String, String> document) {
        document.put(getIdentify(And.class.getSimpleName()), "and(bool1,bool2,...boolN)\nReturn true if bool1=bool2=...=booln=true.");
        document.put(getIdentify(Average.class.getSimpleName()), "average(num1,num2,...numN)\nReturn average of num1, num2,..., numN.");
        document.put(getIdentify(Body.class.getSimpleName()), "body(num type, func1, func2, ..., funcN)\nProcessing sequence functions which are in arguments.\nType = null: It will not return value.\nType = number > 0: It will stop at function #number and return its value.\nType = neg(1): It will return the last value.");
        document.put(getIdentify(ClearMem.class.getSimpleName()), "clearData()\nClear all variable in Memory Zone");
        document.put(getIdentify(CreateVar.class.getSimpleName()), "createVar(string varName, [default Value])\nCreate new variable.");
        document.put(getIdentify(Equal.class.getSimpleName()), "equal(objectA,objectB)\nReturn true if objectA = objectB.");
        document.put(getIdentify(False.class.getSimpleName()), "false\nBoolean value: false.");
        document.put(getIdentify(GetVar.class.getSimpleName()), "get(string varName)\nReturn value of this variable.");
        document.put(getIdentify(Greater.class.getSimpleName()), "greater(object1, object2)\nReturn true if object1 > object2.");
        document.put(getIdentify(Less.class.getSimpleName()), "less(object1, object2)\nReturn true if object1 < object2");
        document.put(getIdentify(Negative.class.getSimpleName()), "neg(number)\nReturn -number.");
        document.put(getIdentify(Not.class.getSimpleName()), "not(bool)\nReturn false if bool = true.\nReturn true if bool = false.");
        document.put(getIdentify(Or.class.getSimpleName()), "or(bool1, bool2, ..., boolN)\nReturn true if one of arguments is true.");
        document.put(getIdentify(PI.class.getSimpleName()), "PI()\nReturn value of PI");
        document.put(getIdentify(SetVar.class.getSimpleName()), "set(string varName, value)\nSet value to variable.");
        document.put(getIdentify(Sum.class.getSimpleName()), "sum(object1, object2, ..., objectN)\nReturn sum of all objects.");
        document.put(getIdentify(True.class.getSimpleName()), "true\nBoolean value: true.");
        document.put(getIdentify(Null.class.getSimpleName()),"null\nNull value.");
        document.put(getIdentify(Sine.class.getSimpleName()),"sin(num)\nReturn sine of num (Radian).");
        document.put(getIdentify(Cosine.class.getSimpleName()),"cos(num)\nReturn cosine of num (Radian).");
        document.put(getIdentify(Tangent.class.getSimpleName()),"tan(num)\nReturn tangent of num (Radian).");
        document.put(getIdentify(ArcSine.class.getSimpleName()),"asin(num)\nReturn arc sine of num (Radian).");
        document.put(getIdentify(ArcCosine.class.getSimpleName()),"acos(num)\nReturn arc cosine of num (Radian).");
        document.put(getIdentify(ArcTangent.class.getSimpleName()),"atan(num)\nReturn arc tangent of num (Radian).");
        document.put(getIdentify(Logarithm.class.getSimpleName()),"log(x,[base] = 10)\nReturn logarithm of base with x. Default value of base is 10.");
        document.put(getIdentify(Max.class.getSimpleName()),"max(num1, num2, ..., numN)\nReturn max of arguments.");
        document.put(getIdentify(Min.class.getSimpleName()),"min(num1, num2, ..., numN\nReturn min of arguments.");
        document.put(getIdentify(Pow.class.getSimpleName()),"pow(base,x)\nReturn base^x.");
        document.put(getIdentify(SubString.class.getSimpleName()),"subString(string, start, end)\nReturn sub-string of string from start to end.");
        document.put(getIdentify(ToNumber.class.getSimpleName()),"toNumber(string)\nConvert string to number.");
        document.put(getIdentify(ToString.class.getSimpleName()),"toString(number)\nConvert number to string.");
    }


}

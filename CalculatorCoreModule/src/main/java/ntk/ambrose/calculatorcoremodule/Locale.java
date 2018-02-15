package ntk.ambrose.calculatorcoremodule;

import java.util.HashMap;

public abstract class Locale {

    public Locale(){
        identifyList=new HashMap<>();
        createIdentify(identifyList);

        document = new HashMap<>();
        createDocument(document);
    }
    public abstract String missingOperand();
    public abstract String incorrectArgument();
    public abstract String incorrectArgumentType();
    public abstract String incorrectArgumentList();

    public abstract String operatorAddError();
    public abstract String operatorSubError();
    public abstract String operatorMulError();
    public abstract String operatorDivError();
    public abstract String operandNumberError();
    public abstract String operandStrError();
    public abstract String operandDivisionByZero();

    public abstract String variableExisted();
    public abstract String variableNotFound();
    public abstract String failExpression();

    public abstract void createIdentify(HashMap<String,String> identifyList);
    public abstract void createDocument(HashMap<String,String> document);

    public HashMap<String,String> identifyList;
    public HashMap<String,String> document;
    public String getIdentify(String funcName) {
        if(identifyList.containsKey(funcName))
            return identifyList.get(funcName);
        return "";
    }
    public String getDocument(String funcName){
        if(document.containsKey(funcName))
            return document.get(funcName);
        return "";
    }
}

package ntk.ambrose.calculatorcoremodule;


import java.util.HashMap;
import java.util.TreeMap;

import ntk.ambrose.calculatorcoremodule.operands.Null;

public class MemoryZone {
    private MemoryZone(){
        data=new TreeMap<>();
    }
    private static MemoryZone instance;
    public static MemoryZone getInstance(){
        if(instance==null)
            instance=new MemoryZone();
        return instance;
    }
    private static TreeMap<String,ExpressionComponent> data;
    public void clearData(){
        data.clear();
    }
    public void createVar(String varName, ExpressionComponent var){
        if(!data.containsKey(varName)){
            data.put(varName, var);
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, "Memory Zone: "+ExpressionComponent.locale.variableExisted()+": "+varName);
        }
    }
    public ExpressionComponent getVar(String varName){
        if(data.containsKey(varName)){
            return data.get(varName);
        }
        else{
            ErrorHandle.getInstance().setErrorFlag(true);
            ErrorHandle.getInstance().setMessage(MessageType.Error, "Memory Zone: "+ExpressionComponent.locale.variableNotFound()+": "+varName);
        }
        return new Null();
    }
    public void setVar(String varName, ExpressionComponent value){
       data.put(varName, value);
    }
}

package ntk.ambrose.calculatorcoremodule;


import java.util.ArrayList;
import java.util.HashMap;

public class ErrorHandle {
    private ErrorHandle(){
        messages=new ArrayList<>();
    }
    private boolean errorFlag;
    private static ErrorHandle instance;

    public static ErrorHandle getInstance(){
        if(instance==null)
            instance=new ErrorHandle();
        return instance;
    }

    public class Message{
        private MessageType messageType;
        private String message;

        public MessageType getMessageType() {
            return messageType;
        }

        public void setMessageType(MessageType messageType) {
            this.messageType = messageType;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        public Message(){

        }
        public Message(MessageType type, String message){
            setMessageType(type);
            setMessage(message);
        }
    }

    private ArrayList<Message> messages;

    public void setMessage(MessageType type,String message){
        messages.add(new Message(type,message));
    }

    public void clearMessages(){
        messages.clear();
    }
    public void showAll(){
        for(Message message:messages) {
            System.out.println(message.getMessageType().toString() + ": " + message.getMessage());
        }
    }
    public void showInfo(){
        for(Message message:messages){
            if(message.getMessageType()==MessageType.Info){
                System.out.println("Info: " + message.getMessage());
            }
        }
    }
    public void setErrorFlag(boolean flag){
        errorFlag=flag;
    }
    public boolean getErrorFlag(){
        return errorFlag;
    }
}

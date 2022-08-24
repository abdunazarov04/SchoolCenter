package uz.isystem.centert.exeption;

public class ServerBadRequestException extends RuntimeException{
    public ServerBadRequestException(String text){
        super(text);
    }
}

package Exceptions;



public class WrongSuperAbilityException extends Exception{
    protected String name;

    public WrongSuperAbilityException(String message){
        super(message);
    }

    @Override
    public String getMessage(){
        return ("у персонажа нет способности с таким номером");
    }
}

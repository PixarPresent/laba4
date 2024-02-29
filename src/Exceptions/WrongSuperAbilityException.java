package Exceptions;


import entities.*;

public class WrongSuperAbilityException extends RuntimeException {

    public WrongSuperAbilityException(String message) {
        super(message);
    }

}
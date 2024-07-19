package de.telran.timetrackinapp.exception;

public class InvalidUserException extends RuntimeException {

    public InvalidUserException(String message) {
        super(message);
    }

    public InvalidUserException(String message, Throwable cause){
        super(message, cause);
    }
}

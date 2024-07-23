package de.telran.timetrackinapp.exception;

public class UserNotAuthenticatedException extends RuntimeException{


    public UserNotAuthenticatedException(String message) {
        super(message);
    }
}

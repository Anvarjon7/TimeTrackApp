package de.telran.timetrackinapp.exception;

public class TimeEntryNotFoundException extends RuntimeException {

    public TimeEntryNotFoundException(String message) {
        super(message);
    }
}

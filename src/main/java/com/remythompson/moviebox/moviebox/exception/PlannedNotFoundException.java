package com.remythompson.moviebox.moviebox.exception;

public class PlannedNotFoundException extends RuntimeException {
    public PlannedNotFoundException() {
        super("Planned movie not found");
    }
    public PlannedNotFoundException(String message) {
        super(message);
    }
}

package com.remythompson.moviebox.moviebox.exception;

public class WatchedNotFoundException extends RuntimeException {
    public WatchedNotFoundException() {
        super("Watched Movie Not Found.");
    }

    public WatchedNotFoundException(String message) {
        super(message);
    }
}

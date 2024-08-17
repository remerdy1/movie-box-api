package com.remythompson.moviebox.moviebox.exception;

public class FavouriteNotFoundException extends RuntimeException {
    public FavouriteNotFoundException() {
        super("Favourite could not be found");
    }

    public FavouriteNotFoundException(String message) {
        super(message);
    }
}

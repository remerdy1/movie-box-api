package com.remythompson.moviebox.moviebox.exception;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(){
        super("Review could not be found.");
    }
    public ReviewNotFoundException(String message){
        super(message);
    }
}

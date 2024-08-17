package com.remythompson.moviebox.moviebox.exception;

import java.nio.file.AccessDeniedException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.remythompson.moviebox.moviebox.dto.FavouriteDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            ReviewNotFoundException.class,
            FavouriteNotFoundException.class,
            UserNotFoundException.class,
            PlannedNotFoundException.class,
            WatchedNotFoundException.class
    })
    public ResponseEntity<ErrorObject> handleReviewNotFoundException(RuntimeException exception,
                                                                     WebRequest request)
    {
        ErrorObject errorObject = ErrorObject.builder()
                .message(exception.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(Instant.now())
                .build();

        return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorObject> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                             WebRequest request)
    {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });


        ErrorObject errorObject = ErrorObject.builder()
                .message("Invalid Item")
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(Instant.now())
                .errors(errors)
                .build();

        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}

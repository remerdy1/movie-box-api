package com.remythompson.moviebox.moviebox.exception;

import java.time.Instant;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorObject {
    private Integer statusCode;
    private String message;
    private Instant timestamp;
    private Map<String, String> errors;
}

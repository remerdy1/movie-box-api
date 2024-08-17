package com.remythompson.moviebox.moviebox.dto;

public record AuthResponseDto(String accessToken, String tokenType) {
    public AuthResponseDto(String accessToken){
        this(accessToken, "Bearer ");
    }
}

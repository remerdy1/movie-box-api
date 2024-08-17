package com.remythompson.moviebox.moviebox.dto;

import jakarta.validation.constraints.NotNull;

public record RegisterDto(@NotNull String username, @NotNull String password) {
};

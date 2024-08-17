package com.remythompson.moviebox.moviebox.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record WatchedDto(
        Long id,
        @NotNull Long movieId,
        @NotNull Date watchedDate,
        @NotNull Long userId
) {
}

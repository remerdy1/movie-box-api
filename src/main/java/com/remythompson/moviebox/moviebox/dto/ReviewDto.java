package com.remythompson.moviebox.moviebox.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ReviewDto(
                Long id,
                @NotNull String title,
                @NotNull String text,
                @NotNull @Min(0) @Max(100) int rating,
                @NotNull Long userId,
                @NotNull Long movieId) {
}

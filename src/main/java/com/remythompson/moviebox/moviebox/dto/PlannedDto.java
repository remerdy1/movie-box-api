package com.remythompson.moviebox.moviebox.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record PlannedDto(Long id, @NotNull Long movieId, @NotNull Long userId, @NotNull Date datePlanned) {
}

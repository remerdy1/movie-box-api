package com.remythompson.moviebox.moviebox.dto;

import jakarta.validation.constraints.NotNull;

public record FavouriteDto(Long id, @NotNull  Long movieId, @NotNull Long userId) {
}

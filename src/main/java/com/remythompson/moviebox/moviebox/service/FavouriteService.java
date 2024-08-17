package com.remythompson.moviebox.moviebox.service;

import com.remythompson.moviebox.moviebox.dto.FavouriteDto;

import java.util.List;

public interface FavouriteService {
    FavouriteDto createFavourite(FavouriteDto favouriteDto);
    FavouriteDto getFavourite(long movieId);
    List<FavouriteDto> getFavouritesByUserId(long userId);
    void deleteFavourite(long favouriteId);
}

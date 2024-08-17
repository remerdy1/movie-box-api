package com.remythompson.moviebox.moviebox.map.impl;

import com.remythompson.moviebox.moviebox.dto.FavouriteDto;
import com.remythompson.moviebox.moviebox.map.DtoEntityMapper;
import com.remythompson.moviebox.moviebox.model.FavouriteEntity;
import com.remythompson.moviebox.moviebox.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class FavouriteMapper implements DtoEntityMapper<FavouriteDto, FavouriteEntity> {
    @Override
    public FavouriteDto toDto(FavouriteEntity entity) {
        return new FavouriteDto(entity.getId(), entity.getMovieId(), entity.getUser().getId());
    }

    @Override
    public FavouriteEntity toEntity(FavouriteDto favouriteDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(favouriteDto.userId());

        return new FavouriteEntity(favouriteDto.id(), favouriteDto.movieId(), userEntity);
    }
}

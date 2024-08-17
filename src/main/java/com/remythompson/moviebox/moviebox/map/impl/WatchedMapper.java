package com.remythompson.moviebox.moviebox.map.impl;

import com.remythompson.moviebox.moviebox.dto.WatchedDto;
import com.remythompson.moviebox.moviebox.map.DtoEntityMapper;
import com.remythompson.moviebox.moviebox.model.UserEntity;
import com.remythompson.moviebox.moviebox.model.WatchedEntity;
import org.springframework.stereotype.Component;

@Component
public class WatchedMapper implements DtoEntityMapper<WatchedDto, WatchedEntity> {
    @Override
    public WatchedEntity toEntity(WatchedDto dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(dto.userId());

        return new WatchedEntity(
                dto.id(),
                dto.movieId(),
                dto.watchedDate(),
                userEntity
        );
    }

    @Override
    public WatchedDto toDto(WatchedEntity entity) {
        return new WatchedDto(
                entity.getId(),
                entity.getMovieId(),
                entity.getDateWatched(),
                entity.getUser().getId()
        );
    }
}

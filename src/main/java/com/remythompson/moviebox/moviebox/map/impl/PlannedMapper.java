package com.remythompson.moviebox.moviebox.map.impl;

import com.remythompson.moviebox.moviebox.dto.PlannedDto;
import com.remythompson.moviebox.moviebox.map.DtoEntityMapper;
import com.remythompson.moviebox.moviebox.model.PlannedEntity;
import com.remythompson.moviebox.moviebox.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class PlannedMapper implements DtoEntityMapper<PlannedDto, PlannedEntity> {
    @Override
    public PlannedEntity toEntity(PlannedDto dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(dto.userId());

        return new PlannedEntity(dto.id(), dto.movieId(), dto.datePlanned(), userEntity);
    }

    @Override
    public PlannedDto toDto(PlannedEntity entity) {
        return new PlannedDto(entity.getId(), entity.getMovieId(), entity.getUser().getId(), entity.getDatePlanned());
    }
}

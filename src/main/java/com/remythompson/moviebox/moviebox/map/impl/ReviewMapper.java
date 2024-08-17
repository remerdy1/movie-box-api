package com.remythompson.moviebox.moviebox.map.impl;

import com.remythompson.moviebox.moviebox.dto.ReviewDto;
import com.remythompson.moviebox.moviebox.map.DtoEntityMapper;
import com.remythompson.moviebox.moviebox.model.ReviewEntity;
import com.remythompson.moviebox.moviebox.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper implements DtoEntityMapper<ReviewDto, ReviewEntity> {
    @Override
    public ReviewDto toDto(ReviewEntity entity) {
        return new ReviewDto(entity.getId(), entity.getTitle(), entity.getText(), entity.getRating(), entity.getUser().getId(), entity.getMovieId());
    }

    @Override
    public ReviewEntity toEntity(ReviewDto reviewDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(reviewDto.id());

        return new ReviewEntity(reviewDto.id(), reviewDto.title(), reviewDto.text(), reviewDto.rating(), reviewDto.movieId(), userEntity);
    }
}

package com.remythompson.moviebox.moviebox.service.impl;

import com.remythompson.moviebox.moviebox.dto.FavouriteDto;
import com.remythompson.moviebox.moviebox.exception.FavouriteNotFoundException;
import com.remythompson.moviebox.moviebox.exception.UserNotFoundException;
import com.remythompson.moviebox.moviebox.map.impl.FavouriteMapper;
import com.remythompson.moviebox.moviebox.model.FavouriteEntity;
import com.remythompson.moviebox.moviebox.repository.FavouriteRepository;
import com.remythompson.moviebox.moviebox.repository.UserRepository;
import com.remythompson.moviebox.moviebox.service.FavouriteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FavouriteServiceImpl implements FavouriteService {
    FavouriteRepository favouriteRepository;
    UserRepository userRepository;
    FavouriteMapper favouriteMapper;

    public FavouriteDto createFavourite(FavouriteDto favouriteDto) {
        userRepository.findById(favouriteDto.userId()).orElseThrow(UserNotFoundException::new);

        FavouriteEntity favouriteEntity = favouriteRepository.save(favouriteMapper.toEntity(favouriteDto));

        return favouriteMapper.toDto(favouriteEntity);
    }

    @Override
    public FavouriteDto getFavourite(long movieId) {
        FavouriteEntity favouriteEntity = favouriteRepository.findById(movieId).orElseThrow(FavouriteNotFoundException::new);

        return favouriteMapper.toDto(favouriteEntity);
    }

    @Override
    public List<FavouriteDto> getFavouritesByUserId(long userId) {
        userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        return favouriteRepository.findAllByUserId(userId)
                .stream().map(favouriteMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteFavourite(long favouriteId) {
        favouriteRepository.findById(favouriteId).orElseThrow(FavouriteNotFoundException::new);
        favouriteRepository.deleteById(favouriteId);
    }
}

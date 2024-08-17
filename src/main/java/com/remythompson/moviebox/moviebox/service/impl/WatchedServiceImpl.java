package com.remythompson.moviebox.moviebox.service.impl;

import com.remythompson.moviebox.moviebox.dto.WatchedDto;
import com.remythompson.moviebox.moviebox.exception.UserNotFoundException;
import com.remythompson.moviebox.moviebox.exception.WatchedNotFoundException;
import com.remythompson.moviebox.moviebox.map.impl.WatchedMapper;
import com.remythompson.moviebox.moviebox.model.WatchedEntity;
import com.remythompson.moviebox.moviebox.repository.UserRepository;
import com.remythompson.moviebox.moviebox.repository.WatchedRepository;
import com.remythompson.moviebox.moviebox.service.WatchedService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WatchedServiceImpl implements WatchedService {
    WatchedRepository watchedRepository;
    UserRepository userRepository;
    WatchedMapper watchedMapper;

    @Override
    public WatchedDto createWatched(WatchedDto watchedDto) {
        userRepository.findById(watchedDto.userId()).orElseThrow(UserNotFoundException::new);

        WatchedEntity watchedEntity = watchedMapper.toEntity(watchedDto);

        return watchedMapper.toDto(watchedRepository.save(watchedEntity));
    }

    @Override
    public WatchedDto getWatched(Long id) {
        WatchedEntity watchedEntity = watchedRepository.findById(id).orElseThrow(WatchedNotFoundException::new);

        return watchedMapper.toDto(watchedEntity);
    }

    @Override
    public List<WatchedDto> getWatchedByUserId(Long userId) {
        userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        List<WatchedEntity> watchedEntities = watchedRepository.findAllByUserId(userId);

        return watchedEntities.stream().map(watchedMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteWatched(Long id) {
        watchedRepository.findById(id).orElseThrow(WatchedNotFoundException::new);
        watchedRepository.deleteById(id);
    }
}

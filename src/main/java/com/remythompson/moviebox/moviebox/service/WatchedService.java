package com.remythompson.moviebox.moviebox.service;

import com.remythompson.moviebox.moviebox.dto.WatchedDto;

import java.util.List;

public interface WatchedService {
    WatchedDto createWatched(WatchedDto watchedDto);
    WatchedDto getWatched(Long id);
    List<WatchedDto> getWatchedByUserId(Long userId);
    void deleteWatched(Long id);
}

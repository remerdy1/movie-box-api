package com.remythompson.moviebox.moviebox.service;

import com.remythompson.moviebox.moviebox.dto.PlannedDto;

import java.util.List;

public interface PlannedService {
    PlannedDto createPlanned(PlannedDto plannedDto);
    PlannedDto getPlanned(Long id);
    List<PlannedDto> getPlannedByUserId(Long userId);
    void deletePlanned(Long id);
}

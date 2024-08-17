package com.remythompson.moviebox.moviebox.service.impl;

import com.remythompson.moviebox.moviebox.dto.PlannedDto;
import com.remythompson.moviebox.moviebox.exception.PlannedNotFoundException;
import com.remythompson.moviebox.moviebox.exception.UserNotFoundException;
import com.remythompson.moviebox.moviebox.map.impl.PlannedMapper;
import com.remythompson.moviebox.moviebox.model.PlannedEntity;
import com.remythompson.moviebox.moviebox.repository.PlannedRepository;
import com.remythompson.moviebox.moviebox.repository.UserRepository;
import com.remythompson.moviebox.moviebox.service.PlannedService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlannedServiceImpl implements PlannedService {
    PlannedRepository plannedRepository;
    UserRepository userRepository;
    PlannedMapper plannedMapper;

    @Override
    public PlannedDto createPlanned(PlannedDto plannedDto) {
        userRepository.findById(plannedDto.userId()).orElseThrow(UserNotFoundException::new);

        PlannedEntity savedPlanned = plannedRepository.save(plannedMapper.toEntity(plannedDto));
        return plannedMapper.toDto(savedPlanned);
    }

    @Override
    public PlannedDto getPlanned(Long id) {
        return plannedMapper.toDto(plannedRepository.findById(id).orElseThrow(PlannedNotFoundException::new));
    }

    @Override
    public List<PlannedDto> getPlannedByUserId(Long userId) {
        userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return plannedRepository.findAllByUserId(userId).stream().map(plannedMapper::toDto).toList();
    }

    @Override
    public void deletePlanned(Long id) {
        plannedRepository.findById(id).orElseThrow(PlannedNotFoundException::new);
        plannedRepository.deleteById(id);
    }
}

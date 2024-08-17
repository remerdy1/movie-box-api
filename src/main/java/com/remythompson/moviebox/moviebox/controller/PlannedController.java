package com.remythompson.moviebox.moviebox.controller;

import com.remythompson.moviebox.moviebox.dto.PlannedDto;
import com.remythompson.moviebox.moviebox.service.PlannedService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class PlannedController {
    PlannedService plannedService;

    @PostMapping("/planned")
    public ResponseEntity<PlannedDto> createPlanned(@RequestBody PlannedDto plannedDto) {
        PlannedDto newPlannedDto = plannedService.createPlanned(plannedDto);
        return ResponseEntity.ok(newPlannedDto);
    }

    @GetMapping("/planned/{id}")
    public ResponseEntity<PlannedDto> getPlanned(@PathVariable Long id) {
        PlannedDto plannedDto = plannedService.getPlanned(id);

        return ResponseEntity.ok(plannedDto);
    }

    @DeleteMapping("/planned/{id}")
    public ResponseEntity<String> deletePlanned(@PathVariable Long id) {
        plannedService.deletePlanned(id);

        return ResponseEntity.ok("Planned movie successfully deleted");
    }

    @GetMapping("/user/{userId}/planned")
    public ResponseEntity<List<PlannedDto>> getPlannedByUserId(@PathVariable Long userId) {
        plannedService.getPlannedByUserId(userId);

        return ResponseEntity.ok(plannedService.getPlannedByUserId(userId));
    }
}

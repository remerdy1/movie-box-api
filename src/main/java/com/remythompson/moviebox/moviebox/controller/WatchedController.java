package com.remythompson.moviebox.moviebox.controller;

import com.remythompson.moviebox.moviebox.dto.WatchedDto;
import com.remythompson.moviebox.moviebox.service.WatchedService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class WatchedController {
    WatchedService watchedService;

    @PostMapping("/watched")
    public ResponseEntity<WatchedDto> createWatched(@RequestBody @Valid WatchedDto watchedDto) {
        WatchedDto createdWatched = watchedService.createWatched(watchedDto);

        return ResponseEntity.ok(createdWatched);
    }

    @GetMapping("/watched/{id}")
    public ResponseEntity<WatchedDto> getWatched(@PathVariable Long id) {
        WatchedDto watchedDto = watchedService.getWatched(id);

        return ResponseEntity.ok(watchedDto);
    }

    @GetMapping("/user/{id}/watched")
    public ResponseEntity<List<WatchedDto>> getWatchedByUserId(@PathVariable Long id) {
        List<WatchedDto> watchedDtoList = watchedService.getWatchedByUserId(id);
        return ResponseEntity.ok(watchedDtoList);
    }

    @DeleteMapping("/watched/{id}")
    public ResponseEntity<String> deleteWatched(@PathVariable Long id) {
        watchedService.deleteWatched(id);
        return ResponseEntity.ok("Watched movie successfully deleted.");
    }
}

package com.remythompson.moviebox.moviebox.controller;

import com.remythompson.moviebox.moviebox.dto.FavouriteDto;
import com.remythompson.moviebox.moviebox.service.FavouriteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FavouriteController {
    FavouriteService favouriteService;

    @PostMapping("/favourite")
    public ResponseEntity<FavouriteDto> createFavourite(@Valid @RequestBody FavouriteDto favouriteDto){
        FavouriteDto favourite = favouriteService.createFavourite(favouriteDto);

        return ResponseEntity.ok(favourite);
    }

    @GetMapping("/favourite/{id}")
    public ResponseEntity<FavouriteDto> getFavourite(@PathVariable Long id){
        FavouriteDto favouriteDto = favouriteService.getFavourite(id);

        return ResponseEntity.ok(favouriteDto);
    }

    @DeleteMapping("/favourite/{id}")
    public ResponseEntity<String> deleteFavourite(@PathVariable Long id){
        favouriteService.deleteFavourite(id);

        return new ResponseEntity<>("Favourite successfully deleted", HttpStatus.OK);
    }


    @GetMapping("/user/{userId}/favourites")
    public ResponseEntity<List<FavouriteDto>> getAllFavourites(@PathVariable Long userId){
        List<FavouriteDto> favourites = favouriteService.getFavouritesByUserId(userId);
        return ResponseEntity.ok(favourites);
    }
}

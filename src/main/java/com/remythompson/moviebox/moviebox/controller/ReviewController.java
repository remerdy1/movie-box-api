package com.remythompson.moviebox.moviebox.controller;

import com.remythompson.moviebox.moviebox.dto.ReviewDto;
import com.remythompson.moviebox.moviebox.dto.ReviewListResponse;
import com.remythompson.moviebox.moviebox.service.ReviewService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public ResponseEntity<ReviewDto> createReview(@Valid @RequestBody ReviewDto review){
        ReviewDto reviewDto = reviewService.createReview(review);

        return ResponseEntity.status(HttpStatus.CREATED).body(reviewDto);
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<ReviewDto> getReview(@PathVariable Long id){
        ReviewDto reviewDto = reviewService.getReviewById(id);

        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<ReviewDto> getReview(@Valid @RequestBody ReviewDto reviewDto, @PathVariable Long id){
        ReviewDto updatedReview = reviewService.updateReview(reviewDto, id);

        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);

        return new ResponseEntity<>("Review successfully deleted", HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}/reviews")
    public ResponseEntity<ReviewListResponse> getReviews(@PathVariable Long movieId,
                                                         @RequestParam(value="pageNumber", defaultValue="0", required=false) int pageNumber,
                                                         @RequestParam(value="pageSize", defaultValue="10", required=false) int pageSize)
    {
        ReviewListResponse reviewListResponse = reviewService.getReviewsByMovieId(movieId, pageNumber, pageSize);

        return ResponseEntity.status(HttpStatus.OK).body(reviewListResponse);
    }
}

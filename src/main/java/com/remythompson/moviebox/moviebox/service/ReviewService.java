package com.remythompson.moviebox.moviebox.service;

import com.remythompson.moviebox.moviebox.dto.ReviewDto;
import com.remythompson.moviebox.moviebox.dto.ReviewListResponse;

public interface ReviewService {
    ReviewDto createReview(ReviewDto reviewDto);
    ReviewListResponse getReviewsByMovieId(Long movieId, int pageNumber, int pageSize);
    ReviewDto getReviewById(Long id);
    ReviewDto updateReview(ReviewDto reviewDto, Long id);
    void deleteReview(Long id);
}

package com.remythompson.moviebox.moviebox.service.impl;

import com.remythompson.moviebox.moviebox.dto.ReviewDto;
import com.remythompson.moviebox.moviebox.dto.ReviewListResponse;
import com.remythompson.moviebox.moviebox.exception.ReviewNotFoundException;
import com.remythompson.moviebox.moviebox.exception.UserNotFoundException;
import com.remythompson.moviebox.moviebox.map.impl.ReviewMapper;
import com.remythompson.moviebox.moviebox.model.ReviewEntity;
import com.remythompson.moviebox.moviebox.repository.ReviewRepository;
import com.remythompson.moviebox.moviebox.repository.UserRepository;
import com.remythompson.moviebox.moviebox.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        userRepository.findById(reviewDto.userId()).orElseThrow(UserNotFoundException::new);

        ReviewEntity reviewEntity = reviewMapper.toEntity(reviewDto);

        ReviewEntity newReviewEntity = reviewRepository.save(reviewEntity);

        return reviewMapper.toDto(newReviewEntity);
    }

    @Override
    public ReviewListResponse getReviewsByMovieId(Long movieId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<ReviewEntity> reviews = reviewRepository.findAllByMovieId(movieId, pageable);
        List<ReviewEntity> reviewEntityList = reviews.getContent();

        List<ReviewDto> content =
                reviewEntityList.stream().map(reviewMapper::toDto).collect(Collectors.toList());

        return ReviewListResponse.builder()
                .content(content)
                .pageNumber(reviews.getNumber())
                .pageSize(reviews.getSize())
                .totalPages(reviews.getTotalPages())
                .totalElements(reviews.getTotalElements())
                .last(reviews.isLast())
                .build();
    }

    @Override
    public ReviewDto getReviewById(Long id) {
        ReviewEntity reviewEntity = reviewRepository.findById(id).orElseThrow(ReviewNotFoundException::new);

        return reviewMapper.toDto(reviewEntity);
    }

    @Override
    public ReviewDto updateReview(ReviewDto reviewDto, Long id){
        ReviewEntity reviewEntity = reviewRepository.findById(id).orElseThrow(
                () -> new ReviewNotFoundException("Review could not be updated"));

        reviewEntity.setText(reviewDto.text());
        reviewEntity.setTitle(reviewDto.title());
        reviewEntity.setMovieId(reviewDto.movieId());
        reviewEntity.setRating(reviewDto.rating());

        ReviewEntity updatedReviewEntity = reviewRepository.save(reviewEntity);
        return reviewMapper.toDto(updatedReviewEntity);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.findById(id).orElseThrow(ReviewNotFoundException::new);
        reviewRepository.deleteById(id);
    }
}
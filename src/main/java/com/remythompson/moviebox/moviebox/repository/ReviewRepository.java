package com.remythompson.moviebox.moviebox.repository;

import com.remythompson.moviebox.moviebox.model.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    Page<ReviewEntity> findAllByMovieId(Long movieId, Pageable pageable);
}

package com.remythompson.moviebox.moviebox.repository;

import com.remythompson.moviebox.moviebox.model.FavouriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<FavouriteEntity, Long> {
    public List<FavouriteEntity> findAllByUserId(Long movieId);
}

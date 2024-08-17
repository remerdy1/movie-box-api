package com.remythompson.moviebox.moviebox.repository;

import com.remythompson.moviebox.moviebox.model.WatchedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchedRepository extends JpaRepository<WatchedEntity, Long> {
    List<WatchedEntity> findAllByUserId(Long userId);
}

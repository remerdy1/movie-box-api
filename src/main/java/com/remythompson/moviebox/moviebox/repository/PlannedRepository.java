package com.remythompson.moviebox.moviebox.repository;

import com.remythompson.moviebox.moviebox.model.PlannedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlannedRepository extends JpaRepository<PlannedEntity, Long> {
    List<PlannedEntity> findAllByUserId(Long userId);
}

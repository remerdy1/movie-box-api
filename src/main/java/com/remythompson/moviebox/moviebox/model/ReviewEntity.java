package com.remythompson.moviebox.moviebox.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255, columnDefinition = "VARCHAR(255)")
    private String title;
    private String text;
    private int rating;
    private Long movieId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}

package com.examportal.resultservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "score_review_history")
public class ScoreReviewHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long resultId;

    private Long reviewedBy;

    private Double oldScore;

    private Double newScore;

    private String oldGrade;

    private String newGrade;

    private String reviewReason;

    private LocalDateTime reviewedAt;

    // getters setters
}
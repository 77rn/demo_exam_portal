package com.examportal.resultservice.dto;

import java.time.LocalDateTime;

public class ScoreReviewHistoryDTO {

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
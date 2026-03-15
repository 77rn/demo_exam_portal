package com.examportal.resultservice.dto;

import java.time.LocalDateTime;

public class ExamDTO {

    private Long id;
    private Long subjectId;
    private String examTitle;
    private LocalDateTime examDate;
    private Integer durationMinutes;
    private Long createdBy;

    // getters setters
}
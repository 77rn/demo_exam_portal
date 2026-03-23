package com.examportal.resultservice.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ResultResponseDTO {

    private Long id;

    private Long examId;
    private String examTitle;

    private Long userId;
    private String username;

    private Integer score;
    private String grade;

    private LocalDateTime evaluatedAt;

    public ResultResponseDTO() {
    }

    // getters setters
}
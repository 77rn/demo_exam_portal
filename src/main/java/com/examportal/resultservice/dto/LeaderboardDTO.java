package com.examportal.resultservice.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeaderboardDTO {

    private String username;
    private String examTitle;

    private Integer score;
    private String grade;

    public LeaderboardDTO() {
    }

    // getters setters
}
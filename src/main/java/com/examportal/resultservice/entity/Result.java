package com.examportal.resultservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long examId;

    private Long userId;

    private Double score;

    private String grade;

    private LocalDateTime evaluatedAt;

    // getters setters
}
package com.examportal.resultservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long subjectId;

    private String examTitle;

    private LocalDateTime examDate;

    private Integer durationMinutes;

    private Long createdBy;

    // getters setters
}
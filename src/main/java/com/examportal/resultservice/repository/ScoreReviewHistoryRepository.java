package com.examportal.resultservice.repository;

import com.examportal.resultservice.dto.ResultResponseDTO;
import com.examportal.resultservice.dto.ResultReviewRequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.resultservice.entity.ScoreReviewHistory;

public interface ScoreReviewHistoryRepository
        extends JpaRepository<ScoreReviewHistory, Long> {

    ResultResponseDTO reviewResult(ResultReviewRequestDTO request);
}
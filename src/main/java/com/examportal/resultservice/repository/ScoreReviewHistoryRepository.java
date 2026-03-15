package com.examportal.resultservice.repository;

import com.examportal.resultservice.entity.ScoreReviewHistory;
import com.examportal.resultservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreReviewHistoryRepository extends JpaRepository<ScoreReviewHistory, Long> {
}
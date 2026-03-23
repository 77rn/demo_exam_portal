package com.examportal.resultservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.resultservice.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByUserId(Long userId);

    List<Result> findByExamId(Long examId);

    List<Result> findByExamIdOrderByScoreDesc(Long examId);
}
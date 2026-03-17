package com.examportal.resultservice.repository;

import com.examportal.resultservice.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByUserId(Long userId);

    List<Result> findByExamId(Long examId);

    List<Result> findByExamIdOrderByScoreDesc(Long examId);

}
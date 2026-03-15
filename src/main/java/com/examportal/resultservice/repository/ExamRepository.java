package com.examportal.resultservice.repository;

import com.examportal.resultservice.entity.Exam;
import com.examportal.resultservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
package com.examportal.resultservice.repository;

import com.examportal.resultservice.entity.Exams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamsRepository extends JpaRepository<Exams, Long> {
}
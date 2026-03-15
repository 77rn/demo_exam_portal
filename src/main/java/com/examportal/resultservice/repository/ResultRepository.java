package com.examportal.resultservice.repository;

import com.examportal.resultservice.entity.Result;
import com.examportal.resultservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
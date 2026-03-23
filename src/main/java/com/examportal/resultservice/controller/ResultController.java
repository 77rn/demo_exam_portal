package com.examportal.resultservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.examportal.resultservice.dto.ResultResponseDTO;
import com.examportal.resultservice.dto.LeaderboardDTO;

import com.examportal.resultservice.service.ResultService;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;


    // ✅ GET /results
    @GetMapping
    public List<ResultResponseDTO> getAllResults() {

        return resultService.getAllResults();
    }


    // ✅ GET /results/{id}
    @GetMapping("/{id}")
    public ResultResponseDTO getResultById(@PathVariable Long id) {

        return resultService.getResultById(id);
    }


    // ✅ GET /results/user/{userId}
    @GetMapping("/user/{userId}")
    public List<ResultResponseDTO> getResultsByUserId(
            @PathVariable Long userId) {

        return resultService.getResultsByUserId(userId);
    }


    // ✅ GET /results/exam/{examId}
    @GetMapping("/exam/{examId}")
    public List<ResultResponseDTO> getResultsByExamId(
            @PathVariable Long examId) {

        return resultService.getResultsByExamId(examId);
    }


    // ✅ GET /results/leaderboard/{examId}
    @GetMapping("/leaderboard/{examId}")
    public List<LeaderboardDTO> getLeaderboard(
            @PathVariable Long examId) {

        return resultService.getLeaderboardByExamId(examId);
    }
}
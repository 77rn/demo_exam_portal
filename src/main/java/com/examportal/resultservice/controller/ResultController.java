package com.examportal.resultservice.controller;

import java.util.List;

import com.examportal.resultservice.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.examportal.resultservice.dto.ResultDTO;
import com.examportal.resultservice.service.ResultService;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;


    // GET /results
    @GetMapping
    public List<ResultDTO> getAllResults() {

        return resultService.getAllResults();
    }


    // GET /results/{id}
    @GetMapping("/{id}")
    public ResultDTO getResultById(@PathVariable Long id) {

        return resultService.getResultById(id);
    }


    // GET /results/user/{userId}
    @GetMapping("/user/{userId}")
    public List<ResultDTO> getResultsByUserId(@PathVariable Long userId) {

        return resultService.getResultsByUserId(userId);
    }


    // GET /results/exam/{examId}
    @GetMapping("/exam/{examId}")
    public List<ResultDTO> getResultsByExamId(@PathVariable Long examId) {

        return resultService.getResultsByExamId(examId);
    }

}
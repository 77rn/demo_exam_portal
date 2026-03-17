package com.examportal.resultservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.resultservice.dto.ResultDTO;
import com.examportal.resultservice.entity.Result;
import com.examportal.resultservice.entity.User;
import com.examportal.resultservice.entity.Exam;
import com.examportal.resultservice.repository.ResultRepository;
import com.examportal.resultservice.repository.UserRepository;
import com.examportal.resultservice.repository.ExamRepository;
import com.examportal.resultservice.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExamRepository examRepository;


    private ResultDTO convertToDTO(Result result) {

        ResultDTO dto = new ResultDTO();

        dto.setId(result.getId());
        dto.setExamId(result.getExamId());
        dto.setUserId(result.getUserId());
        dto.setScore(result.getScore());
        dto.setGrade(result.getGrade());
        dto.setEvaluatedAt(result.getEvaluatedAt());


        User user = userRepository
                .findById(result.getUserId())
                .orElse(null);

        if (user != null) {
            dto.setUsername(user.getUsername());
        }


        Exam exam = examRepository
                .findById(result.getExamId())
                .orElse(null);

        if (exam != null) {
            dto.setExamTitle(exam.getExamTitle());
        }

        return dto;
    }


    @Override
    public List<ResultDTO> getAllResults() {

        List<Result> results = resultRepository.findAll();

        return results.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public ResultDTO getResultById(Long id) {

        Result result = resultRepository.findById(id).orElse(null);

        if (result == null) return null;

        return convertToDTO(result);
    }


    @Override
    public List<ResultDTO> getResultsByUserId(Long userId) {

        List<Result> results = resultRepository.findByUserId(userId);

        return results.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<ResultDTO> getResultsByExamId(Long examId) {

        List<Result> results = resultRepository.findByExamId(examId);

        return results.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResultDTO> getLeaderboardByExamId(Long examId) {

        List<Result> results =
                resultRepository.findByExamIdOrderByScoreDesc(examId);

        return results.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
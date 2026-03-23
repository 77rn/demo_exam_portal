package com.examportal.resultservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.resultservice.dto.ResultResponseDTO;
import com.examportal.resultservice.dto.LeaderboardDTO;

import com.examportal.resultservice.entity.Result;
import com.examportal.resultservice.entity.User;
import com.examportal.resultservice.entity.Exams;

import com.examportal.resultservice.repository.ResultRepository;
import com.examportal.resultservice.repository.UserRepository;
import com.examportal.resultservice.repository.ExamsRepository;

import com.examportal.resultservice.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExamsRepository examsRepository;


    // ✅ convert to ResultResponseDTO
    private ResultResponseDTO convertToDTO(Result result) {

        ResultResponseDTO dto = new ResultResponseDTO();

        dto.setId(result.getId());
        dto.setExamId(result.getExamId());
        dto.setUserId(result.getUserId());
        dto.setScore(result.getScore());
        dto.setGrade(result.getGrade());
        dto.setEvaluatedAt(result.getEvaluatedAt());

        User user =
                userRepository.findById(result.getUserId()).orElse(null);

        if (user != null) {
            dto.setUsername(user.getUsername());
        }

        Exams exam =
                examsRepository.findById(result.getExamId()).orElse(null);

        if (exam != null) {
            dto.setExamTitle(exam.getExamTitle());
        }

        return dto;
    }


    // ✅ convert to LeaderboardDTO
    private LeaderboardDTO convertToLeaderboardDTO(Result result) {

        LeaderboardDTO dto = new LeaderboardDTO();

        dto.setScore(result.getScore());
        dto.setGrade(result.getGrade());

        User user =
                userRepository.findById(result.getUserId()).orElse(null);

        if (user != null) {
            dto.setUsername(user.getUsername());
        }

        Exams exam =
                examsRepository.findById(result.getExamId()).orElse(null);

        if (exam != null) {
            dto.setExamTitle(exam.getExamTitle());
        }

        return dto;
    }


    @Override
    public List<ResultResponseDTO> getAllResults() {

        return resultRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public ResultResponseDTO getResultById(Long id) {

        Result result =
                resultRepository.findById(id).orElse(null);

        if (result == null) return null;

        return convertToDTO(result);
    }


    @Override
    public List<ResultResponseDTO> getResultsByUserId(Long userId) {

        return resultRepository.findByUserId(userId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<ResultResponseDTO> getResultsByExamId(Long examId) {

        return resultRepository.findByExamId(examId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<LeaderboardDTO> getLeaderboardByExamId(Long examId) {

        return resultRepository
                .findByExamIdOrderByScoreDesc(examId)
                .stream()
                .map(this::convertToLeaderboardDTO)
                .collect(Collectors.toList());
    }
}
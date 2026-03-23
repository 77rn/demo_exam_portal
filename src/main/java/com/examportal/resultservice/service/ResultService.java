package com.examportal.resultservice.service;

import java.util.List;

import com.examportal.resultservice.dto.LeaderboardDTO;
import com.examportal.resultservice.dto.ResultResponseDTO;

public interface ResultService {

    List<ResultResponseDTO> getAllResults();

    ResultResponseDTO getResultById(Long id);

    List<ResultResponseDTO> getResultsByUserId(Long userId);

    List<ResultResponseDTO> getResultsByExamId(Long examId);

    List<LeaderboardDTO> getLeaderboardByExamId(Long examId);

}
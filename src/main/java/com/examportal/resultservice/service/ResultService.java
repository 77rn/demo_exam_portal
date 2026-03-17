package com.examportal.resultservice.service;

import java.util.List;

import com.examportal.resultservice.dto.ResultDTO;

public interface ResultService {

    List<ResultDTO> getAllResults();

    ResultDTO getResultById(Long id);

    List<ResultDTO> getResultsByUserId(Long userId);

    List<ResultDTO> getResultsByExamId(Long examId);

    List<ResultDTO> getLeaderboardByExamId(Long examId);

}
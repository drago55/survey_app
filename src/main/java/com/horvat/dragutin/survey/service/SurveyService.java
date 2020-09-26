package com.horvat.dragutin.survey.service;

import com.horvat.dragutin.survey.dto.SurveyDto;
import com.horvat.dragutin.survey.model.Survey;

import java.util.List;

public interface SurveyService {

    List<SurveyDto> findAll();

    SurveyDto findOneById(Long id);

    void delete(Long id);

    SurveyDto update(SurveyDto surveyDto, Long id);

    SurveyDto save(SurveyDto surveyDto);
}

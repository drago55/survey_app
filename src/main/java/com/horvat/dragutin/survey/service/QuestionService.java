package com.horvat.dragutin.survey.service;

import com.horvat.dragutin.survey.dto.QuestionDto;
import com.horvat.dragutin.survey.model.Question;
import com.horvat.dragutin.survey.model.Survey;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface QuestionService {

    List<QuestionDto> findAll();

    QuestionDto findOneById(Long id);

    QuestionDto save(QuestionDto question);

    QuestionDto update(QuestionDto questionDto, Long id);

    void delete(Long id);
}

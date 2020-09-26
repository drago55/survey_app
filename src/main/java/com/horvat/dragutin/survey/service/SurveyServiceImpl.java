package com.horvat.dragutin.survey.service;

import com.horvat.dragutin.survey.dto.SurveyDto;
import com.horvat.dragutin.survey.exception.SurveyException;
import com.horvat.dragutin.survey.model.Survey;
import com.horvat.dragutin.survey.repository.*;
import com.horvat.dragutin.survey.util.ObjectMapperUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SurveyServiceImpl implements SurveyService{

    private final InputTypeRepository inputTypeRepository;
    private final QuestionRepository questionRepository;
    private final OptionGroupRepository optionGroupRepository;
    private final OptionsRepository optionsRepository;
    private final UserRepository userRepository;
    private final SurveyRepository surveyRepository;

    public SurveyServiceImpl(InputTypeRepository inputTypeRepository,
                             QuestionRepository questionRepository,
                             OptionGroupRepository optionGroupRepository,
                             OptionsRepository optionsRepository,
                             UserRepository userRepository,
                             SurveyRepository surveyRepository)
    {
        this.inputTypeRepository = inputTypeRepository;
        this.questionRepository = questionRepository;
        this.optionGroupRepository = optionGroupRepository;
        this.optionsRepository = optionsRepository;
        this.userRepository = userRepository;
        this.surveyRepository = surveyRepository;
    }


    @Override
    public List<SurveyDto> findAll() {
        return ObjectMapperUtils.mapAll(surveyRepository.findAll(), SurveyDto.class);
    }

    @Override
    public SurveyDto findOneById(Long id) {

        Optional<Survey> optionalOfSurvey = surveyRepository.findById(id);

        if(optionalOfSurvey.isEmpty()){
            throw new SurveyException("Can't find survey with id: " + id , "ES1");
        }

        return ObjectMapperUtils.map(optionalOfSurvey.get(), SurveyDto.class);
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public SurveyDto update(SurveyDto surveyDto, Long id) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public SurveyDto save(SurveyDto surveyDto) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }
}

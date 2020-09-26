package com.horvat.dragutin.survey.service;

import com.horvat.dragutin.survey.dto.QuestionDto;
import com.horvat.dragutin.survey.exception.SurveyException;
import com.horvat.dragutin.survey.model.Question;
import com.horvat.dragutin.survey.repository.*;
import com.horvat.dragutin.survey.util.ObjectMapperUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

    private final InputTypeRepository inputTypeRepository;
    private final QuestionRepository questionRepository;
    private final OptionGroupRepository optionGroupRepository;
    private final OptionsRepository optionsRepository;
    private final UserRepository userRepository;

    public QuestionServiceImpl(InputTypeRepository inputTypeRepository,
                               QuestionRepository questionRepository,
                               OptionGroupRepository optionGroupRepository,
                               OptionsRepository optionsRepository,
                               UserRepository userRepository) {

        this.inputTypeRepository = inputTypeRepository;
        this.questionRepository = questionRepository;
        this.optionGroupRepository = optionGroupRepository;
        this.optionsRepository = optionsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<QuestionDto> findAll() {
        return ObjectMapperUtils.mapAll(questionRepository.findAll(), QuestionDto.class);
    }

    @Override
    public QuestionDto findOneById(Long id) {

        Optional<Question> optionalOfSurvey = questionRepository.findById(id);

        if(optionalOfSurvey.isEmpty()){
            throw new SurveyException("Can't find question with id: " + id , "ES2");
        }

        return ObjectMapperUtils.map(optionalOfSurvey.get(), QuestionDto.class);

    }

    @Override
    public QuestionDto save(QuestionDto question) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public QuestionDto update(QuestionDto questionDto, Long id) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }
}

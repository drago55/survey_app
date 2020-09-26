package com.horvat.dragutin.survey.controllers;

import com.horvat.dragutin.survey.dto.SurveyDto;
import com.horvat.dragutin.survey.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurveyController {

    private final Logger logger = LoggerFactory.getLogger(SurveyController.class);

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/survey")
    public List<SurveyDto> findAll(){
        return surveyService.findAll();
    }
    @PostMapping("/survey")
    public SurveyDto save(@RequestBody SurveyDto surveyDto){
        return surveyService.save(surveyDto);
    }

    @GetMapping("/survey/{id}")
    public SurveyDto findOne(@PathVariable Long id){
        return surveyService.findOneById(id);
    }

    @PutMapping(value = "/survey/{id}")
    public SurveyDto update(@RequestBody SurveyDto surveyDto, @PathVariable Long id){
        return surveyService.update(surveyDto, id);
    }

    @DeleteMapping("/survey/{id}")
    public void delete(@PathVariable Long id){
        surveyService.delete(id);
    }

}

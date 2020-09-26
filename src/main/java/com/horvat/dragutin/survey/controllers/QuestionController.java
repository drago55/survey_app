package com.horvat.dragutin.survey.controllers;

import com.horvat.dragutin.survey.dto.QuestionDto;
import com.horvat.dragutin.survey.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    private final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/question/")
    public List<QuestionDto> findAll(){
        return questionService.findAll();
    }

    @PostMapping("/question/save")
    public QuestionDto save(@RequestBody QuestionDto questionDto){
        return questionService.save(questionDto);
    }

    @GetMapping("/question/{id}")
    public QuestionDto findOne(@PathVariable Long id){
        return questionService.findOneById(id);
    }

    @PutMapping("/question/update/{id}")
    public QuestionDto update(@RequestBody QuestionDto questionDto, @PathVariable Long id){
        return questionService.update(questionDto, id);
    }

    @DeleteMapping("/question/delete/{id}")
    public void delete(@PathVariable Long id){
        questionService.delete(id);
    }

}

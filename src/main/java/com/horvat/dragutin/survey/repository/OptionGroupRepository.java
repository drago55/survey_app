package com.horvat.dragutin.survey.repository;

import com.horvat.dragutin.survey.model.OptionGroup;
import com.horvat.dragutin.survey.enums.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OptionGroupRepository extends JpaRepository<OptionGroup, Long> {
    Set<OptionGroup> findAllByQuestionType(QuestionType matrixQuestions);
}

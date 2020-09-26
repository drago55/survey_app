package com.horvat.dragutin.survey.repository;

import com.horvat.dragutin.survey.model.InputType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputTypeRepository extends JpaRepository<InputType, Long> {

    InputType findByCode(Integer code);

}

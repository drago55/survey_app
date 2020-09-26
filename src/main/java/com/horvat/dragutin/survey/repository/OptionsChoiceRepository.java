package com.horvat.dragutin.survey.repository;

import com.horvat.dragutin.survey.model.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsChoiceRepository extends JpaRepository<Options, Long> {
}

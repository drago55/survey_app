package com.horvat.dragutin.survey.repository;

import com.horvat.dragutin.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

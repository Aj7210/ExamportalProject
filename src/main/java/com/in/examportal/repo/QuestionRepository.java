package com.in.examportal.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.examportal.Entity.Question;
import com.in.examportal.Entity.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);
	
}

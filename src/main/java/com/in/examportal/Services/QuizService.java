package com.in.examportal.Services;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.in.examportal.Entity.Category;
import com.in.examportal.Entity.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Quiz getQuiz(Long quizId);
	
	public Set<Quiz> getQuizzes();
	
	public void deleteQuiz(Long quizId);

	public List<Quiz> getQuizzesOfCategory(Category category);
	
	public List<Quiz> getActiveQuizzes();
	
	public List<Quiz> getActiveQuizzesOfCategory(Category c);
}

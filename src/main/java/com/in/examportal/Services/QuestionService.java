package com.in.examportal.Services;

import java.util.Set;


import com.in.examportal.Entity.Question;
import com.in.examportal.Entity.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Question getQuestion(Long questionId);
	
	public Set<Question> getQuestions();
	
	public void deleteQuestion(Long questionId);
     
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	public Question get(Long questionId );

}

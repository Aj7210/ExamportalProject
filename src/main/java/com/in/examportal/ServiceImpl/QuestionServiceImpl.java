package com.in.examportal.ServiceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.examportal.Entity.Question;
import com.in.examportal.Entity.Quiz;
import com.in.examportal.Services.QuestionService;
import com.in.examportal.repo.QuestionRepository;


@Service
public class QuestionServiceImpl  implements QuestionService{

	@Autowired
	public QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);
	}

	@Override
	public Question getQuestion(Long questionId) {
		// TODO Auto-generated method stub
		return this.questionRepository.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestions() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.questionRepository.findAll()) ;
	}

	@Override
	public void deleteQuestion(Long questionId) {
		// TODO Auto-generated method stub
		Question question=new Question();
		question.setQuesId(questionId);
		this.questionRepository.delete(question);
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.questionRepository.findByQuiz( quiz);
	}

	@Override
	public Question get(Long questionId) {
		// TODO Auto-generated method stub
		return this.questionRepository.getOne(questionId);
	}

}

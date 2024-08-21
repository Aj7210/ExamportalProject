package com.in.examportal.controller;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.examportal.Entity.Question;
import com.in.examportal.Entity.Quiz;
import com.in.examportal.Services.QuestionService;
import com.in.examportal.Services.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	public QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	@PostMapping("/")
	
	public ResponseEntity<?> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@GetMapping("/{questionId}")
	public Question getQuestion(@PathVariable("questionId") Long questionId ) {
		return this.questionService.getQuestion(questionId);
	}
	
	@GetMapping("/")
	public Set<Question> getQuestions(){
		return this.questionService.getQuestions();
	}
	
	@PutMapping("/")
	
		public Question updateQuestion(@RequestBody Question question) {
			return this.questionService.updateQuestion(question);
		}
	
	@DeleteMapping("/{questionId}")
	
	public void deleteQuestion(@PathVariable("questionId") Long questionId) {
		this.questionService.deleteQuestion(questionId);
	}
	
	// get all question by quizid
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionsByQuiz(@PathVariable("quizId") Long quizId){
//		Quiz quiz=new Quiz();
//		quiz.setQid(quizId);
//		
//		Set<Question> questionOfQuiz=this.questionService.getQuestionsOfQuiz(quiz);
//	    return ResponseEntity.ok(questionOfQuiz); 
		Quiz quiz= this.quizService.getQuiz(quizId);
		Set<Question> questions=quiz.getQuestions();
		List list=new ArrayList(questions);
		if(list.size()> Integer.parseInt(quiz.getNumberOfQuestion()))
		{
			list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion()+1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	
	}
	//evaluate quiz
	@PostMapping("/evalquiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions)
	{
		System.out.println(questions);
		double markgot=0;
		int correctAnswers=0;
	    int attempted=0;
		
		for(Question q:questions) {
			// single question
			Question question=this.questionService.get(q.getQuesId());	
		    if(question.getAnswer().equals(q.getGivenAnswer()))
		    {
		    	//corect
		    	correctAnswers++;
		    	
		    	double markSingle=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
		        markgot += markSingle;
		    }
		    
		    if(q.getGivenAnswer()!=null||q.getGivenAnswer().trim().equals(""))
		    {
		    	attempted++;
		    }
		};
		
		Map<String,Object> map=Map.of("markgot",markgot,"correctAnswers",correctAnswers,"attempted",attempted);
		
		return ResponseEntity.ok(map);
	}
	
	
	}
	


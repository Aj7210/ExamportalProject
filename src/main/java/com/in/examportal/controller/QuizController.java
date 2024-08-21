package com.in.examportal.controller;

import java.util.List;
import java.util.Set;

import org.apache.catalina.connector.Response;
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

import com.in.examportal.Entity.Category;
import com.in.examportal.Entity.Quiz;
import com.in.examportal.Services.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	public QuizService quizService;
	
	
	//add quiz
	@PostMapping("/")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
	  Quiz quiz1=this.quizService.addQuiz(quiz);
	  return ResponseEntity.ok(quiz1);
	}
	
	//get quiz
	@GetMapping("/{quizId}")
	public Quiz getQuiz(@PathVariable("quizId") Long quizId) {
		return this.quizService.getQuiz(quizId);
	}
	// get all quiz
	
	@GetMapping("/")
	public Set<Quiz> getAllQuizs(){
		return this.quizService.getQuizzes();
	}
   // update quiz
	@PutMapping("/")
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		return this.quizService.updateQuiz(quiz);
	}
	
	//delete 
	@DeleteMapping("/{quizId}")
	public void deleteQuiz(@PathVariable("quizId") Long quizId) {
		 this.quizService.deleteQuiz(quizId);
	}
	
	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid)
	{
		
		Category category=new Category();
		category.setCid(cid);
		return this.quizService.getQuizzesOfCategory(category);
	}
	//get active quizess
	@GetMapping("/active")
	public List<Quiz> getActiveQuizs()
	{
		return this.quizService.getActiveQuizzes();
	}
	
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizsOfcategory(@PathVariable("cid")Long cid)
	{
		Category category=new Category();
		category.setCid(cid);
		return this.quizService.getActiveQuizzesOfCategory(category);
	}
	
	
}

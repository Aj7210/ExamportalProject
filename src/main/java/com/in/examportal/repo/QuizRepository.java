package com.in.examportal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.examportal.Entity.Category;
import com.in.examportal.Entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	public List<Quiz> findByCategory(Category category);
    
	public List<Quiz> findByActive(Boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category c,Boolean b); 


}

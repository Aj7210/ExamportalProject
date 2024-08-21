package com.in.examportal.controller;

import java.security.PublicKey;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.examportal.Entity.Category;
import com.in.examportal.Services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	//add category
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category cateory){
		
		Category category1=this.categoryService.addCategory(cateory);
	    return ResponseEntity.ok(category1);
	
	}
	
	//get category
	
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		return this.categoryService.getCategory(categoryId);
	}
	
	//get all category
	
	@GetMapping("/")
	public Set<Category> getAllCategories(){
		return this.categoryService.getCategories();
	}
	//update category
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		
		return this.categoryService.updateCategory(category);
		
	}
	
	@DeleteMapping("/{categoryId}")
	public void deleteCategory( @PathVariable("categoryId")Long categoryId) {
		this.categoryService.deleteCategory(categoryId);
	}
	
	
	

}

package com.in.examportal.Services;

import java.util.Set;

import com.in.examportal.Entity.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);

	public Category updateCategory(Category category);
	
	public void deleteCategory(Long categoryId);
	
	public Category getCategory(Long categoryId);
	
	public Set<Category> getCategories();
}

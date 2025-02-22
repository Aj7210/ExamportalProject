package com.in.examportal.ServiceImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.examportal.Entity.Category;
import com.in.examportal.Services.CategoryService;
import com.in.examportal.repo.CategoryRepository;


@Service
public class CategoryServiceImpl  implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		//this.categoryRepository.deleteById(categoryId);
	   Category category=new Category();
	   category.setCid(categoryId);
	   this.categoryRepository.delete(category);
	}

	@Override
	public Category getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(categoryId).get();
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>( this.categoryRepository.findAll());
	}

}

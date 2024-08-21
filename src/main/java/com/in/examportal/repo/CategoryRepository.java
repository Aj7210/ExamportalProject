package com.in.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.examportal.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

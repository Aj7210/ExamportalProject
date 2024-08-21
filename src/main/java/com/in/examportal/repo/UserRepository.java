package com.in.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.examportal.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User  findByUsername(String username);
	
	
}

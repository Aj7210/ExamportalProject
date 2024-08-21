package com.in.examportal.Services;

import java.util.Set;

import com.in.examportal.Entity.User;
import com.in.examportal.Entity.UserRole;

public interface UserService {
	
	// creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;

	
	//get user by username
	public User getUser(String username);
	
	//delete user by id
	public void deleteUser(Long userId );
}

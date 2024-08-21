package com.in.examportal.controller;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.query.UnknownNamedQueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.examportal.Entity.Role;
import com.in.examportal.Entity.User;
import com.in.examportal.Entity.UserRole;
import com.in.examportal.Services.UserService;
import com.in.examportal.helper.UserFoundException;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		user.setProfile("fav.png");
		// encoding password with bcryptpasswordencoder
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Set<UserRole> roles=new HashSet<>();
		Role role=new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
	}
	
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username )
	{
		return this.userService.getUser(username);
	}
	
	
	//delete user by userid
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable ("userId") Long userId) {
		
		this.userService.deleteUser(userId);
	}
	
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?>exceptionHandler(UserFoundException ex){return ResponseEntity.ok(ex.getMessage());}

}

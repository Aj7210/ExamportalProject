package com.in.examportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.in.examportal.Entity.Role;
import com.in.examportal.Entity.User;
import com.in.examportal.Entity.UserRole;
import com.in.examportal.Services.UserService;

@SpringBootApplication
public class ExamportalApplication  implements CommandLineRunner{

	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("starting code");
//        User user=new User();
//		user.setFirstName("arti");
//     	user.setLastName("jadhav");
//		user.setUsername("arti123");
//		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
//		user.setEmail("abj@gmail.com");
//		Role role1=new Role();
//		role1.setRoleId(12L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userrole =new UserRole();
//		userrole.setRole(role1);
//		userrole.setUser(user);
//		userRoleSet.add(userrole);
//		
//		User user1=this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getFirstName());
	
		
	}
	
}

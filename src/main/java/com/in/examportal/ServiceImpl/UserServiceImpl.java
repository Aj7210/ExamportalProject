package com.in.examportal.ServiceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.examportal.Entity.User;
import com.in.examportal.Entity.UserRole;
import com.in.examportal.Services.UserService;
import com.in.examportal.repo.RoleRepository;
import com.in.examportal.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null)
		{
			System.out.println("User is already there!");
		    throw new Exception("user already present");
		}
		else {
			
				//create user
				for(UserRole ur:userRoles)
				{
					roleRepository.save(ur.getRole());
			   	}
				
				user.getUserRoles().addAll(userRoles);
				this.userRepository.save(user);
			}
		
				
				return local;
	}


	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}


	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
		
	}

}

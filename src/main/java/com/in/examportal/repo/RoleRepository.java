package com.in.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.examportal.Entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

	
	
}

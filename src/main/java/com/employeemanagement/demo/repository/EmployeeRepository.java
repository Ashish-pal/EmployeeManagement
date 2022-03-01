package com.employeemanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagement.demo.model.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
	
	EmployeeEntity findByEmail(String email);
	EmployeeEntity findByToken(String token);
	
}

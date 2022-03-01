package com.employeemanagement.demo.service;

import java.util.List;

import com.employeemanagement.demo.model.EmployeeEntity;

public interface EmployeeService {
	
	public EmployeeEntity addEmployee(EmployeeEntity employee);
	public List<EmployeeEntity> getEmployee();
	public EmployeeEntity getById(int id);
	EmployeeEntity updateEmployee(int id, EmployeeEntity employee);
	void deleteById(int id);
	public String login(String employeEmail, String password);
	public String forgetPassword(String employeEmail, String newPassword);
	
}

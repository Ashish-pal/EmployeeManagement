package com.employeemanagement.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.demo.model.EmployeeEntity;
import com.employeemanagement.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplement implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

//	public EmployeeServiceImplement(EmployeeRepository employeeRepo) {
//		super();
//		this.employeeRepo = employeeRepo;
//	}

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<EmployeeEntity> getEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public EmployeeEntity getById(int id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public EmployeeEntity updateEmployee(int id, EmployeeEntity employee) {
		EmployeeEntity updatemployee = employeeRepo.findById(id).get();
		updatemployee.setFname(employee.getFname());
		updatemployee.setLname(employee.getLname());
		updatemployee.setEmail(employee.getEmail());
		return employeeRepo.save(updatemployee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public String login(String employeeEmail, String password) {
		List<EmployeeEntity> employeeList = employeeRepo.findAll();
		for (EmployeeEntity employeeEntity : employeeList) {
			if (employeeEntity.getEmail().equals(employeeEmail)) {
				try {
					try {
						if (employeeEntity.getPassword().equals(password)) {
							return "log in successfully" ;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "login failed";
	}

	@Override
	public String forgetPassword(String employeEmail, String newPassword) {
		List<EmployeeEntity> employeeList = employeeRepo.findAll();
		for (EmployeeEntity employeeEntity : employeeList) {
			try {
				if (employeeEntity.getEmail().equals(employeEmail)) {
					employeeEntity.setPassword(newPassword);
					addEmployee(employeeEntity);
					return "password updated successfully";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "data not matched, please check again";
	}
}

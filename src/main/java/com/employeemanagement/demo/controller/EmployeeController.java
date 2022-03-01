package com.employeemanagement.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.demo.model.EmployeeEntity;
import com.employeemanagement.demo.service.EmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/saveEmployee")
	public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employee) {
		return new ResponseEntity<EmployeeEntity>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/getEmployee")
	public List<EmployeeEntity> getEmployee() {
		return employeeService.getEmployee();
	}

	@GetMapping("/getEmployee/{id}")
	public EmployeeEntity getById(@PathVariable("id") int id) {
		return employeeService.getById(id);
	}

	@PutMapping("/updateEmployee/{id}")
	public EmployeeEntity updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeEntity employe) {
		return employeeService.updateEmployee(id, employe);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteById(@PathVariable("id") int id) {
		employeeService.deleteById(id);
		return "Deleted Successfully";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		String employee = employeeService.login(email, password);
		return employee.toString();
	}

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	public String forgetPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
		String employee = employeeService.forgetPassword(email, password);
		return employee.toString();
	}
}

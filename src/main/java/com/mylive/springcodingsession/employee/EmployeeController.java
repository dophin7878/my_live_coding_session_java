package com.mylive.springcodingsession.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees() {
		return employeeService.retrieveAllEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> retrieveUser(@PathVariable("id") int id) {
		return employeeService.retrieveEmployee(id);
	}

	@PostMapping("/employee")
	public ResponseEntity<Object> createUser(@RequestBody Employee user) {
		return employeeService.createEmployee(user);
	}
}

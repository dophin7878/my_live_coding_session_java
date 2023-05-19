package com.mylive.springcodingsession.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> retrieveAllEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> retrieveEmployee(int id) {
		Optional<Employee> employee= employeeRepository.findById(id);
		if(!employee.isPresent()) {
			throw new UserNotFoundException("User not Found with id: "+id);
		}
		
		return employee;
	}

	public ResponseEntity<Object> createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
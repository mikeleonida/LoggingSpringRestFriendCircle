package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String welcome() {
		return "Hello from Spring Rest Employee Project";
	}
	
	@PutMapping(value = "/addemployee")
	public ResponseEntity addNewEmployee(@RequestBody Employee e) {
		if(employeeService.addEmployee(e)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<Employee> getEmployeeByNo(@PathVariable ("no")  int employeeNo ) {
		Employee employee = employeeService.getEmployeeByNo(employeeNo);
		if(employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Employee> getEmployeeByNoFromParam(@RequestParam ("no") int employeeNo ) {
		Employee employee = employeeService.getEmployeeByNo(employeeNo);
		if(employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping(value="/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		if(employeeService.getAllEmployees() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/update/{no}")
	public ResponseEntity updateEmployee(@RequestBody Employee e, @PathVariable("no") int employeeNo) {
		if(employeeService.updateEmployee(employeeNo, e)) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/delete/{no}")
	public ResponseEntity deleteEmployee(@PathVariable("no") int employeeNo) {
		if(employeeService.deleteEmployee(employeeNo)) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
}

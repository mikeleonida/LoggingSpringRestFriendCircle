package com.spring.service;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeService {
	public boolean addEmployee(Employee e);
	public boolean updateEmployee(int employeeNo, Employee e);
	public boolean deleteEmployee(int employeeNo);
	public Employee getEmployeeByNo(int employeeNo);
	public List<Employee> getAllEmployees();
}

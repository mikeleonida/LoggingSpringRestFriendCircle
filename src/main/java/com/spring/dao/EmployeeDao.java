package com.spring.dao;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeDao {
	public boolean addEmployee(Employee e);
	public boolean updateEmployee(int employeeNo, Employee e);
	public boolean deleteEmployee(int employeeNo);
	public Employee getEmployeeByNo(int employeeNo);
	public List<Employee> getAllEmployees();
}

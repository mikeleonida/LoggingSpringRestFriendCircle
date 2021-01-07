package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeDao;
import com.spring.dao.EmployeeDaoImpl;
import com.spring.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public boolean addEmployee(Employee e) {
		return employeeDao.addEmployee(e);
	}

	@Override
	public boolean updateEmployee(int employeeNo, Employee e) {
		return employeeDao.updateEmployee(employeeNo, e);
	}

	@Override
	public boolean deleteEmployee(int employeeNo) {
		return employeeDao.deleteEmployee(employeeNo);
	}

	@Override
	public Employee getEmployeeByNo(int employeeNo) {
		return employeeDao.getEmployeeByNo(employeeNo);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}
}

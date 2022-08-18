package com.emp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	// Dummy Employee list
	List<Employee> list = List.of(
			new Employee(1311L, "peterparker", "123456"),
			new Employee(1312L, "peterparke1r", "1234561"),
			new Employee(1313L, "peterparker2", "1234562"),
			new Employee(1314L, "peterparker3", "1234563"),
			new Employee(1315L, "peterparker4", "1234564"),
			new Employee(1316L, "peterparker5", "1234565"),
			new Employee(1317L, "peterparker6", "1234566")
			);
	
			
	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return list.stream().filter(employee -> employee.getEid().equals(id)).findAny().orElse(null);
	}
	}
 



package com.emp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.emp.entity.Employee;
import com.emp.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
	private EmployeeServiceImpl employeeService;
    @Autowired
    private RestTemplate restTemplate;
    
	@GetMapping("/{eid}")
    public Employee getEmployee(@PathVariable("eid") Long eid)
    {
    	Employee employee = this.employeeService.getEmployee(eid);
    	List records = this.restTemplate.getForObject("http://localhost:9090/rec/emp/" + eid, List.class);
    	employee.setRecords(records);
    	return employee;
    }
}

package com.employee.springboot.demo.crudemo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.employee.springboot.demo.crudemo.entity.Employee;
import com.employee.springboot.demo.crudemo.service.EmployeeService;

@RestController
@RequestMapping("/empApi")
public class EmployeeRestController {
	
	private EmployeeService<Employee> employeeService;	
	
	@Autowired
	public EmployeeRestController(EmployeeService<Employee> employeeService) {
		this.employeeService=employeeService;
			}
	
	//expose "/listEmployees" to return a list of employees from the database
	@GetMapping("/listEmployees")
	public List<Employee> findAll(){		
		
		return this.employeeService.findAll();
	}
	
	
	//Reading a single employee data
	@GetMapping("/employee/{employeeId}")
	public Optional<Employee> getEmployee(@PathVariable int employeeId) {
		
		Optional<Employee> employee = employeeService.findById(employeeId);
		
		if(employee == null)
			throw new RuntimeException("Employee id not found - "+employeeId);
		
		return employee;
	}
	
	//Add a new employee and persist in database
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee){
		
		//if employee id is passed in json body we set it to zero.
		employee.setId(0);
		
		employeeService.save(employee);
		
		return  employee;
	}
	
	//Update an existing an employee-- with request body we have an id of employee to be updated. 
	//The body also include employee information to be updated.
	@PutMapping("/employeeUpdate")
	public Employee updateEmployee(@RequestBody Employee employee){
		
		employeeService.save(employee);
		
		return employee;
	}
	
	
	//delete an employee based on the employee id being passed in request 
	@DeleteMapping("/employee/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		
		Optional<Employee> employee = employeeService.findById(employeeId);
		
		if(employee == null)
			throw new RuntimeException("Employee id not found - "+employeeId);
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee with id "+employeeId;
	}
	

}

package com.employee.springboot.demo.crudemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.springboot.demo.crudemo.entity.Employee;
import com.employee.springboot.demo.crudemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService<Employee> employeeService;	
		
		@Autowired
		public EmployeeController(EmployeeService<Employee> employeeService) {
			this.employeeService=employeeService;
				}
	
		
		@GetMapping("/listAll")
		public String listEmployees(Model model){
			
			List<Employee> employees = this.employeeService.findAll();
			
			//add to the spring model
			model.addAttribute("employees", employees);
			
			return "employees/list-employees";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model model){
			
			Employee employee= new Employee();
			
			/*create model attribute to bind form data
			 * The thymeleaf template will access this data for binding form data
			 */			
			model.addAttribute("employee", employee);
			
			return "employees/employee-form";
		}
		
		@PostMapping("/save")
		public String saveEmployee(@ModelAttribute("employee") Employee emp) {
			
			//save the employee
			this.employeeService.save(emp);
			
			/*
			 * Redirect to request mapping employees/listAll-- using redirect to prevent 
			 * duplicate submissions. It is implementation of Post/Redirect/Get pattern
			 */
			return "redirect:/employees/listAll"; 
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("employeeId") int empId, Model model) {
			
			//get employee from the service
			Optional<Employee> employee = this.employeeService.findById(empId);
			
			//set employee as a model attribute to pre-populate the form
			model.addAttribute("employee", employee);
			
			//send over to our form
			return "employees/employee-form";
		}
	
		@GetMapping("/delete")
		public String delete(@RequestParam("employeeId") int empId) {
			
			//delete the employee
			this.employeeService.deleteById(empId);
			
			//Redirect to request mapping employees/listAll
			return "redirect:/employees/listAll"; 
		}


}

package com.employee.springboot.demo.crudemo.service;

import java.util.List;
import java.util.Optional;


public interface EmployeeService<T> {
	
	public List<T> findAll();
	
	public Optional<T> findById(int theId);
	
	public void save(T t);
	
	public void deleteById(int theId);

}

package com.employee.springboot.demo.crudemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.springboot.demo.crudemo.dao.Dao;
import com.employee.springboot.demo.crudemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService<Employee> {
	
	private Dao<Employee> employeeDao;

	@Autowired
	public EmployeeServiceImpl(Dao<Employee> employeeDao) {
		this.employeeDao=employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Optional<Employee> findById(int theId) {
		return Optional.ofNullable(employeeDao.findById(theId));
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDao.save(employee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);
	}

}

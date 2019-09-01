package com.employee.springboot.demo.crudemo.dao;

import java.util.List;
import java.util.Optional;


public interface Dao<T> {

	public List<T> findAll();
	
	T findById(int id);
	
	void save(T t);
	
	void deleteById(int id);
	
	}



package com.employee.springboot.demo.crudemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.employee.springboot.demo.crudemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements Dao<Employee> {
	
	
	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		//get the current hibernate session
		Session session=entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> query= session.createQuery("from Employee e ORDER BY e.lastName ASC",Employee.class);
		
		//execute query and get result list
		List<Employee> employees=query.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int theId){
		//get the current hibernate session
		Session session=entityManager.unwrap(Session.class);
				
		//get the employee
		Employee employee= session.get(Employee.class,theId);
		
	    //return the results
		return employee;
		
	}

	@Override
	public void save(Employee employee) {
		//get the current hibernate session
		Session session=entityManager.unwrap(Session.class);
						
		//save the employee
		session.saveOrUpdate(employee);
				
		
		
	}

	@Override
	public void deleteById(int theId) {
		//get the current hibernate session
		Session session=entityManager.unwrap(Session.class);
								
		//create a query to delet employee with the id
		Query<Employee> query= session.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId",theId);
		
		query.executeUpdate();				
		
	}

	
	

	

}

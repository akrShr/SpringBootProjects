# SpringBootProjects
This repository will hold projects developed using Spring Boot, Thymeleaf, Hibernate

Software Version:- Spring 5
		   Hibernate 5

Project:= Employee Directory

User should be able to

	Get a list of employees

	Add a new employee

	Update an existing employee

	Delete an employee

The application should list employees on an HTML page in tabular format. The data in the table will be sorted on the last name in ascending order alphabetically.

On the top left corner, there will be a button to add an employee in the database. Once you click it a form appears to capture employee details. On saving the details, the user is redirected to the see the list of employees again.

With each row in the employee record table, we should have a button to update that employee record or delete it. On update, a prepopulated form with corresponding employee row's data appear. User can modify it and save to reflect changes on the list of employees presented in tabular format.
Once the user selects an employee to be deleted, the system will prompt us whether we want to delete the record. After the user confirms deletion the list of employees on the HTML page is refreshed. 

Code Flow
From web browser request will come to Employee Controller to Employee Service to Employee Repository and finally hit the database.
We get the data back to send it over to Thymeleaf templates. The templates give us a view to being shown in the web browser.

To interact with the database we use design pattern of Data Access Object(DAO). DAO uses the Hibernate API to access database calls. Between controller and DAO sit service layer with custom business logic. It is built on a Facade pattern.


Spring Boot application also support REST API.

HTTP Method

  GET      -> /empApi/listEmployees :  Read a list of employees
  
  GET      -> /empApi/employee/{employeeId} : Reading a single employee data
  
  POST     -> /empApi/employee : Add a new employee
  
  PUT     -> /empApi/employeeUpdate : Update an existing an employee
  
  DELETE  -> /empApi/employee/{employeeId} : Deleting a single employee data
  
  To start the application
  
  Run file CrudemoApplication.java as java application


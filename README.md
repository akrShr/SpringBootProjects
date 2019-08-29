# SpringBootProjects
This repository will hold projects developed using Spring Boot, Thymeleaf, Hibernate

Project:= Employee Directory

User should be able to
	Get a list of employees
	Add a new employee
	Update an existing employee
	Delete an employee
  

Application should list employees on HTML page in tabular format. The data in the table will be sorted on last name in ascending order alphabetically.

On top left corner there will be a button to add an employee in the database. Once you click it a form appears to capture employee details. On saving the details, the user is redirected to the see the list of employees again.

With each row in employee record table we should have button to update that employee record or delete it. On update a prepopulated form with corresponding employee row's data appear. User can modify it and save to reflect changes on the list of employees presented in tabular format.

Once user selects an employee to be deleted, system will prompt us whether we want to delete the record. After user confirms deletion the list of employees on HTMl page is refreshed. 


Code Flow

From web browser request will come to Employee Controller to Employee Service to Employee Respository and finally hit the database.
We get the data back to send it over to Thymeleaf templates. The templates give us a view to be shown in web browser.

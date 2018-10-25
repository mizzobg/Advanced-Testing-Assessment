Feature: Testing Automation using REST

Scenario: As an admin i want see all owners
	Given i search for all owners
	When we get the all deatils
	Then the correct page is loaded
  
Scenario:  As an admin i want to find an owner by Search for their Lastname
	Given i search for the owner by Lastname
	When we get the deatils using Lastname
	Then the status code reads 200
  
Scenario: As an admin i want to check owners details using ID
	Given i search for the owner by ID
	When we get the deatils
	Then they are up to date
  
Scenario: As an admin i want to update owner info
	Given i search for the owner by ID
	When we update their details
	Then the status code reads 201
	
Scenario: s an admin i want to add a new owner
	Given a new owner needs to be added
	When parameters have been added correctly
	Then the status is 201

Scenario: As an admin i want to remove a owner
	Given an owner exists within the database
	When the admin deletes the owner with a specified id
	Then the status code reads 204
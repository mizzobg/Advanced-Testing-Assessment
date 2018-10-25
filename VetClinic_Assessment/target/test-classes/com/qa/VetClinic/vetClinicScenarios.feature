Feature: Testing owners functions

Scenario: As an admin i want see all owners
	Given i search for all owners
	When we get the all deatils
	Then the correct page is loaded
  
Scenario: As an admin i want to find an owner by Search for them
	Given i search for the owner by last name
	When we open their profile
	Then verify their last name
  
Scenario: As an admin i want to update owner info
	Given i search for the owner by id
	When we open the profile
	And select edit owner
	And update their name
	Then we save the changes
	
Scenario: As an admin i want to add a new owner
	Given a new owner needs to be added
	When all parameters have been added correctly
	Then we create the new owner

Scenario: As an admin i want to remove a owner
	Given an owner exists within the database
	When the admin deletes the owner with a specified id
	Then the user is removed from all owners
	
Scenario Outline: As an admin i want to check owners details using ID
	Given i search for the owner by "<ID>"
	When we open their profile
	Then verify their "<lastName>"
	
	Examples:
    | lastName   | ID |
    | Coleman | 6 |
    | Escobito | 8 |
	| McTavish | 5 |
	| Davis | 4 |
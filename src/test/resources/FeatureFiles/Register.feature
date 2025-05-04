Feature: Registration functionality scenarios
@Register @One
Scenario: Verify whether the user is able to register into the application by providing all the details

Given I launch the application
And I navigate to Account Registration Page
When I provide all the  below valid details 
	|FirstName  |  Akhila								 |
	|LastName   |  Yandapalli					   |
	|Email      |  akhila.y@gmail.com    |
	|Telephone  |  9090909090						 |
	|Password   |  akhila								 |
	And I select the Privacy Policy
	And I click on Continue Button
	Then I shuold see that the user account has successfully been created 
	
@Register @Two
 Scenario: Verify whether the user is not allowed to register on skipping mandatory fields
  	Given I launch the application
  	And I navigate to Account Registration Page
  	When I click on Continue Button
  	Then I should see that the User Account is not created
  	And I should see the error messages informing the user to fill the mandatory fields
  	
@Register @Three
  Scenario: Verify whether the user is able to register into the application by opting for Newsletter subscription
  	Given I launch the application
  	And I navigate to Account Registration Page
  	When I provide all the  below valid details 
	|FirstName  |  Akhila								 |
	|LastName   |  Yandapalli					   |
	|Email      |  akhila.y@gmail.com    |
	|Telephone  |  9090909090						 |
	|Password   |  akhila								 |
    And I select the Privacy Policy
    And I subscribe to Newsletter
    And I click on Continue Button
   	Then I shuold see that the user account has successfully been created 
	
	@Register @Four
	Scenario: Verify whether the user is restricted from registring a duplicate account
  	Given I launch the application
  	And I navigate to Account Registration Page
  	When I provide the  below duplicate details 
	|FirstName  |  Akhila								 |
	|LastName   |  Yandapalli					   |
	|Email      |  akhila.y@gmail.com    |
	|Telephone  |  9090909090						 |
	|Password   |  akhila								 |
    And I select the Privacy Policy
    And I subscribe to Newsletter
    And I click on Continue Button
	Then I should see the warning message stating that the user is already created
	
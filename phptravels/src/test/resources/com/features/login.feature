Feature: Account
	As a visitor of the travels website
	I want to register and perform validations on login page
	@Register
	Scenario: Registering new user
  Given Open application and click on Register link

		
	@logIn
  Scenario Outline: To sign in the user
    Given I am on home page
    And I am running login attempt Number "<number>"
    When I enter login values username and password
    Then I click logIn button
    Examples: to run this scenario several times
   |number|
   | 1  	|
   | 2  	|
   | 3 		|
   | 4 		|
   | 5 		|

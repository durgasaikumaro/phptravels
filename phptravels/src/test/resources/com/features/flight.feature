Feature: Account
	As a visitor of the travels website
	I want to  book a flight
  	@flight
  Scenario: To   register the account
    Given I am on home page and i want to book a flight
    When I enter passenger details 
    Then I passenger have to book the flight
   
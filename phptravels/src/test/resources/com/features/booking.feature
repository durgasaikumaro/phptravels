Feature: Account
	As a visitor of the travels website
	I want to register and perform validations on booking page
	@booking
	Scenario: Registering new user
  Given Open application and register new user
  When I enter booking details
  Then I click on submit button

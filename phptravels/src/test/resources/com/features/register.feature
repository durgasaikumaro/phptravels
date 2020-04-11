Feature: registration
	As a visitor of the travels website
	I want to perform validations on register page
	
	@register
  Scenario Outline: To sign in the user
    Given I am in home page 
    And I am running register attempt Number "<number>"
    When I enter register values 
    Then I click signin button
    Examples: to run this scenario several times
   |number|
   | 1    |
   | 2  	|
   | 3 		|
   | 4 		|
   | 5 		|
   | 6    |
   | 7    |
   | 8    |
   | 9    |
   
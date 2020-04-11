package stepdefinition;

import org.openqa.selenium.Keys;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import declaration.baseClass;
import objects.flightbookingpage;

public class flightbookingTeststeps extends baseClass{
	
	flightbookingpage bookinobject=new flightbookingpage(driver);
	
	ExtentTest test = report.startTest("bookingTest");
	@Given("^I am on home page and i want to book a flight$")
	public void i_am_on_home_page_and_i_want_to_book_a_flight() throws Throwable {
		
	    bookinobject.flightbooking();
	    logger("user is in booking page");
	}

	@When("^I enter passenger details$")
	public void i_enter_passenger_details() throws Throwable {
		 	bookinobject.source("chennai",Keys.ENTER);
		    bookinobject.destination("tirupati");
		    bookinobject.date();
		    logger("user enters the booking ");
		  
	}

	@Then("^I passenger have to book the flight$")
	public void i_passenger_have_to_book_the_flight() throws Throwable {
		bookinobject.searchflights();
		logger("user clicks to search the flight");	
		logger("user takes screenshots");
		
		report.endTest(test);
		report.flush();
		bookinobject.quit();
	}

}

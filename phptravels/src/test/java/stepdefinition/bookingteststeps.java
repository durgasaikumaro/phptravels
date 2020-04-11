package stepdefinition;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import declaration.baseClass;
import objects.bookingpage;

public class bookingteststeps  extends baseClass
{
	bookingpage bookingObject = new bookingpage(driver);
	@Given("^Open application and register new user$")
	public void open_application_and_register_new_user() throws Throwable
   {
	   
		bookingObject.register();
		logger("user registered");
		 ExtentTest test1 = report.startTest("registerTest");
		 test1.log(LogStatus.PASS, "Successfully registered");
	}

	@When("^I enter booking details$")
	public void i_enter_booking_details() throws Throwable
	{
		bookingObject.openbookings();
		logger("user is booking a hotel");
		ExtentTest test = report.startTest("bookingTest");
		 test.log(LogStatus.PASS, "Successfully booked");
		 report.endTest(test);
	}

	@Then("^I click on submit button$")
	public void i_click_on_submit_button() throws Throwable
   {
		bookingObject.loginpage();
		report.flush();
	}
	
}

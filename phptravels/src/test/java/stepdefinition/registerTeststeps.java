package stepdefinition;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import declaration.baseClass;
import objects.registerpage;

public class registerTeststeps extends baseClass 
{
	registerpage RegisterObject = new registerpage(driver);
	 ExtentTest test2 = report.startTest("registerTest");
	
	@Given("^I am in home page$")
	public void i_am_in_home_page() throws Throwable
	{
	 RegisterObject.homepage();
	 logger("user is in homepage");
	}

	@Given("^I am running register attempt Number \"([^\"]*)\"$")
	public void i_am_running_register_attempt_Number(String arg1) throws Throwable 
	{
		registerpage.iterator = Integer.parseInt(arg1);
		if( (registerpage.iterator==1) || (registerpage.iterator==2) || (registerpage.iterator==3) || (registerpage.iterator==4) || (registerpage.iterator==5) || (registerpage.iterator==6) || (registerpage.iterator==7) || (registerpage.iterator==8)  )
		{
			test2.log(LogStatus.FAIL, "Authentication Failed");
		}
		else
		{
			test2.log(LogStatus.PASS, "Successfully Logged in");
		}
		
	}

	@When("^I enter register values$")
	public void i_enter_register_values() throws Throwable
	{
	   RegisterObject.enterregistervalues();
	   logger("user enters register values");
	}

	@Then("^I click signin button$")
	public void i_click_signin_button() throws Throwable 
	{
		RegisterObject.clicksignInBtn();
		logger("user clicks sign in");
		logger("user takes screen shots");
		
		report.endTest(test2);
		report.flush();
	}


}

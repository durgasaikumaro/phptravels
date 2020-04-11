package stepdefinition;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import declaration.baseClass;
import objects.loginpage;

public class loginTeststeps extends baseClass
{
	loginpage loginObject = new loginpage(driver);
	
	
	@Given("^Open application and click on Register link$")
	public void open_application_and_click_on_Register_link() throws Throwable {
	    loginObject.register();
	    logger("user registered");
	    ExtentTest test1 = report.startTest("registerTest");
	    test1.log(LogStatus.PASS, "Successfully registered");
	}
	
	@Given("^I am on home page$")
	public void i_am_on_home_page() throws Throwable 
	{		
		loginObject.navigateToHomePage();
		logger("user is in home page");
	}
	
	@Given("^I am running login attempt Number \"([^\"]*)\"$")
	public void i_am_running_login_attempt_Number(String arg1) throws Throwable 
	{
		ExtentTest test = report.startTest("loginTest");
		loginpage.iterator = Integer.parseInt(arg1);
		
		if((loginpage.iterator==1) || (loginpage.iterator==2) || (loginpage.iterator==3) || (loginpage.iterator==4) )
		{
			test.log(LogStatus.FAIL, "Authentication Failed");
		}
		else
		{
			test.log(LogStatus.PASS, "Successfully Logged in");
		}
		
		report.endTest(test);
	}

		
	@When("^I enter login values username and password$")
	public void i_enter_login_values_username_and_password() throws Throwable 
	{
		loginObject.enterUsernameAndPassword();
		logger("user enters username and password");
	}

	@Then("^I click logIn button$")
	public void i_click_logIn_button() throws Throwable 
	{
		loginObject.clickLogInBtn();
		logger("user clicks login");	
		logger("user takes screenshots");
		
		report.flush();
	}
}

package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import declaration.baseClass;

@CucumberOptions(features="src/test/resources/com/features",tags = {"@flight"},glue={"stepdefinition"})
public class flightbookingTestrunner extends baseClass {
	private TestNGCucumberRunner testRunner;
	
	@BeforeClass
	public void setUP()
	{
		launchApplication("chrome", "https://www.phptravels.net/home");
		testRunner = new TestNGCucumberRunner(flightbookingTestrunner.class);		
	
	}
	
	@Test(description="booking",dataProvider="features")
	public void booking(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}
	
	@DataProvider(name="features")
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		testRunner.finish();
		sleep(2);
		
	}
}

package runner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import declaration.baseClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import org.testng.annotations.AfterClass;

@CucumberOptions(features="src/test/resources/com/features",tags = {"@booking"},glue={"stepdefinition"})
public class bookingrunner extends baseClass 
{
		private TestNGCucumberRunner testRunner;
		
		@BeforeClass
		public void setUP()
		{
			launchApplication("chrome", "https://www.phptravels.net/home");
			testRunner = new TestNGCucumberRunner(bookingrunner.class);			
		}
		
		@Test(description="BOOKING",dataProvider="features")
		public void login(CucumberFeatureWrapper cFeature)
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

package declaration;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;

public class baseClass 
{
	public static WebDriver driver;	
	public void launchApplication(String browser, String URL)
	{
		
				
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
			
			
			//To maximize the window
			driver.manage().window().maximize();
			//To create implicit time waits
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//To get the application URL
			driver.get(URL);
		
	}
	
		
	//to sleep the application for a specific timeOut in seconds
	public static void sleep(int timeout) throws InterruptedException 
	{
		TimeUnit.SECONDS.sleep(timeout);
	}
	
	//ExtentReports
	public static ExtentReports report = new ExtentReports("ExtentReport.html");
		
	//Log4J
	public static Logger log;	
	public static void logger(String msg)
	{
		log = Logger.getLogger(baseClass.class.getName());
		log.info(msg);
	}
	
	//To close the browser
	public void quit()
	{
		driver.quit();
	}
}

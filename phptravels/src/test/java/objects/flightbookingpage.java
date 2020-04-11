package objects;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.google.common.io.Files;

public class flightbookingpage {
static WebDriver driver;
	WebElement destination,source;
	
	public flightbookingpage(WebDriver driver) 
	{
		flightbookingpage.driver = driver;
	}
	
	public void flightbooking() 
	{
		
		driver.get("https://www.phptravels.net/home");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/nav/ul/li[2]/a")).click();
		       
	}
	
	public void source(String s,Keys dd)
	{
		System.out.println(s);
		source =driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/form/div/div[3]/div[1]/div/div[1]/div/div[2]/div/a"));
		source.click();
		source.sendKeys(s,dd);
		//driver.manage().timeouts().
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		source.sendKeys(dd);
	}
	
	public void destination(String d)
	{
		destination=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/form/div/div[3]/div[1]/div/div[2]/div/div[2]/div/a"));
		destination.click();
		destination.sendKeys(d);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		destination.sendKeys(Keys.ENTER);
	} 
     public void date() {
		
		//driver.findElement(By.xpath("//*[@id=\"FlightsDateStart\"]")).click();
				driver.findElement(By.name("departure_date"));
		//driver.findElement(By.xpath("/html/body/div[3]/div[8]/div/div/div[2]/div[20]")).click();
		
	}
 
	
		
	public void searchflights() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//*[@id=\'flights\']/div/div/form/div/div[3]/div[4]/button")).click();;
		Thread.sleep(100);
		takeSnap();
	}
	public static void takeSnap() throws IOException
	{
		
	File scrFile;
	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	Files.copy(scrFile, new File("C:\\Users\\LENOVO\\eclipse-workspace\\phptravels\\src\\test\\resources\\com\\screenshots\\hi "  + ".png"));
	System.out.println("taking screenshot");
	}

	public void quit() {
		driver.quit();
		
	}

	
}

	
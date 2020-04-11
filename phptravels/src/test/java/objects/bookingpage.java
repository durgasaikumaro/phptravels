package objects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.excelUtility.excelReadWrite;
import com.google.common.io.Files;

public class bookingpage 
{
	static WebDriver driver;
	
	
	public bookingpage(WebDriver driver) 
	{
		bookingpage.driver = driver;
	}
	
	public void HomePage() 
	{
		driver.navigate().to("https://www.phptravels.net/login");
	}
	
	
	public void register() throws InterruptedException, IOException
	{
		driver.navigate().to("https://www.phptravels.net/register");
		driver.findElement(By.name("firstname")).sendKeys("sunny");
		driver.findElement(By.name("lastname")).sendKeys("dsk");
		Thread.sleep(2000);
		driver.findElement(By.name("phone")).sendKeys("8686060718");
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("seletwo1436@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("seletwo2020");
		Thread.sleep(2000);
		driver.findElement(By.name("confirmpassword")).sendKeys("seletwo2020");
		driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[8]/button")).click();
		Thread.sleep(3000);
		takeSnap();
	}
	
	public void openbookings() 
	{
		driver.navigate().to("https://www.phptravels.net/home");
		driver.findElement(By.xpath("//html/body/div[6]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div/input")).sendKeys("hyderabad");
		driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div")).click();	
		driver.findElement(By.xpath("//*[@id=\"hotels\"]/div/div/form/div/div/div[4]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"LIST\"]/li[2]/div/div/div[2]/div/div[3]/div/div[2]/form/button")).click();
		driver.findElement(By.xpath("//*[@id=\"detail-content-sticky-nav-02\"]/div[2]/div[2]/div/div[2]/div/div[2]/form/button")).click();
		driver.findElement(By.xpath("//*[@id=\"thhotels\"]/div/div[1]/div[3]/form[2]/button")).click();
	}
	

	public void loginpage() throws IOException, InterruptedException 
	{   
		driver.navigate().to("https://www.phptravels.net/login");
		
	}
	public static void takeSnap() throws IOException
	{
		
	File scrFile;
	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	Files.copy(scrFile, new File("C:\\Users\\LENOVO\\eclipse-workspace\\phptravels\\src\\test\\resources\\com\\screenshots\\hello Image"  + ".png"));
	System.out.println("taking screenshot");

	}

	
}

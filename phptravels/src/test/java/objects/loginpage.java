package objects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.excelUtility.excelReadWrite;
import com.google.common.io.Files;

public class loginpage 
{
	static WebDriver driver;
	
	
	excelReadWrite excel;
	String excelPath = "C:\\Users\\LENOVO\\eclipse-workspace\\phptravels\\src\\test\\resources\\com\\testdata\\keyword.xlsx";	
	
	public static int iterator;
	int totalRows;
	int totalColumns;
	
	public loginpage(WebDriver driver) 
	{
		loginpage.driver = driver;
	}
	
	public void navigateToHomePage() 
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
		driver.findElement(By.name("email")).sendKeys("seletwo2020@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("seletwo2020");
		Thread.sleep(2000);
		driver.findElement(By.name("confirmpassword")).sendKeys("seletwo2020");
		driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[8]/button")).click();
		Thread.sleep(3000);
		takeSnap();
	}
	
	public void enterUsernameAndPassword() throws IOException, InterruptedException 
	{
		excel = new excelReadWrite(excelPath);
		totalRows = excel.getTotalRows("Sheet1");
		totalColumns = excel.getTotalcolumns("Sheet1");
		
		System.out.println("iterator  " + iterator);
		for(int column = 0; column < 2; column++) 
		{
			if(excel.readExcelData("Sheet1",0,column).equalsIgnoreCase("USERNAME"))
			{
				driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[1]/label/input")).sendKeys(excel.readExcelData("Sheet1",iterator, column));
			}
			else if(excel.readExcelData("Sheet1",0,column).equalsIgnoreCase("PASSWORD"))
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[2]/label/input")).sendKeys(excel.readExcelData("Sheet1",iterator, column));
			}						
		}		
	}
	
	public void clickLogInBtn() throws IOException, InterruptedException 
	{   
		driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/button")).click();
		Thread.sleep(1000);
		takeSnap();
	}
	public static void takeSnap() throws IOException
	{
		
	File scrFile;
	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	Files.copy(scrFile, new File("C:\\Users\\LENOVO\\eclipse-workspace\\phptravels\\src\\test\\resources\\com\\screenshots\\hello Image" + iterator + ".png"));
	System.out.println("taking screenshot");

	}

	
}

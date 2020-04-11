package objects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.excelUtility.excelReadWrite;
import com.google.common.io.Files;

public class registerpage {
	
	static WebDriver driver;
	
	excelReadWrite excel;
	String excelPath = "C:\\Users\\LENOVO\\eclipse-workspace\\phptravels\\src\\test\\resources\\com\\testdata\\keyword.xlsx";
	
   public static int iterator;
	int totalRows;
	int totalColumns;
	
	public registerpage(WebDriver driver)
	{
		registerpage.driver = driver;
	}
	
	public void homepage()
	{
		driver.navigate().to("https://www.phptravels.net/register");
		
	}
	
	public void enterregistervalues() throws IOException, InterruptedException 
	{
		excel = new excelReadWrite(excelPath);
		totalRows = excel.getTotalRows("Sheet2");
		totalColumns = excel.getTotalcolumns("Sheet2");
		
		System.out.println("iterator  " + iterator);
		for(int column = 0; column < 6; column++) 
		{
			if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("FIRSTNAME"))
			{
				driver.findElement(By.name("firstname")).sendKeys(excel.readExcelData("Sheet2",iterator, column));
			}
			else if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("LASTNAME"))
			{
				
				driver.findElement(By.name("lastname")).sendKeys(excel.readExcelData("Sheet2",iterator, column));
			}	
			else if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("MOBILE"))
			{
				
				driver.findElement(By.name("phone")).sendKeys(excel.readExcelData("Sheet2",iterator, column));
			}	
			else if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("EMAIL"))
			{
				
				driver.findElement(By.name("email")).sendKeys(excel.readExcelData("Sheet2",iterator, column));
			}	
			else if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("PASSWORD"))
			{
				driver.findElement(By.name("password")).sendKeys(excel.readExcelData("Sheet2",iterator, column));
			}	
			else if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("CONFIRMPASSWORD"))
			{
				Thread.sleep(1000);
				driver.findElement(By.name("confirmpassword")).sendKeys(excel.readExcelData("Sheet2",iterator, column));
			}	
		}		
		
	}
	
	public void clicksignInBtn() throws IOException, InterruptedException 
	{   
		driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[8]/button")).click();
		Thread.sleep(1000);
		takeSnap();
	}
	public static void takeSnap() throws IOException
	{
		
	File scrFile;
	scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	Files.copy(scrFile, new File("C:\\Users\\LENOVO\\eclipse-workspace\\phptravels\\src\\test\\resources\\com\\screenshots\\register Image" + iterator + ".png"));
	System.out.println("taking screenshot");

	}

}

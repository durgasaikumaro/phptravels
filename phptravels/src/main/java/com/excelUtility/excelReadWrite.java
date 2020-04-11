package com.excelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReadWrite {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	FileInputStream inputStream;
	FileOutputStream outputStream;
	String filePath;
	
	public excelReadWrite(String path) 
	{
		filePath = path;
	}
	
	//To read excel data
	public String readExcelData(String sheetName, int rowNumber, int colNumber) throws IOException 
	{
		inputStream = new FileInputStream(new File(filePath));
		
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);	
		
		XSSFRow row = sheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(colNumber);
		
		DataFormatter formatter = new DataFormatter();
		String value = formatter.formatCellValue(cell);
        
		inputStream.close();
		
		return value;
	}
	
	
	public int getTotalRows(String sheetName) throws IOException 
	{
		inputStream = new FileInputStream(new File(filePath));
		
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);	
		int totalRows = sheet.getLastRowNum();
		inputStream.close();
		
		return(totalRows);		
	}
	
	public int getTotalcolumns(String sheetName) throws IOException 
	{
		inputStream = new FileInputStream(new File(filePath));
		
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);	
		
		int totalcolumns = sheet.getRow(1).getLastCellNum();
		inputStream.close();
		
		return(totalcolumns);		
	}
}

//To write excel data
	/*public void writeExcelData(String sheetName, int rowNumber, int columnNumber, String data, String color) throws IOException
	{
		inputStream = new FileInputStream(new File(filePath));
		
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);	
		
		
		inputStream.close();
		
		outputStream = new FileOutputStream(new File(filePath));
		workbook.write(outputStream);
      outputStream.close();
	}*/
	

/*  String FilePath = "C:\\Users\\LENOVO\\Desktop\\sampledoc.xls";
FileInputStream fs = new FileInputStream(FilePath);
Workbook wb = Workbook.getWorkbook(fs);
// TO get the access to the sheet
Sheet sh = wb.getSheet("Sheet1");
// To get the number of rows present in sheet
int totalNoOfRows = sh.getRows();
// To get the number of columns present in sheet
int totalNoOfCols = sh.getColumns();   */

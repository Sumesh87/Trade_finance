package com.trac.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CommonFunctions 
{
	WebDriver driver=SingleTonDriver.getDriver();
	
	public void open_Browser()
	{
		try 
		{
			driver.manage().window().maximize();
			String tradeFinanceUrl="http://192.168.1.97:2765/AOB_THOMSON/login/login.jsp";
			driver.get(tradeFinanceUrl);		
		} 
		catch (Exception e) 
		{
			String exception=e.toString();
			System.out.println("Opening browser has error :" + exception);
			Assert.fail("testcase failed");
			e.printStackTrace();
		}
				
	}
				
	public String readProperty(String propName) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+"\\src\\main\\java\\com\\trac\\config\\config.properties"); 

		Properties prop=new Properties();
		prop.load(fis);		
		return prop.getProperty(propName);
		
	}
	
	// Wait until visibility and Type
	public void setValue(int timeOutInSeconds, WebElement username,String value) 
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(value);
	}
	
	// Wait until visibility and Click 
	public void clickButton(int timeOutInSeconds, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	} 
	
	//Selects drop down 
	public void selectoptionindropdown(String xpath, String value) 
	{
		WebElement element=driver.findElement(By.xpath(xpath));
		Select se=new Select(element);
		//se.selectByVisibleText(option);
		se.selectByValue(value);
		
	}
	//Gets the current page Title
	public String getpagetitle() 
	{
		String pageTitle=driver.getTitle();
		//System.out.println("The current page title is : " + pageTitle);
		return pageTitle;
	}
	
	//Gets the current page URL
	public String geturl() 
	{
		return driver.getCurrentUrl();
	}
	
	// Takes a Screenshot
	public void capturescreenshot(String filename) throws IOException 
	{
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\stradegi\\screenshots\\" + filename + ".jpg"));
		
	}
	
	// Double click on element
	public void doubleClick(WebElement element) 
	{
		Actions action = new Actions(driver).click(element);
		action.doubleClick().build().perform();
	}
	
	// mouse move to the desired element
	public void mousehower(WebElement element) 
	{
		Actions mouse = new Actions(driver);		
		mouse.moveToElement(element).build().perform();
	}
		
	// mouse move to the desired element and double click	
	public void mousehoweranddoubleclick(WebElement element) 
	{
		Actions mouse = new Actions(driver);
		mouse.moveToElement(element).doubleClick().build().perform();		
	}
	
	// mouse move to the desired element and Click	
	public void mousehowerandclick(WebElement element) 
	{
		Actions mouse = new Actions(driver);
		mouse.moveToElement(element).doubleClick().build().perform();	
	}
	
	// Check Whether page is ready
	 public void checkPageIsReady() 
	 { 		 
		 JavascriptExecutor js = (JavascriptExecutor)driver; 
		 //Initially bellow given if condition will check ready state of page. 
		 if (js.executeScript("return document.readyState").toString().equals("complete"))
		 { 
			 System.out.println("Page Is loaded."); 
			 return;
		 } 	    
	 }
	 
	 public String readExcel(String sheetName,int rownum,int colNum) throws IOException
	 {
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\trac\\config\\TestData.xlsx");
		 XSSFWorkbook workbook=new XSSFWorkbook(fis);
		 XSSFSheet sheet=workbook.getSheet(sheetName);
		 XSSFRow row=sheet.getRow(rownum);
		 
		 return row.getCell(colNum).toString();
	 }
	 
	 public String readExcel1(String sheetName,int rownum,int colNum) throws IOException
	 {
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\trac\\config\\Opportunities_Test_Data.xlsx");
		 XSSFWorkbook workbook=new XSSFWorkbook(fis);
		 XSSFSheet sheet=workbook.getSheet(sheetName);
		 XSSFRow row=sheet.getRow(rownum);
		 
		 return row.getCell(colNum).toString();
	 }
	 
	 // Method to take Screenshot
	 public  String capture(WebDriver driver,String screenShotName) throws IOException
	 {
	     TakesScreenshot ts = (TakesScreenshot)driver;
	     File source = ts.getScreenshotAs(OutputType.FILE);
	     String dest = System.getProperty("user.dir") +"\\src\\main\\java\\com\\trac\\screenshots\\"+screenShotName+".png";
	     File destination = new File(dest);
	     FileUtils.copyFile(source, destination);        
	     return dest;
	 }
	 
	// Element highlighter code
	 public void highLightElement(WebDriver driver, WebElement element)
	 {
		 JavascriptExecutor js=(JavascriptExecutor)driver; 	  
		 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	 }
	
	// Close the Browser
	public void closebrowser() 
	{
		driver.close();
	}

}

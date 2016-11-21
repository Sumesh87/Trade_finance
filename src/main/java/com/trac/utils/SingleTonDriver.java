package com.trac.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public abstract class SingleTonDriver 
{
	public static WebDriver driver=null;
		
	public static WebDriver getDriver()  
	{
		String path1= System.getProperty("user.dir");
		String path2= "\\src\\main\\java\\com\\trac\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path1+path2);
				
		if(driver==null)
		{
			driver=new ChromeDriver();
			return driver;
		}
		else
		{
			return driver;
		}
			
	}
}

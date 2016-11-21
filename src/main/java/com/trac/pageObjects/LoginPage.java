package com.trac.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.trac.utils.Excel_Utils;
import com.trac.utils.ProjectRelatedFunctions;
import com.trac.utils.SingleTonDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends ProjectRelatedFunctions
{	
	WebDriver driver=SingleTonDriver.getDriver();
	
	// Invoke a constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@data-ng-model='login.user_id_1']")
	private WebElement userNameWebElmt;
	
	@FindBy(how = How.XPATH, using = "//input[@data-ng-model='login.password_1']")
	private WebElement passwordWebElmt;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'login-btn')]")
	private WebElement loginBtnWebElmt;
	
	@FindBy(how = How.XPATH, using = "//div[@data-ng-click='forgot_password()']")
	private WebElement forgot_Pwd_lnkWebElmt;
	
	// configure log4j properties file	
	Logger logger=Logger.getLogger("LoginPage");
	
	//Method 1: Set user name in text box
	public void setUserName(WebElement strUserName) throws Exception
	{		
		uName=readExcel("sheet1",1,1);
		setValue(10,strUserName,uName);		
		logger.info("User ID: '" + uName + "' is entered");
	}
	
	//Method 2: Set password in text box
	public void setPassword(WebElement strPassword) throws Exception
	{	
		pwd=readExcel("sheet1",1,2);
		setValue(10,strPassword,pwd);
		logger.info("Password : '" + pwd + "' is entered");
	}
	
	//Method 3: Enter user name and password and Click login button
	public WorkspacePage perform_Login() throws Exception
	{			
		setUserName(userNameWebElmt);
		Thread.sleep(1000);
		setPassword(passwordWebElmt);	
		Thread.sleep(1000);	
		clickButton(10,loginBtnWebElmt);	
		logger.info("Login button is clicked");
		Thread.sleep(2000);		
		return PageFactory.initElements(driver, WorkspacePage.class);
	}
	

	
	
	
	
}

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.trac.pageObjects.AddOpportunityPage;
import com.trac.pageObjects.LoginPage;
import com.trac.pageObjects.OpportunityLandingPage;
import com.trac.pageObjects.SubWorkflowPage;
import com.trac.pageObjects.WorkflowPage;
import com.trac.pageObjects.WorkspacePage;
import com.trac.utils.CommonFunctions;
import com.trac.utils.ProjectRelatedFunctions;
import com.trac.utils.SingleTonDriver;

public class TC_script_01 
{
	WebDriver driver=null;
	CommonFunctions comFunct=null;
	LoginPage logn=null;	
	WorkspacePage workspace=null;	
	WorkflowPage workflow=null;
	SubWorkflowPage subWorkflow=null;
	OpportunityLandingPage opportunityDisplay=null;
	ExtentReports extent=null;
	AddOpportunityPage addOpp=null;
		
	Logger logger=Logger.getLogger("TC_script_01");
	
	// configure the file path
	public String loggerFilePath="\\src\\main\\java\\com\\trac\\config\\log4j.properties";
	public String reportFilePath="\\src\\main\\java\\com\\trac\\reports\\Trac_reports.html";
	public String configPath="\\src\\main\\java\\com\\trac\\reports\\config.xml";

	@BeforeSuite
	public void setUp() throws Exception 
	{
		try 
		{			
			comFunct=new CommonFunctions();
			String baseUrl= comFunct.readProperty("url");
			PropertyConfigurator.configure(System.getProperty("user.dir")+loggerFilePath);
			driver=SingleTonDriver.getDriver();
			logger.info("A new Browser is Opened");
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get(baseUrl);
			logger.info("TRAC application is launched ..");
			
								
			driver.manage().window().maximize();
		} 
		catch (Exception e) 
		{					
			Assert.fail("testcase failed");
			logger.fatal("Browser opened failed ");			
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void startReport()
	{
		extent=new ExtentReports(System.getProperty("user.dir")+reportFilePath, true);
		
		extent.addSystemInfo("Host Name", "TRAC")
		.addSystemInfo("Environment", "1.63")
		.addSystemInfo("User Name", "Sumesh");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+configPath));		
	}
	
	@Test(priority=0,enabled=true)
	public void TC_01_login() throws InterruptedException
	{
		try 
		{		
			ExtentTest test1=extent.startTest("TC_01_login");
			logn=new LoginPage(driver);	
			workspace=logn.perform_Login();
			test1.log(LogStatus.INFO, "Enter User ID and Password and Clicks Login");
			
			String pageTitle=comFunct.getpagetitle();
			String expectedTitle="My Workspace";
			if(pageTitle.contains(expectedTitle))
			{
				String loggedInScreenSht = comFunct.capture(driver,"loggedIn");
				test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture(loggedInScreenSht));
				
				logger.info("Successfully logged into the application. ");
				test1.log(LogStatus.INFO, "Successfully logged in Trade Finance");
				test1.log(LogStatus.PASS, "TC_01_login is passed");
			}
			else
			{
				logger.info("Invalid User ID and password..");	
				test1.log(LogStatus.FAIL, "TC_01_login is failed");
			}
			extent.endTest(test1);
		} 
		catch (Exception e) 
		{					
			Assert.fail("testcase failed");
			logger.warn("Unsuccessfull Login.");			
			e.printStackTrace();
		}		
		
	}	
	
	@Test(priority=1,enabled=false)
	public void TC_02_workflow() throws InterruptedException
	{
		try 
		{	
			ExtentTest test2=extent.startTest("TC_02_workflow");
			workspace.clickHamburger();
			logger.info("Clicked 'Hamburger' icon ");
			test2.log(LogStatus.INFO, "Clicked 'Hamburger' icon ");
			
			workspace.clickOpportunity_MainMenu();
			logger.info("Clicked opportunity Main menu ");
			test2.log(LogStatus.INFO, "Clicked opportunity Main menu ");
			
			workspace.mouse_Hover_Workflow();
			logger.info("Mouse hover is performed over workflow icon");
			
			workflow=workspace.click_Workflow();	
			workflow.click_add_Workflow();
			logger.info("Clicked on  Add workflow icon");
			test2.log(LogStatus.INFO, "Clicked on Add workflow icon ");
			
			String AddworkFlowScreenSht = comFunct.capture(driver,"AddworkFlow");
			test2.log(LogStatus.INFO, "Snapshot below: " + test2.addScreenCapture(AddworkFlowScreenSht));
						
			workflow.create_Workflow();
			test2.log(LogStatus.INFO, "Enters all details to create a new workflow");
			logger.info("A new Workflow is created");
			
						
			String workFlowInScreenSht = comFunct.capture(driver,"workFlowCreated");
			test2.log(LogStatus.INFO, "Snapshot below: " + test2.addScreenCapture(workFlowInScreenSht));
			test2.log(LogStatus.PASS, "A new Workflow is created");
			
			workflow.edit_Workflow();
			logger.info("Workflow is edited succesfully");	
			extent.endTest(test2);
		} 
		catch (Exception e) 
		{				
			Assert.fail("testcase failed");
			logger.error("Creation of workflow failed ");			
			e.printStackTrace();
		}		
		
	}
	@Test(priority=2,enabled=false)
	public void TC_03_sub_workflow() throws InterruptedException
	{
		try 
		{		
			ExtentTest test3=extent.startTest("TC_03_sub_workflow");
			workspace.clickHamburger();
			workspace.clickOpportunity_MainMenu();
			workspace.mouse_Hover_Sub_Workflow();
			subWorkflow=workspace.click_sub_Workflow();	
			subWorkflow.edit_sub_Workflow();
			subWorkflow.click_Add_task();
			subWorkflow.create_User_task_details();
			//subWorkflow.create_Approval_task_details()
			extent.endTest(test3);
		} 
		catch (Exception e) 
		{					
			Assert.fail("testcase failed");
			logger.error("Creation of Sub-workflow failed ");			
			e.printStackTrace();
		}		
	}
	
	@Test(priority=3,enabled=true)
	public void TC_04_create_Opportunity() throws InterruptedException
	{
		try 
		{		
			//ExtentTest test4=extent.startTest("TC_04_create_Opportunity");
			workspace.clickHamburger();
			logger.info("Clicked Hamburger icon ");
			
			workspace.clickOpportunity_MainMenu();
			logger.info("Clicked Opportunity Main icon ");
			
			opportunityDisplay=workspace.navigateToOpportunity();
			
			addOpp=opportunityDisplay.clickAddOpportunity();
			//test4.log(LogStatus.INFO, "Clicked on Add Opportunity button ");
			
			addOpp.create_opportunity();
			
			//opportunityDisplay.clickLastPage();
			//logger.info("Clicked last page on Opportunity page");
			
			//extent.endTest(test4);
		} 
		catch (Exception e) 
		{						
			Assert.fail("testcase failed");
			logger.error("creation of opportunity failed ");			
			e.printStackTrace();
		}		
	}
	
//	@DataProvider(name="oppMethod")
//	public Object[][] getData() 
//	{
//		Object[][] arrayObject = readExcel("sheet1",1,1);
//		return arrayObject;
//	}
	
	@Test(priority=4,enabled=false)
	public void TC_05_signOut() 
	{
		try 
		{
			ExtentTest test5=extent.startTest("Sign_out from app");
			test5.log(LogStatus.INFO, "Click Sign out Button");
			
			logn=workspace.sign_out();
			Thread.sleep(2000);
			
			String signOutScreenSht = comFunct.capture(driver,"SignOutfromApp");
			test5.log(LogStatus.INFO, "Snapshot below: " + test5.addScreenCapture(signOutScreenSht));
			test5.log(LogStatus.PASS, "The application is successfully logged out");
			extent.endTest(test5);
		} 
		catch (Exception e) 
		{						
			Assert.fail("testcase failed");
			logger.fatal("Signout from app has failed ");			
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}
	
	@AfterSuite(enabled=false)
	public void tearDown() throws Exception 
	{		
		driver.quit();
	}
	
}

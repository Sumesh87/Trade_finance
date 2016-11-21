package com.trac.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.trac.utils.ProjectRelatedFunctions;
import com.trac.utils.SingleTonDriver;

public class WorkspacePage extends ProjectRelatedFunctions
{
	WebDriver driver=SingleTonDriver.getDriver();
	
	// Invoke a constructor
	public WorkspacePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//i[@class='hamburger']")
	private WebElement hamburgerWebElmt;
	
	@FindBy(how = How.XPATH, using = "//div[@title='Opportunities']")
	private WebElement opportunity_Main_menuWebElmt;
	
	@FindBy(how = How.XPATH, using = "//i[contains(@class,'menu-icon')]")
	private WebElement configuration_Menu_iconWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='deal-menu']")
	private WebElement opportunity_iconWebElmt;
	
	@FindBy(how = How.XPATH, using = "//li[@title='Workflows']")
	private WebElement workflow_Menu_iconWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='wfl-generic_16']")
	private WebElement opportunity_workflows_iconWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pobProcessMngr-menu']")
	private WebElement workflow_ManagerWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pobTaskMngr-menu']")
	private WebElement subWorkflow_ManagerWebElmt;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div/div[1]/div/i")
	private WebElement sub_Dropdown_WebElmt;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div/div[1]/ul/a[6]/li")
	private WebElement sign_Out_WebElmt;
	
		
	
	//Method 1: Click on Hamburger icon
	public void clickHamburger() throws InterruptedException
	{		
		clickButton(10,hamburgerWebElmt);	
		Thread.sleep(1000);
	}
	
	//Method 2: Click on opportunity_Menu_icon 
	public void clickOpportunity_MainMenu() throws InterruptedException
	{		
		clickButton(10,opportunity_Main_menuWebElmt);	
		Thread.sleep(1000);
	}
	
	//Method 3: Mouse over on menu icon and click Work flow manager
	public void mouse_Hover_Workflow() throws InterruptedException
	{		
		mousehower(workflow_Menu_iconWebElmt);
		Thread.sleep(1000);
		mousehower(opportunity_workflows_iconWebElmt);
		Thread.sleep(1000);
		mousehower(workflow_ManagerWebElmt);
		Thread.sleep(1000);	
		
	}
	//Method 4: Mouse over on menu icon and click Sub-Work flow manager
	public void mouse_Hover_Sub_Workflow() throws InterruptedException
	{
		mousehower(workflow_Menu_iconWebElmt);
		Thread.sleep(1000);
		mousehower(opportunity_workflows_iconWebElmt);
		Thread.sleep(1000);
		mousehower(subWorkflow_ManagerWebElmt);
		Thread.sleep(1000);				
	}
	
	//Method 5: click on Work flow manager icon  
	public WorkflowPage click_Workflow() throws InterruptedException
	{
		clickButton(10,workflow_ManagerWebElmt);
		return PageFactory.initElements(driver, WorkflowPage.class);
	}
	
	//Method 6: click on Sub-Work flow manager icon  
	public SubWorkflowPage click_sub_Workflow() throws InterruptedException
	{
		clickButton(10,subWorkflow_ManagerWebElmt);
		return PageFactory.initElements(driver, SubWorkflowPage.class);
	}
	
	//Method 7: Click on Hamburger icon
	public OpportunityLandingPage navigateToOpportunity() throws InterruptedException
	{		
		clickButton(10,opportunity_iconWebElmt);
		return PageFactory.initElements(driver, OpportunityLandingPage.class);
	}
	
	//Method 8: Logout from TRAC
	public LoginPage sign_out() throws InterruptedException
	{
		clickButton(10,sub_Dropdown_WebElmt);
		Thread.sleep(1000);
		
		clickButton(10,sign_Out_WebElmt);
		return PageFactory.initElements(driver, LoginPage.class);
	}

}

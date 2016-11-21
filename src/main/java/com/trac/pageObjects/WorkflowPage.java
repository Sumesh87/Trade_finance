package com.trac.pageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import com.trac.utils.ProjectRelatedFunctions;
import com.trac.utils.SingleTonDriver;

public class WorkflowPage extends ProjectRelatedFunctions
{
	WebDriver driver=SingleTonDriver.getDriver();

	// Invoke a constructor
	public WorkflowPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = ".WRITE.ng-scope")
	private WebElement editWorkFlowWebElmt;
	
	@FindBy(how = How.XPATH, using = "//li[@class='add']")
	private WebElement addWorkFlowWebElmt;
		
	// Fields inside Add Workflow  pop up  
	@FindBy(how = How.XPATH, using = ".//*[@id='fld_workflow_name']")
	private WebElement workflowNameTxtboxWebElmt;
	
	@FindBy(how = How.CSS, using = ".splchar-onPaste.ng-pristine.ng-valid")
	private WebElement descriptionTxtBoxWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_buss_cal']/a/span[2]/b")
	private WebElement businessCalndrDrpdwnWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen13_search']")
	private WebElement businessCalndrSearchBxWebElmt;
	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-result-label-113']")
	private WebElement businessCalndrValueWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen1']")
	private WebElement editByUsersDrpdwnWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen3']/ul")
	private WebElement editByTeamsDrpdwnWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen4']")
	private WebElement editByTeamsTxtboxWebElmt;
	
	@FindBy(how = How.XPATH, using = "//span[@data-ng-click='add_cat()']")
	private WebElement addSubWorkflowBtnWebElmt;
	
	//Fields: Sub work flow pop up
	
	@FindBy(how = How.XPATH, using = ".//*[@id='fld_sub_wfl_name']")
	private WebElement subWorkflowNameTxtboxWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='categories_popup']/div[2]/div[2]/div[2]/textarea")
	private WebElement subWorkflowDescTxtboxWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen15']")
	private WebElement subWorkflowUserTxtboxWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_s1']")
	private WebElement subWorkflowUserDrpdwnWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_s2']")
	private WebElement subWorkflowTeamDrpdwnWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen16']")
	private WebElement subWorkflowTeamTxtareaWebElmt;	
		
	@FindBy(how = How.XPATH, using = "//span[@data-ng-click='OkayCategories()']")
	private WebElement okSubWorkflowBtnWebElmt;
	
	@FindBy(how = How.XPATH, using = "//span[@data-ng-click='CancelCategories()']")
	private WebElement cancelSubWorkflowBtnWebElmt;
	
	// Add Data point button
	@FindBy(how = How.XPATH, using = "//span[@data-ng-click='add_dp()']")
	private WebElement addDataPointBtnWebElmt;	
	
	// Fields: Data point pop-up
	@FindBy(how = How.XPATH, using = ".//*[@id='fld_datapoint_name']")
	private WebElement captionNameTxtboxWebElmt;
	
	@FindBy(how = How.XPATH, using = "//input[@data-ng-model='templates.data_point_name']")
	private WebElement dataPointNameTxtboxWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_dp_1']/a/span[2]/b")
	private WebElement typeDrpdwnIconWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen14_search']")
	private WebElement typeSearchWebElmt;
	
	@FindBy(how = How.XPATH, using = "//span[@data-ng-click='OkayDp()']")
	private WebElement okDataPointBtnWebElmt;
	
	@FindBy(how = How.XPATH, using = "//div[@data-ng-click='Save()']")
	private WebElement saveWorkflowBtnWebElmt;
	
	@FindBy(how = How.CSS, using = ".orange-btn.cancel")
	//@FindBy(how = How.XPATH, using = "//div[contains(@class,'orange-btn cancel')]")
	private WebElement closeWorkflowBtnWebElmt;
	
	// configure log4j properties file	
	Logger logger=Logger.getLogger("WorkflowPage");
	
	
	// Method 1: To click on Add work flow button
	public void click_add_Workflow() throws InterruptedException
	{			
		clickButton(10,addWorkFlowWebElmt);
		logger.info("Clicked on Add Workflow");
		Thread.sleep(1000);
	}
	
	// Method 2: To create a work flow.
	public void create_Workflow() throws InterruptedException, IOException
	{	
		nameWorkflow=readExcel("sheet2",1,1);
		setValue(10,workflowNameTxtboxWebElmt,nameWorkflow);		
		logger.info("Workflow Name: '" + nameWorkflow + "' is entered");
		Thread.sleep(1000);
		
		descriptionWorkflow=readExcel("sheet2",2,1);
		setValue(10,descriptionTxtBoxWebElmt,descriptionWorkflow);
		logger.info("Workflow description: '" + descriptionWorkflow + "' is entered");
		Thread.sleep(1000);
		
		clickButton(10,businessCalndrDrpdwnWebElmt);
		Thread.sleep(1000);
		
		businessValue=readExcel("sheet2",3,1);
		setValue(10,businessCalndrSearchBxWebElmt,businessValue);
		logger.info("Business Calendar: '" + businessValue + "' is entered");
		Thread.sleep(1000);
		
		businessCalndrSearchBxWebElmt.sendKeys(Keys.ENTER);
		
		
		clickButton(10,editByTeamsDrpdwnWebElmt);
		Thread.sleep(1000);
		
		teamName=readExcel("sheet2",5,1);
		setValue(10,editByTeamsTxtboxWebElmt,teamName);
		Thread.sleep(1000);
		
		editByTeamsTxtboxWebElmt.sendKeys(Keys.ENTER);	
		
		clickButton(10,addSubWorkflowBtnWebElmt);
		Thread.sleep(1000);
				
		// Enter data in Sub workflow pop up
		
		nameSubWorkflow=readExcel("sheet2",7,1);
		setValue(10,subWorkflowNameTxtboxWebElmt,nameSubWorkflow);
		logger.info("SubWorkflow Name: '" + nameSubWorkflow + "' is entered");
		Thread.sleep(1000);
		
		descriptionSubWorkflow=readExcel("sheet2",8,1);
		setValue(10,subWorkflowDescTxtboxWebElmt,descriptionSubWorkflow);
		logger.info("SubWorkflow Desc: '" + descriptionSubWorkflow + "' is entered");
		Thread.sleep(1000);
		
		clickButton(10,subWorkflowUserTxtboxWebElmt);
		Thread.sleep(1000);
		
		userName=readExcel("sheet2",4,1);
		setValue(10,subWorkflowUserTxtboxWebElmt,userName);
		logger.info("User name: '" + userName + "' is entered");
		Thread.sleep(1000);		
		
		subWorkflowUserTxtboxWebElmt.sendKeys(Keys.ENTER);	
		
		setValue(10,subWorkflowTeamTxtareaWebElmt,teamName);
		Thread.sleep(1000);
		
		subWorkflowTeamTxtareaWebElmt.sendKeys(Keys.ENTER);
		
		// Click on OK button in Sub workflow pop up
		clickButton(10,okSubWorkflowBtnWebElmt);
		Thread.sleep(1000);
		
		// Click on Add data point button.
		clickButton(10,addDataPointBtnWebElmt);
		Thread.sleep(1000);
		
		// Enter data in Data-Points pop up
		
		captionName=readExcel("sheet2",10,1);
		setValue(10,captionNameTxtboxWebElmt,captionName);
		logger.info("Caption name: '" + captionName + "' is entered");
		Thread.sleep(1000);
		
		dataPointName=readExcel("sheet2",11,1);
		setValue(10,dataPointNameTxtboxWebElmt,dataPointName);
		logger.info("Datapoint name: '" + dataPointName + "' is entered");
		Thread.sleep(1000);
		
		clickButton(10,typeDrpdwnIconWebElmt);
		Thread.sleep(1000);
		
		dataPointType=readExcel("sheet2",12,1);
		setValue(10,typeSearchWebElmt,dataPointType);
		logger.info("Datapoint Type: '" + dataPointType + "' is entered");
		Thread.sleep(1000);
		
		typeSearchWebElmt.sendKeys(Keys.ENTER);
		
		clickButton(10,okDataPointBtnWebElmt);
		logger.info("OK button is clicked");
		Thread.sleep(1000);
		
		// Finally, Save a Workflow .
		
		clickButton(10,saveWorkflowBtnWebElmt);
		logger.info("Finally, Save button is clicked !");
		Thread.sleep(3000);	
				
		clickButton(10,closeWorkflowBtnWebElmt);
		
		Thread.sleep(2000);			
		
	}
	
	// Method 3: To edit a  work flow.
	public void edit_Workflow() throws InterruptedException
	{
		doubleClick(editWorkFlowWebElmt);
		logger.info("Clicked on Edit Workflow");
		Thread.sleep(1000);
	}
}

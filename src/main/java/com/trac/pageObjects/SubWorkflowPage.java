package com.trac.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.trac.utils.ProjectRelatedFunctions;
import com.trac.utils.SingleTonDriver;

public class SubWorkflowPage extends ProjectRelatedFunctions
{
	WebDriver driver=SingleTonDriver.getDriver();
	
	// Invoke a constructor
	public SubWorkflowPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = ".WRITE.ng-scope")
	private WebElement editSubworkFlowWebElmt;
	
	@FindBy(how = How.XPATH, using = "//div[@class='ngCellText ng-scope col1 colt1']")
	private WebElement editGridWebElmt;
	
	@FindBy(how = How.XPATH, using = "//span[@data-ng-click='add_task()']")
	private WebElement addTaskWebElmt;
	
	
	//Fields : Task Details pop-up
	@FindBy(how = How.XPATH, using = ".//*[@id='task_caption_fld']")
	private WebElement captionTaskWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen3']/a/span[2]/b")
	private WebElement taskTypeDrpWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen4_search']")
	private WebElement taskTypeSearchWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen9']")
	private WebElement performedByUserWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_teams_owners']")
	private WebElement performedByTeamWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-chosen-11']")
	private WebElement placeHolderDrpWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen11_search']")
	private WebElement placeHolderSearchWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='add_task_popup']/div[2]/div[5]/div[3]/div[2]/input")
	private WebElement worldCheckRetrigrChkBxWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='add_task_popup']/div[2]/div[5]/div[4]/div[2]/input")
	private WebElement worldCheckDualChkBxWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='add_task_popup']/div[2]/div[5]/div[5]/div[2]/input")
	private WebElement alertChkBxWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='add_task_popup']/div[2]/div[5]/div[6]/div[2]/input")
	private WebElement actWithinWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen14']/a/span[2]/b")
	private WebElement actPeriodDrpWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen15_search']")
	private WebElement actPeriodSearchWebElmt;
	
	@FindBy(how = How.XPATH, using = "//span[@data-ng-click='add_task_save()']")
	private WebElement saveTaskWebElmt;
		
	@FindBy(how = How.XPATH, using = "//span[@data-ng-click='cancel_task_popup()']")
	private WebElement cancelTaskWebElmt;
	
	
	@FindBy(how = How.XPATH, using = "//select[@class='paging-count ng-pristine ng-valid']")
	private WebElement pageWebElmt;
	
	
		
	//Method 1: To edit a Sub-Work flow
	public void edit_sub_Workflow() throws InterruptedException
	{
		doubleClick(editSubworkFlowWebElmt);		
		Thread.sleep(1000);
	}
	
	//Method 2: To add a new task
	public void click_Add_task() throws InterruptedException
	{
		clickButton(10,addTaskWebElmt);		
		Thread.sleep(1500);
	}
	
	//Method 2: Create User Task 
	public void create_User_task_details() throws InterruptedException
	{			
		try 
		{
			setValue(10,captionTaskWebElmt,taskCaption[0]);
			Thread.sleep(1000);
			
			setValue(10,performedByUserWebElmt,userName);
			Thread.sleep(1000);
			
			performedByUserWebElmt.sendKeys(Keys.ENTER);
			
//			setValue(10,performedByTeamWebElmt,teamName);
//			Thread.sleep(1000);
//			
//			performedByTeamWebElmt.sendKeys(Keys.TAB);
			
//			clickButton(10,placeHolderDrpWebElmt);		
//			Thread.sleep(2000);
//			
//			setValue(10,placeHolderSearchWebElmt,placeholder);
//			Thread.sleep(1000);
//			
//			placeHolderSearchWebElmt.sendKeys(Keys.TAB);
			
			//Check whether world Check Retrigger checkbox is enabled
			if(!worldCheckRetrigrChkBxWebElmt.isSelected())
			{
				worldCheckRetrigrChkBxWebElmt.click();
			}
						
			//Check whether world Check Dual checkbox is enabled
			if(!worldCheckDualChkBxWebElmt.isSelected())
			{
				worldCheckDualChkBxWebElmt.click();
			}
			
			setValue(10,actWithinWebElmt,actWithin);
			Thread.sleep(1000);
			
			clickButton(10,actPeriodDrpWebElmt);		
			Thread.sleep(2000);
			
			setValue(10,actPeriodSearchWebElmt,actperiod[1]);
			Thread.sleep(1000);
			
			actPeriodSearchWebElmt.sendKeys(Keys.ENTER);
			
			clickButton(10,saveTaskWebElmt);		
			Thread.sleep(2000);			
			
		} 
		catch (Exception e) 
		{
			String exception=e.toString();
			System.out.println("Unable to create a Subworkflow :" + exception);
			Assert.fail("testcase failed");
			e.printStackTrace();
		}		
		
	}
	
	//Method 3: Create approval Task 
		public void create_Approval_task_details() throws InterruptedException
		{			
			try 
			{
				setValue(10,captionTaskWebElmt,taskCaption[1]);
				Thread.sleep(1000);
				
				setValue(10,performedByUserWebElmt,userName);
				Thread.sleep(1000);
				
				performedByUserWebElmt.sendKeys(Keys.ENTER);
				
//				setValue(10,performedByTeamWebElmt,teamName);
//				Thread.sleep(1000);
//				
//				performedByTeamWebElmt.sendKeys(Keys.TAB);
				
//				clickButton(10,placeHolderDrpWebElmt);		
//				Thread.sleep(2000);
//				
//				setValue(10,placeHolderSearchWebElmt,placeholder);
//				Thread.sleep(1000);
//				
//				placeHolderSearchWebElmt.sendKeys(Keys.TAB);
				
				//Check whether world Check Retrigger checkbox is enabled
				if(!worldCheckRetrigrChkBxWebElmt.isSelected())
				{
					worldCheckRetrigrChkBxWebElmt.click();
				}
							
				//Check whether world Check Dual checkbox is enabled
				if(!worldCheckDualChkBxWebElmt.isSelected())
				{
					worldCheckDualChkBxWebElmt.click();
				}
				
				setValue(10,actWithinWebElmt,actWithin);
				Thread.sleep(1000);
				
				clickButton(10,actPeriodDrpWebElmt);		
				Thread.sleep(2000);
				
				setValue(10,actPeriodSearchWebElmt,actperiod[1]);
				Thread.sleep(1000);
				
				actPeriodSearchWebElmt.sendKeys(Keys.ENTER);
				
				clickButton(10,saveTaskWebElmt);		
				Thread.sleep(2000);			
				
			} 
			catch (Exception e) 
			{
				String exception=e.toString();
				System.out.println("Unable to create a Subworkflow :" + exception);
				Assert.fail("testcase failed");
				e.printStackTrace();
			}		
			
		}
	
	
	
	
	
	
}

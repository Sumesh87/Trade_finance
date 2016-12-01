package com.trac.pageObjects;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.trac.utils.ProjectRelatedFunctions;

public class AddOpportunityPage extends ProjectRelatedFunctions
{
	private WebDriver driver;
	
	public AddOpportunityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Fields in Add Opportunity page
	@FindBy(how = How.XPATH, using = ".//*[@id='deal_name_fld']")
	private WebElement oppReferenceWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_deal_req']/a/span[2]/b")
	private WebElement requestorWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen14_search']")
	private WebElement requestorSearchWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//select[@id='deal_type']")
	private WebElement typeWebElmt;
	
	@FindBy(how = How.CSS, using = ".//*[id^='s2id_'][id$='search']")
	private WebElement typeSearchWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='deal_value_fld']")
	private WebElement oppValueWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_deal_cur']/a/span[2]/b")
	private WebElement currDrpdwnIconWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='s2id_autogen4_search']")
	private WebElement currSearchWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='deal_exp_date']")
	private WebElement expDateWebElmt;
	
	@FindBy(how = How.XPATH, using = "//div[@id='deal_dynamic_fields']/div[1]/span[1]")
	private WebElement addBankWebElmt;
	
	@FindBy(how = How.XPATH, using = "//div[@id='deal_dynamic_fields']/div[3]/span[1]")
	private WebElement addPortWebElmt;
	
	@FindBy(how = How.XPATH, using = "//div[@id='deal_dynamic_fields']/div[5]/span[1]")
	private WebElement addIndividualWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='search_value']")
	private WebElement searchGridWebElmt;	
		
	@FindBy(how = How.XPATH, using = ".//*[@id='search_grid']/div[1]/div[1]/div[2]/div/div[1]/div[2]/input")
	private WebElement checkAllGridWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='search_grid']/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/input")
	private WebElement checkGridWebElmt;
	
	@FindBy(how = How.XPATH, using = "//span[contains(@data-ng-click,'selected()')]")
	private WebElement addToGridWebElmt;
	
	@FindBy(how = How.XPATH, using = "//span[@data-ng-click='cancel_search()']")
	private WebElement closeGridWebElmt;	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='deal_dynamic_fields']/div")
	private WebElement all_Avail_Grid;	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='save_deal']")
	private WebElement saveOppWebElmt;
	
	
    	
	// configure log4j properties file	
	Logger logger=Logger.getLogger("AddOpportunityPage");
	
	//List<WebElement> lstGrid=Collections.emptyList();
	List<WebElement> lstGrid=null;
	
	//Method 1: To enter details..
	public void create_opportunity() throws InterruptedException
	{
		try 
		{
			oppRefName=readExcel("Sheet4",1,1);				
			setValue(10,oppReferenceWebElmt,oppRefName);
			logger.info("Opportunity Ref name: '" + oppRefName + "' is entered");
			Thread.sleep(1000);				
			
			// Choose data from Requestor dropdown
			requestorName=readExcel("Sheet4",1,3);			
			clickButton(10,requestorWebElmt);
			setValue(10,requestorSearchWebElmt,requestorName);
			logger.info("Requestor name: '" + requestorName + "' is Selected");
			Thread.sleep(1000);	
			requestorSearchWebElmt.sendKeys(Keys.TAB);
			Thread.sleep(1000);	
			
			// Choose data from Type dropdown
			typeName=readExcel("Sheet4",1,4);			
			JavascriptExecutor js=(JavascriptExecutor) driver;			
			js.executeScript("document.getElementById('deal_type').style.display='block';");
						
			Select se=new Select(typeWebElmt);
			se.selectByVisibleText(typeName);			 
			logger.info("Type name: '" + typeName + "' is Selected");
			Thread.sleep(1000);	
			
			// Enter data in Opportunity Value field
			oppValue=readExcel("Sheet4",1,5);	
			oppValueWebElmt.clear();
			setValue(10,oppValueWebElmt,oppValue);
			logger.info("Opportunity Value: '" + oppValue + "' is entered");
			Thread.sleep(1000);
			
			// Choose data in Currency field
			oppCurr=readExcel("Sheet4",1,6);			
			clickButton(10,currDrpdwnIconWebElmt);
			setValue(10,currSearchWebElmt,oppCurr);
			logger.info("Currency: '" + oppCurr + "' is entered");
			Thread.sleep(1000);	
			currSearchWebElmt.sendKeys(Keys.ENTER);
			
			// Enter data in Expiry Date field
//			expdate=readExcel("Sheet4",1,7);	
//			setValue(10,expDateWebElmt,expdate);
//			logger.info("Expiry Date: '" + expdate + "' is entered");
//			Thread.sleep(1000);	
//			expDateWebElmt.sendKeys(Keys.TAB);
			
//			clickButton(10,addBankWebElmt);
//			Thread.sleep(1000);
//			expdate=readExcel("Sheet4",1,8);	
//			setValue(10,searchGridWebElmt,expdate);
//			searchGridWebElmt.sendKeys(Keys.ENTER);
//			Thread.sleep(1000);						
						
			find_Grids();
			clickButton(10,saveOppWebElmt);
			Thread.sleep(6000);
			
			
		} 
		catch (IOException e) 
		{
			Assert.fail("testcase failed");
			logger.error("creation of opportunity failed ");			
			e.printStackTrace();
		}	
	}
	
	//Method 2: find total number of Grid
	public void find_Grids() throws InterruptedException
	{
		String totalGrid=".//div[@class='side_label']";
        WebElement  table_element = driver.findElement(By.xpath(totalGrid));
        
        lstGrid=driver.findElements(By.xpath(totalGrid));
        System.out.println("Number OF Grids = "+ lstGrid.size());
        
		for(int i=1;i<=lstGrid.size();i++)	
		{
			String links=totalGrid + "["+ i + "]/span[1]";
			driver.findElement(By.xpath(links)).click();
			Thread.sleep(1000);	
			add_Items_Grids();
			Thread.sleep(5000);
		}
	}
	
	//Method 3: Add Items to Grid
	public void add_Items_Grids() throws InterruptedException
	{
		clickButton(10,checkAllGridWebElmt);
		Thread.sleep(1000);		
		clickButton(10,addToGridWebElmt);
		Thread.sleep(1000);
		clickButton(10,closeGridWebElmt);
		Thread.sleep(1000);	
	}
	
	
	
	
	
	
}

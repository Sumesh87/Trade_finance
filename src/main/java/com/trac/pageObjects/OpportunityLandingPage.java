package com.trac.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.trac.utils.ProjectRelatedFunctions;
import com.trac.utils.SingleTonDriver;

public class OpportunityLandingPage extends ProjectRelatedFunctions
{
	WebDriver driver=SingleTonDriver.getDriver();
	
	// Invoke a constructor
	public OpportunityLandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Fields: Web elements for Opportunity tabs
	@FindBy(how = How.XPATH, using = ".//*[@id='opp-tab']")
	private WebElement oppTabWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='live-tab']")
	private WebElement liveTabWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='completed-tab']")
	private WebElement completedTabWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='no-deal-tab']")
	private WebElement rejectedTabWebElmt;
	
	//Fields: Web elements for Add /Edit /Clone /Grid
	@FindBy(how = How.XPATH, using = "//li[@data-ng-click='Add()']")
	private WebElement addOpportunityWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='deals-grid']/div[2]/div/div[1]/div[1]/div[2]/div/div")
	private WebElement editOpportunityWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='deals-grid']/div[2]/div/div[1]/div[2]/div[2]/div")
	private WebElement cloneOpportunityWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='grid-display']")
	private WebElement opportunityGridWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='deals-grid']/div[2]/div/div[1]")
	private WebElement entireRowinGridWebElmt;
	
	//Fields: Web elements for Pagination links
	@FindBy(how = How.XPATH, using = ".//*[@id='pageFirst']")
	private WebElement pageFirstWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pagePrev']")
	private WebElement pagePrevWebElmt;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='pageNext']")
	private WebElement pageNextWebElmt;
	
	@FindBy(how = How.XPATH, using = "//div[@data-ng-click='goto_last()']")		
	private WebElement pageLastWebElmt;
	
	// configure log4j properties file	
	Logger logger=Logger.getLogger("OpportunityLandingPage");
	
	//Method 1: Click on Add Opportunity button
	public AddOpportunityPage clickAddOpportunity() throws InterruptedException
	{		
		clickButton(10,addOpportunityWebElmt);	
		logger.info("Clicked on Add Opportunity button");
		Thread.sleep(1000);
		return PageFactory.initElements(driver, AddOpportunityPage.class);
	}
	
	//Method 2: Click on Add Opportunity button
	public void clickOpportunityTab() throws InterruptedException
	{		
		clickButton(10,oppTabWebElmt);
		logger.info("Clicked on Opportunity Tab");
		Thread.sleep(1000);
	}
	
	//Method 3: Click on Add Opportunity button
	public void clickLiveLCTab() throws InterruptedException
	{		
		clickButton(10,oppTabWebElmt);	
		logger.info("Clicked on Live LC Tab");
		Thread.sleep(1000);
	}
		
	//Methods : To validate pagination links
	public void clickFirstPage() throws InterruptedException
	{		
		clickButton(10,pageFirstWebElmt);
		logger.info("Clicked on first page on pagination links");
		Thread.sleep(1000);
	}
	
	public void clickPrevPage() throws InterruptedException
	{		
		clickButton(10,pagePrevWebElmt);
		logger.info("Clicked on prev page on pagination links");
		Thread.sleep(1000);
	}
		
	public void clickNextPage() throws InterruptedException
	{		
		clickButton(10,pageNextWebElmt);
		logger.info("Clicked on next page on pagination links");
		Thread.sleep(1000);
	}
	
	public void clickLastPage() throws InterruptedException
	{
		//clickButton(10,pageLastWebElmt);
		doubleClick(pageLastWebElmt);
		logger.info("Clicked on last page on pagination links");
		Thread.sleep(1000);
	}
	
	
}

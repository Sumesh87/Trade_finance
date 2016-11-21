package com.trac.utils;

import org.openqa.selenium.WebDriver;

import com.trac.utils.*;

public class ProjectRelatedFunctions extends CommonFunctions
{
	WebDriver driver=SingleTonDriver.getDriver();	
		
	// Login screen parameters	
	public String uName;
	public String pwd;
			
	// Add Opportunity screen parameters
	public String oppRefName;
	public String oppValue;
	public String expdate;
	public String arrDate ;
		
	// Add Work flow screen parameters
	public String nameWorkflow;
	public String descriptionWorkflow;
	public String businessValue;
	public String userName;
	public String teamName;
	
	// Sub-Work flow pop-up parameters
	public String nameSubWorkflow;
	public String descriptionSubWorkflow;
		
	// Data points pop-up parameters
	public String captionName;
	public String dataPointName;
	public String dataPointType;
	
	
	// Screen: Sub-Work flow ; Task Details Pop -up
	protected String taskCaption[]={"Task 1","Task 2","Task 3","Task 4"};
	protected String[] taskType={"User Task","Approval Task","Review Task","Conditonal Task"};
	protected String placeholder="Requestor";
	protected Boolean worldchkRetriger;
	protected Boolean worldchkDual;
	protected Boolean alertReq;
	protected String actWithin="3";
	protected String[] actperiod={"Week","Hour","Day"};
	

	
}

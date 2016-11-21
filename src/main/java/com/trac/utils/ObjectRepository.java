package com.trac.utils;

public class ObjectRepository
{
		// Fields related to Login Screen
	
		public final static String userName ="//input[contains(@class,'form-control userid-onPaste ng-pristine ng')]";
		public final static String password ="//input[@data-ng-model='login.password_1']";
		public final static String loginBtn ="//button[contains(@class,'login-btn')]";
		public final static String forgtBtn ="//button[contains(@class,'login-btn')]";
		
		
		
		
		// Fields related to Opportunity Landing Screen
		public final static String hamburger ="//i[@class='hamburger']";
		public final static String opportunityMainMenuLnk ="//div[@title='Opportunities']";
		public final static String opportunityDealMenulnk ="//li[contains(@id,'deal-menu')]";
		public final static String addOpportunitylnk ="//li[contains(@class,'add')]";
		
		// Fields related to Add Opportunity Screen
		public final static String oppRefNmeFld = "//input[@id='deal_name_fld']";
		public final static String requestordrp = "//span[@id='select2-chosen-1']";
		public final static String selectReqdrp ="//div[@id='deal_static_fields']/div[2]/div[2]/select";
		public final static String importer =".//*[@id='select2-results-1']/li[2]/div";
		public final static String exporter =".//*[@id='select2-results-1']/li[3]/div";
		public final static String typeDrp = ".//*[@id='s2id_deal_type']/a/span[2]/b";
		public final static String typeIntra = ".//*[@id='select2-results-2']/li[2]/div";
		public final static String typeInter = ".//*[@id='select2-results-2']/li[3]/div";
		public final static String oppValueFld = ".//*[@id='deal_value_fld']";
		public final static String currencyDrp = ".//*[@id='s2id_deal_cur']/a/span[2]/b";
		public final static String currencyValue = ".//*[@id='select2-drop']/ul/li[7]";
		public final static String calandarIcn = "//span[@class='k-icon k-i-calendar']";
		public final static String exprtDateFld = ".//*[@id='deal_exp_date']";
		public final static String arrivalDateFld = ".//*[@id='deal_arr_date']";
		public final static String lcValueFld = "//input[@data-ng-model='deals.41_1']";
		public final static String tab1 = "//div[@id='tab_1']";
		public final static String tab2 = "//div[@id='tab_2']";
		public final static String saveDealBtn=".//*[@id='save_deal']";
		
		// Fields related Opportunity Grid
		public final static String sortDescOpp = ".//*[@id='deals-grid']/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[1]";
		
		
	
		
}

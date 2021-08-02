package com.orangehrm.qa.utils;

import org.testng.annotations.DataProvider;

public class DataProviderDetails {

	@DataProvider(name = "userMgmtSearch")
	public Object[][] userMgmtSearch() throws Exception {
		//Object[][] data = ExcelUtils.getTestData("C:\\Users\\minal\\git\\POMFramework\\POMpracticeFramework\\TestData\\TestData.xlsx","CredentialsData");
		Object[][] data = {{""}};
       return data;	
		
	}
	
	@DataProvider(name = "verifypassword")
	public Object[][] verifypassword() throws Exception {
		//Object[][] data = testUtils.getTestData("D:\\Projects\\Selenium\\workspace\\OrangeHRMtest\\TestData\\AddUserTestData.xlsx","confirmpassworderror");
		Object[][] data1 = {{"minal1234","minal1234"}};
       return data1;
	}
	
	@DataProvider(name = "addpagedetails")
	public Object[][] addpagedetails() throws Exception {
		//Object[][] data = testUtils.getTestData("D:\\Projects\\Selenium\\workspace\\OrangeHRMtest\\TestData\\AddUserTestData.xlsx","confirmpassworderror");
		Object[][] data2 = {{"Admin","Garry White","WhiteGarry1343","Enabled","Minal@1345!","Minal@1345!"}};
       return data2;
	}
	
	@DataProvider(name = "verifypasswordlength")
	public Object[][] verifypasswordlength() throws Exception {
		//Object[][] data = testUtils.getTestData("D:\\Projects\\Selenium\\workspace\\OrangeHRMtest\\TestData\\AddUserTestData.xlsx","confirmpassworderror");
		Object[][] data3 = {{"Minal@1345!"}};
       return data3;
	}
	
}

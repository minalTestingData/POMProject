package com.orangehrm.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.SystemUserPage;
import com.orangehrm.qa.pages.addUserPage;

public class SystemUserPageTest extends TestBase{

SystemUserPage systemuserpage;
HomePage homepage;
addUserPage adduserpage;

	public SystemUserPageTest() {
		super();
	}
	
	@BeforeMethod
	public void beforeMethodSetup() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickAdminLink();
		systemuserpage = new SystemUserPage();
	}
	
	@Test(dataProvider="userMgmtSearch",dataProviderClass = com.orangehrm.qa.utils.DataProviderDetails.class)
	public void searchUserDetailsTest(String username) {
		systemuserpage.searchUserDetailsByUsername(username);
		boolean flag = systemuserpage.isUserAvailableByUsername(username);
		Assert.assertTrue(flag);		
	}
	
	@Test
	public void resetUserDetailsTest() {
		systemuserpage.resetUserDetails();
		String[] input =systemuserpage.getInputUserDetails();
		Assert.assertTrue(((input[0].equals("")) && (input[1].equals("All")) && 
				(input[2].equals("")) && (input[3].equals("All"))),"Reset button not working");
	}
	
	@Test
	public void addUserDetailsTest() {
		adduserpage = systemuserpage.addUserDetails();
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser");
	}
	
	
	@Test(dataProvider="userMgmtSearch",dataProviderClass = com.orangehrm.qa.utils.DataProviderDetails.class)
	public void deleteUserByUsernameTest(String uname) {
		boolean flag = systemuserpage.isUserAvailableByUsername(uname);
		if (flag) {
		systemuserpage.deleteUserByUsername(uname);}
		Assert.assertFalse(systemuserpage.isUserAvailableByUsername(uname),"User you are trying to delete is not deleted");
	}
	
}

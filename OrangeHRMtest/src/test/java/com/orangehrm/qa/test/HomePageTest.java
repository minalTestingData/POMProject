package com.orangehrm.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.EmployeeListPage;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.SystemUserPage;

public class HomePageTest extends TestBase {

	HomePage homepage;
	SystemUserPage systemuserpage;
	EmployeeListPage employeelistpage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void beforeMethodSetup() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void VerifyloginLableDisplayed() {
		boolean flag=homepage.validateLoginLable();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void VerifyAdminLinkTest() {
		systemuserpage= homepage.clickAdminLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	}
	
	@Test
	public void VerifyPimLinkTest() {
		employeelistpage=homepage.clickPimLink();
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
	}
}

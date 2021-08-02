package com.orangehrm.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;



public class LoginpPageTest extends TestBase{

	HomePage homepage;
	
	public LoginpPageTest() {
		super();
	}

	@Test(priority=1)
	public void Verifyloginpannel() {
		boolean flag=loginpage.validateLoginpanel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void Verifylogin() {
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	//Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}
	
	
}

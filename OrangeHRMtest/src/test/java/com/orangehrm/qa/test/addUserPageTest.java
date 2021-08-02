package com.orangehrm.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.SystemUserPage;
import com.orangehrm.qa.pages.addUserPage;

public class addUserPageTest extends TestBase{

	SystemUserPage systemuserpage;
	HomePage homepage;
	addUserPage adduserpage;
	
public addUserPageTest() {
	super();
}

@BeforeMethod
public void addUsersetup() {
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	homepage.clickAdminLink();
	systemuserpage = new SystemUserPage();
	systemuserpage.addUserDetails();
	adduserpage = new addUserPage();
}

@Test
public void empnameRequiredErrorMessageTest() {
	boolean flag=adduserpage.empnameRequiredErrorMessage();
	Assert.assertTrue(flag, "'Required' error message is not displayed for Employee Name field");
}

@Test
public void empNotExistErrorMessageTest() {
boolean flag=adduserpage.empNotExistErrorMessage();
Assert.assertTrue(flag, "'Employee does not exist' error message is not displayed for Employee Name field");
}

@Test
public void usernameRequiredErrorMessageTest() {
	boolean flag=adduserpage.usernameRequiredErrorMessage();
	Assert.assertTrue(flag, "'Required' error message is not displayed for Username field");
}

@Test
public void passwordRequiredErrorMessageTest() {
	boolean flag=adduserpage.passwordRequiredErrorMessage();
	Assert.assertTrue(flag, "'Required' error message is not displayed for password field");
} 

@Test(dataProvider="verifypassword",dataProviderClass = com.orangehrm.qa.utils.DataProviderDetails.class)
public void confirmPasswordRequiredErrorMessageTest(String upassword, String uconfirmpassword) {
	boolean flag=adduserpage.confirmPasswordRequiredErrorMessage(upassword, uconfirmpassword);
	Assert.assertTrue(flag, "'Passwords do not match' error message is not displayed for password field");
}


@Test(dataProvider="addpagedetails",dataProviderClass = com.orangehrm.qa.utils.DataProviderDetails.class)
public void addUserDetailsTest(String userrole, String empname, String uname, String ustatus, String upassword, String uconfirmpassword)  {
	adduserpage.addUserDetails(userrole,empname,uname,ustatus,upassword,uconfirmpassword);
	boolean flag= systemuserpage.isUserAvailableByUsername(uname);
	Assert.assertTrue(flag);	
}

@Test(dataProvider="verifypasswordlength",dataProviderClass = com.orangehrm.qa.utils.DataProviderDetails.class)
public void passwordlengthErrorMessageTest(String passwd) {
	boolean flag = adduserpage.passwordlengthErrorMessage(passwd);	
	Assert.assertTrue(flag,"'Should have at least 8 characters' error message is not displayed for password field");
}
}

package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;


public class LoginPage extends TestBase{

	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement login;
	
	@FindBy(id="logInPanelHeading")
	WebElement loginpanel;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLoginpanel() {
		loginpanel.isDisplayed();
		return true;
	}

	public HomePage login(String uname, String passwd) {
		username.sendKeys(uname);
		password.sendKeys(passwd);
		login.click();
		return new HomePage();
	}
}

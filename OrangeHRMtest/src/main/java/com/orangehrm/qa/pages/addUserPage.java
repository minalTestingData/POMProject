package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.utils.testUtils;

public class addUserPage extends TestBase  {

	@FindBy (id="systemUser_employeeName_empName")
	WebElement employeename;
	
	@FindBy (id="systemUser_userName")
	WebElement username;
	
	@FindBy (id="systemUser_password")
	WebElement password;
	
	@FindBy (id="systemUser_confirmPassword")
	WebElement confirmpassword;
	
	@FindBy (id="btnSave")
	WebElement savebtn;
	
	
	@FindBy(xpath="//input[@id='systemUser_employeeName_empName']//parent::li//child::span[contains(text(),'Required')]")
	WebElement emperrormsg;
	
	@FindBy(xpath="//input[@id='systemUser_employeeName_empName']//parent::li//child::span[contains(text(),'Employee does not exist')]")
	WebElement empnotexisterror;
	
	@FindBy(xpath="//input[@id='systemUser_userName']//parent::li//child::span[contains(text(),'Required')]")
	WebElement unameerrormsg;
	
	@FindBy(xpath="//input[@id='systemUser_password']//parent::li//child::span[contains(text(),'Required')]")
	WebElement passwderrormsg;
	
	@FindBy(xpath="//input[@id='systemUser_confirmPassword']//parent::li//child::span[contains(text(),'Passwords do not match')]")
	WebElement confirmpassworderror; 
	
	@FindBy(xpath="//input[@id='systemUser_password']//parent::li//child::span[contains(text(),'Should have at least 8 characters')]")
	WebElement passwdlenghtherror;
	
	
	public addUserPage() {
	 PageFactory.initElements(driver, this);	
	}
	
	public void addUserDetails(String userrole, String empname, String uname, String ustatus, String upassword, String uconfirmpassword) {
	testUtils.selectClassGeneric(By.id("systemUser_userType")).selectByVisibleText(userrole);
	employeename.sendKeys(empname);
	username.sendKeys(uname);
	testUtils.selectClassGeneric(By.id("systemUser_status")).selectByVisibleText(ustatus);
	password.sendKeys(upassword);
	confirmpassword.sendKeys(uconfirmpassword);
	savebtn.click();
	savebtn.submit();
		
	}
	
	public boolean empnameRequiredErrorMessage() {
		try{
			employeename.sendKeys("");
			savebtn.click();
		if(emperrormsg.isDisplayed()) {
			return true;
			}}catch(Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	
	public boolean empNotExistErrorMessage() {
		try{	
			savebtn.click();
		if(empnotexisterror.isDisplayed()) {
			return true;
			}}catch(Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	
	public boolean usernameRequiredErrorMessage() {
		savebtn.click();
		if(unameerrormsg.isDisplayed()) {
			return true;
			}
		return false;
	}	

	public boolean passwordRequiredErrorMessage() {
		savebtn.click();
		if(passwderrormsg.isDisplayed()) {
			return true;
			}
		return false;
	}

	public boolean confirmPasswordRequiredErrorMessage(String upassword, String uconfirmpassword) {
		password.sendKeys(upassword);
		confirmpassword.sendKeys(uconfirmpassword);
		savebtn.click();
		if(upassword.equals(uconfirmpassword)) {
			return false;
			}
		return true;
	}

	public boolean passwordlengthErrorMessage(String upassword) {
		password.sendKeys(upassword);
		savebtn.click();
		if(upassword.length()>=8) {
			return true;
			}
		return false;
	}
}

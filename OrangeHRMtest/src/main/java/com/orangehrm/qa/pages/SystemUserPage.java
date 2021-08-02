package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.utils.testUtils;

public class SystemUserPage extends TestBase{
	
	@FindBy(id="searchBtn")
	WebElement search;
	
	@FindBy(id="resetBtn")
	WebElement reset;
	
	@FindBy(id="btnAdd")
	WebElement add;
	
	@FindBy(id="btnDelete")
	WebElement delete;
	
	public SystemUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void searchUserDetailsByUsername(String username) {
		
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username);
		search.click();		
	}
	
	public void resetUserDetails() {
		reset.click();	
	}
		
	public addUserPage addUserDetails() {
		add.click();
		return new addUserPage();
	}
		
	public void deleteUserByUsername(String uname) {
		driver.findElement(By.xpath("//a[contains(text(),'"+uname+"')]//"
				+ "parent::td//preceding-sibling::td//child::input[contains(@id,'ohrmList_chkSelectRecord')]")).click();
		delete.click();
		driver.switchTo().activeElement().submit();
		driver.navigate().refresh();
	}
	
	public boolean isUserAvailableByUsername(String uname) {
		try {
		String username=driver.findElement(By.xpath("//a[contains(text(),'"+uname+"')]")).getText();
		if(username.equalsIgnoreCase(uname)) { 
			return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Username is not available");
		}
		return false;
	}
	
	
	public String[] getInputUserDetails() {
		
		String uname = driver.findElement(By.id("searchSystemUser_userName")).getText();
		String urole = testUtils.selectClassGeneric(By.id("searchSystemUser_userType")).getFirstSelectedOption().getText();
		String empname = driver.findElement(By.id("searchSystemUser_employeeName_empName")).getText();
		String ustatus = testUtils.selectClassGeneric(By.id("searchSystemUser_status")).getFirstSelectedOption().getText();
		return new String[] {uname,urole,empname,ustatus};
	}
	
}

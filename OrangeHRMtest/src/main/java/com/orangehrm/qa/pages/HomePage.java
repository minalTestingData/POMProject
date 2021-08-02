package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(id="welcome")
	WebElement loginlable;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminlink;
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement pimlink;
	
	@FindBy(id="menu_leave_viewLeaveModule")
	WebElement leavelink;
	
	@FindBy(id="menu_time_viewTimeModule")
	WebElement timelink;
	
	
	//Initializing the page object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validateLoginLable() {
		return loginlable.isDisplayed();
	}
	
	public SystemUserPage clickAdminLink() {
		adminlink.click();
		return new SystemUserPage();
	}
	
	public EmployeeListPage clickPimLink() {
		pimlink.click();
		return new EmployeeListPage();
	}
	
	public LeaveListPage clickLeaveLink() {
		leavelink.click();
		return new LeaveListPage();
	}
	
	public EmployeeTimesheetPage clickTimeLink() {
		timelink.click();
			return new EmployeeTimesheetPage();
		}
}

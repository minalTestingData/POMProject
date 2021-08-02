package com.orangehrm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.qa.base.TestBase;

public class testUtils extends TestBase {

	public static int page_load_timeout=20;
	public static int implicit_wait=30;
	
	public static Workbook book;
	public static Sheet sheet;
		
	public static Select selectClassGeneric(By locator) {
		Select select = new Select(driver.findElement(locator));
		return select;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	
	public static Object[][] getTestData(String filePath,String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*
	public static void selectDropDownGeneric(By locator, String type, String value ) {
		Select select = new Select(driver.findElement(locator));
		switch(type) {	
	case "index":
		select.selectByIndex(Integer.parseInt(value));
		break;
	
	case "value":
		select.selectByValue(value);
		break;
	
	case "visibleText":
		select.selectByVisibleText(value);
		break;
		
	default: 
		System.out.println("Please pass the correct selection area");
		break;
	}
	}*/
}

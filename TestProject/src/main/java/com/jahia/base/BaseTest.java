package com.jahia.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class BaseTest {
	
	public static WebDriver webDriver;
	public static String username;
	public static String password;
	SoftAssert sa = new SoftAssert();

	@BeforeSuite
	public void beforeSuite( ) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		try {
			// Here we can do some sorts of reporting (for e.g. with ExtentReports)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void afterSuite() {
		//Here we can use Flush or endTest
	}
	
	/**
	 * Generates and logs pass/fail message depending if the actual text contains expected text
	 * @param actualVal the String for actual text
	 * @param expectedVal the String for expected text
	 * @param message a String for the explanation to  be written in the logger
	 */
	protected void verifyText(String actualVal, String expectedVal, String message) {
		String actual = actualVal.trim();
		String expected = expectedVal.trim();
		if(expected.contains(actual)) {
			//can log some message here for PASS result
		}
	}
}

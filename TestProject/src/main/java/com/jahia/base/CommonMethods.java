package com.jahia.base;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	
	protected static WebDriver browser;
	protected WebDriverWait wait;
	final int timeOutInSeconds = 30;
	
	public CommonMethods(WebDriver browser) {
		this.browser = browser;
		wait = new WebDriverWait(this.browser, timeOutInSeconds);
		PageFactory.initElements(browser, this);
	}

	/**
	 * Generates random String that only contains the alphabet
	 * @param length the length of the String
	 * @return the random String
	 */
	public String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<length; i++) {
			Random rnd = new Random();
			char c = getAscii(rnd.nextInt(26) + 'a');
			sb.append(c);
		}
		String lotsOfCharacters = sb.toString();
		return lotsOfCharacters;
	}
	
	/**
	 * Get the ASCII character from  a decimal value
	 * <p> This method also supports the extended ASCII table </p>
	 * @param code the decimal value of the character
	 * @return the character that the code corresponds to
	 */
	public final char getAscii(int code) {
		final char[] EXTENDED = { 0x00C7, 0X00FC
				
		};
		
		if (code >= 0x80 && code <=0xFF) {
			return EXTENDED[code - 0x80];
		}
		return (char) code;
 	}
	
	/**
	 * Return the text in the text field
	 * @param locator the WebElement element
	 * @return String
	 */
	protected String getText(WebElement element) {
		return waitForElement(element).getText();
	}
	
	/**
	 * Returns Webelement object if the webelement with the element is visible
	 * @param locator Webelement element for the text field element
	 * @return WebElement
	 */
	private WebElement waitForElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
}

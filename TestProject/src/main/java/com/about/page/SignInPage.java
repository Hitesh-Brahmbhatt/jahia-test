package com.about.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignInPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@name='username']")
	private WebElement userName;
	public WebElement getUserName() {
		return this.userName;
	}

	@FindBy(xpath="//*[@name='password']")
	private WebElement password;
	public WebElement getPassword() {
		return this.password;
	}

	@FindBy(xpath="//*[@type='submit']")
	private WebElement login;
	public WebElement getLoginButton() {
		return this.login;
	}
	
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); 
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://localhost:8080/jahia/page-composer/sites/digitall/home.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void openApplication(String username, String password) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
		getUserName().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
	}
	
}

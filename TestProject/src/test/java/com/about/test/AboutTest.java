package com.about.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.about.page.AboutPage;
import com.about.page.SignInPage;
import com.jahia.base.BaseTest;
import com.jahia.util.Util;

public class AboutTest extends BaseTest {

	private SignInPage signIn = new SignInPage();
	private AboutPage about = new AboutPage();
	public String randomString = "";
	
	@BeforeTest(description="login to app and move to about section")
	public void navigateToAboutPage() {
		try {
			Util.initPropertySetup();
			String username = Util.properties.getProperty("USERNAME");
			String password = Util.properties.getProperty("PASSWORD");
			signIn.openBrowser();
			signIn.openApplication(username, password);
			about.clickAboutPage();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	final private boolean PRINCIPAL_FLOW = true;
	final private boolean TC1 = PRINCIPAL_FLOW;
	
	@Test(description="001_Add some content on the About Page and validate", priority= 1, enabled = TC1)
	public void TC1() {
		// We can use here logger class to start loggin the beginning of the test. We can also use logInfo and logWarning at everystep to start loggin user actions
		about.clickAddContent();
		randomString = about.addRandomContent();
		about.navigateToAboutPage();
		verifyText(about.actualTextAdded(), randomString, "About page contains the required text");
	}
	
}


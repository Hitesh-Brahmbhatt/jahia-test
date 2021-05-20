package com.about.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.jahia.base.CommonMethods;

public class AboutPage extends CommonMethods {

	WebDriver driver;
	
	public AboutPage() {
		super(browser);
		PageFactory.initElements(browser, this);
	}

	@FindBy(id="x-auto-56_x-auto-113")
	private WebElement about;
	public WebElement getAboutSection() {
		return this.about;
	}

	@FindBy(id="#x-auto-183")
	private WebElement addContent;
	public WebElement getAddContent() {
		return this.addContent;
	}

	@FindBy(xpath="//*[@data-sel-role='content-type-tree']/div/button[2]")
	private WebElement contentBasic;
	public WebElement getContentBasic() {
		return this.contentBasic;
	}
	
	@FindBy(xpath="//*[@data-sel-role='content-type-tree']/div/div/div[3]")
	private WebElement richText;
	public WebElement getRichText() {
		return this.richText;
	}
	
	@FindBy(xpath="//*[@data-sel-role='content-type-dialog-create']")
	private WebElement createButton;
	public WebElement getCreateButton() {
		return this.createButton;
	}
	
	@FindBy(xpath="//*[@data-sel-role='submitSave']")
	private WebElement saveButton;
	public WebElement getSaveButton() {
		return this.saveButton;
	}
	
	@FindBy(xpath="//*[@data-sel-role='publishAction']")
	private WebElement publishNowButton;
	public WebElement getPublishNowButton() {
		return this.publishNowButton;
	}
	
	@FindBy(id="cke_302_contents")
	private WebElement textBody;
	public WebElement getTextBody() {
		return this.textBody;
	}
	
	@FindBy(xpath="//*[@Class='wrapper']/p")
	private WebElement actualTextElement;
	public WebElement getActualTextElement() {
		return this.actualTextElement;
	}
		
	public void clickAboutPage() {
		getAboutSection().click();
	}
	
	public void clickAddContent() {
		getAddContent().click();
	}
	
	
	public String addRandomContent() {
		getContentBasic().click();
		getRichText().click();
		getCreateButton().click();
		// we can switch here frame here by id or classname. 
		driver.switchTo().frame("cke_302_contents");
		String randomString  = generateRandomString(6);
		getTextBody().sendKeys(randomString);
		getSaveButton().click();
		getPublishNowButton().click();
		return randomString;
	}
	
	public void navigateToAboutPage() {
		driver.get("http://localhost:8080/sites/digitall/home/about.html");
	}
	
	public String actualTextAdded() {
		return getText(getActualTextElement());
	}
	
}

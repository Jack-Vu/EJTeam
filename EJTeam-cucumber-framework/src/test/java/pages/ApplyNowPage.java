package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pojo.Application;

public class ApplyNowPage {
	private WebDriver driver;

	@FindBy(how = How.NAME, using = "")
	private WebElement firstNameField;

	@FindBy(how = How.NAME, using = "")
	private WebElement middleNameField;

	@FindBy(how = How.NAME, using = "")
	private WebElement lastNameField;

	@FindBy(how = How.NAME, using = "")
	private WebElement birthdayField;

	@FindBy(how = How.NAME, using = "")
	private WebElement maleButton;

	@FindBy(how = How.NAME, using = "")
	private WebElement femaleButton;

	@FindBy(how = How.NAME, using = "")
	private WebElement otherButton;

	@FindBy(how = How.NAME, using = "")
	private WebElement emailField;

	@FindBy(how = How.NAME, using = "")
	private WebElement phoneNumberField;

	@FindBy(how = How.NAME, using = "")
	private WebElement courseDropdown;

	@FindBy(how = How.NAME, using = "")
	private WebElement howDidYouHearDropdown;

	@FindBy(how = How.NAME, using = "")
	private WebElement robotButton;

	@FindBy(how = How.NAME, using = "")
	private WebElement submitApplicatioButton;

	public ApplyNowPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillOutApplicationandSubmit(Application application) {
		firstNameField.sendKeys(application.firstName);
		middleNameField.sendKeys(application.middleName);
		lastNameField.sendKeys(application.lastName);
		birthdayField.sendKeys(application.birthday);
		emailField.sendKeys(application.email);
		phoneNumberField.sendKeys(application.phoneNumber);
		submitApplicatioButton.click();
	}

	public void fillOutApplication(Application application) {
		firstNameField.sendKeys(application.firstName);
		middleNameField.sendKeys(application.middleName);
		lastNameField.sendKeys(application.lastName);
		birthdayField.sendKeys(application.birthday);
		emailField.sendKeys(application.email);
		phoneNumberField.sendKeys(application.phoneNumber);
	}

	public void clickOnSubmitApplicationButton(Application application) {
		submitApplicatioButton.click();
	}

}

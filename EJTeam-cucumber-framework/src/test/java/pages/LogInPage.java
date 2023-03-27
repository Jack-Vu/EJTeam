package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pojo.Credentials;

public class LogInPage {
	private WebDriver driver;

	@FindBy(how = How.NAME, using = "email")
	private WebElement emailField;

	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//input[@value = 'Login']")
	private WebElement logInButton;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void logInAndSubmit(Credentials credentials) {
		emailField.sendKeys(credentials.email);
		passwordField.sendKeys(credentials.password);
		logInButton.click();

	}

	public void enterLogInCredentials(Credentials credentials) {
		emailField.sendKeys(credentials.email);
		passwordField.sendKeys(credentials.password);

	}

	public void clickLogInButton(Credentials credentials) {
		logInButton.click();

	}
}

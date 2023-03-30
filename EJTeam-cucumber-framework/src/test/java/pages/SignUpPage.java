package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pojo.Credentials;

public class SignUpPage {
	private WebDriver driver;

	@FindBy(how = How.NAME, using = "name")
	private WebElement nameField;

	@FindBy(how = How.NAME, using = "email")
	private WebElement emailField;

	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.NAME, using = "password2")
	private WebElement confirmPasswordField;

	@FindBy(how = How.XPATH, using = "//input[@value = 'Register']")
	private WebElement registerButton;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void signUpAndSubmit(Credentials credentials) {
		nameField.sendKeys(credentials.name);
		emailField.sendKeys(credentials.email);
		passwordField.sendKeys(credentials.password);
		confirmPasswordField.sendKeys(credentials.confirmPassword);
		registerButton.click();
	}

	public void enterSignUpCredentials(Credentials credentials) {
		nameField.sendKeys(credentials.name);
		emailField.sendKeys(credentials.email);
		passwordField.sendKeys(credentials.password);
		confirmPasswordField.sendKeys(credentials.confirmPassword);
	}

	public void clickOnRgisterButton() {
		registerButton.click();
	}

}

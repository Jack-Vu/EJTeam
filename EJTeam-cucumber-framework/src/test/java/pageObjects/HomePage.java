package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	private static final String HOMEPAGE_URL = "https://boratech-practice-app.onrender.com/"; 

	@FindBy(how = How.XPATH, using = "//a[@class = 'btn btn-primary']")
	private WebElement signUpButton;

	@FindBy(how = How.XPATH, using = "//a[@class = 'btn btn-light']")
	private WebElement logInButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver,this);
	}
	
	public void navigateToHomePage() {
		driver.get(HOMEPAGE_URL);
	}

	public void clickSignUp() {
		signUpButton.click();
	}

	public void clickLogIn() {
		logInButton.click();
	}

}


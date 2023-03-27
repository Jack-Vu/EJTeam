package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NavBar {
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[text() = 'BoraCommunity']")
	private WebElement boraCommunityLink;

	@FindBy(how = How.XPATH, using = "//a[text() = 'Register']")
	private WebElement registerLink;

	@FindBy(how = How.XPATH, using = "//a[text() = 'Login']")
	private WebElement logInLink;

	@FindBy(how = How.XPATH, using = "//a[text() = 'Apply Now']")
	private WebElement applyNowLink;

	public NavBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToBoraCommunity() {
		boraCommunityLink.click();
	}
	
	public void navigateToRegister() {
		registerLink.click();
	}
	
	public void navigateToLogin() {
		logInLink.click();
	}
	
	public void navigateToApply() {
		applyNowLink.click();
	}

}

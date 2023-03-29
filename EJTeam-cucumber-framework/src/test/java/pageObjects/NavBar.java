package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;

public class NavBar {

	// driver
	private WebDriver driver;

	// constructor
	public NavBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// elements
	@FindBy(how = How.XPATH, using = "//a[@href='/profiles']")
	private WebElement communityLink;
	@FindBy(how = How.XPATH, using = "//a[@href='/login']")
	private WebElement loginLink;
	@FindBy(how = How.XPATH, using = "//a[@href='/posts']")
	private WebElement postLink;
	@FindBy(how = How.XPATH, using = "//a[@href='/dashboard']")
	private WebElement dashboardLink;

	// actions
	public void navigateToCommunityPage() {
		communityLink.click();
	}

	public void navigateToLoginPage() {
		loginLink.click();
	}

	public void navigateToPostsPage() {
		postLink.click();
	}

	public void navigateToDashBoard() {
		dashboardLink.click();
	}

}

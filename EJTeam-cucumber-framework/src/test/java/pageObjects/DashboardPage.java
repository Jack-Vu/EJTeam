package pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Common;

public class DashboardPage {

	// local variables
	private WebDriver driver;
	private static final String URL = "https://boratech-practice-app.onrender.com/dashboard";
	private static final String TITLE = "Dashboard";

	// constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// elements
	@FindBy(how = How.XPATH, using = "//h1[text() = 'Dashboard']")
	private WebElement pageTitle;
	@FindBy(how = How.XPATH, using = "//a[@href = '/edit-profile']")
	private WebElement editProfile;
	@FindBy(how = How.XPATH, using = "//a[@href = '/add-experience']")
	private WebElement addExperience;
	@FindBy(how = How.XPATH, using = "//a[@href = '/add-education']")
	private WebElement addEducation;
	@FindBy(how = How.XPATH, using = "//h2[text()= 'Experience Credentials']/following-sibling::table[1]//td[1]")
	private List<WebElement> companyCells;
	@FindBy(how = How.XPATH, using = "//h2[text()= 'Education Credentials']/following-sibling::table[1]//td[1]")
	private List<WebElement> schoolCells;

	// actions
	public void navToEditProfilePage() {
		editProfile.click();
	}

	public void navToAddExperiencePage() {
		addExperience.click();
	}

	public void navToAddEducationPage() {
		addEducation.click();
	}

	public void validateDashBoardPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actualTitle = pageTitle.getText().trim();
		assertEquals(TITLE, actualTitle);
		String actualURL = driver.getCurrentUrl();
		assertEquals(URL, actualURL);
	}
	public void validateCompanyName(String companyName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, TITLE));
		String expectedCompanyName = companyName + "-" + Common.getRandomNumberStored();
		boolean found = false; 
		for (WebElement companyNames : companyCells) {
			String actualCompanyName = companyNames.getText();
			if(actualCompanyName.equals(expectedCompanyName)) {
				found = true;
				break;
			}
		}
		assertTrue(found, "Company with the name [" + expectedCompanyName +"] does not exist");
	}
}

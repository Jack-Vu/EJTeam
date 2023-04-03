package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pojo.Experience;
import utility.Common;

public class AddExperiencePage {

	private WebDriver driver;
	private static String experiencePageTitle;

	@FindBy(how = How.NAME, using = "title")
	private WebElement jobTitleField;

	@FindBy(how = How.NAME, using = "company")
	private WebElement companyField;

	@FindBy(how = How.NAME, using = "location")
	private WebElement locationField;

	@FindBy(how = How.NAME, using = "from")
	private WebElement fromField;

	@FindBy(how = How.NAME, using = "current")
	private WebElement currentCheckbox;

	@FindBy(how = How.NAME, using = "to")
	private WebElement toField;

	@FindBy(how = How.NAME, using = "description")
	private WebElement descriptionField;

	@FindBy(how = How.XPATH, using = "[//input[@type='submit']")
	private WebElement submitExperienceButton;

	@FindBy(how = How.XPATH, using = "[//a[text()='Go Back']")
	private WebElement goBackButton;

	public AddExperiencePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void addExperienceandSubmit(Experience experience) {
		jobTitleField
				.sendKeys(experience.jobTitle.isEmpty() ? "" : jobTitleField + "-" + Common.getRandomSixDigitCode());
		companyField.sendKeys(experience.company);
		locationField.sendKeys(experience.location);
		fromField.sendKeys(experience.fromDate);
		if (experience.current) {
			currentCheckbox.click();
		} else {
			toField.sendKeys(experience.toDate);
		}
		descriptionField.sendKeys(experience.description);
		submitExperienceButton.click();

	}

	public void addExperience(Experience experience) {
		jobTitleField.sendKeys(
				experience.jobTitle.isEmpty() ? "" : experience.jobTitle + "-" + Common.getRandomSixDigitCode());
		companyField.sendKeys(experience.company);
		locationField.sendKeys(experience.location);
		fromField.sendKeys(experience.fromDate);
		if (experience.current) {
			currentCheckbox.click();
		} else {
			toField.sendKeys(experience.toDate);
		}
		descriptionField.sendKeys(experience.description);
		submitExperienceButton.click();

	}

	public void submitExperience() {
		submitExperienceButton.click();
	}

	public void clearExperience(Experience experience) {
		jobTitleField.clear();
		companyField.clear();
		locationField.clear();
		fromField.sendKeys();
		if (experience.current) {
			currentCheckbox.clear();
		} else {
			toField.clear();
		}
		descriptionField.clear();
	}

	public void cancelExperience() {
		goBackButton.click();
	}

	public String getExperiencePageTitle() {
		experiencePageTitle = driver.getTitle();
		return experiencePageTitle;

	}

}

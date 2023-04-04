package pageObjects;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.Common;

public class PostPage {

	private WebDriver driver;
	String expectedUserName; 
	String expectedPostContent; 
	String actualUserName;
	String actualPostContent;
	boolean found = false;

	@FindBy(how = How.XPATH, using = "[//textarea[@placeholder = 'Create a post']")
	WebElement postField;

	@FindBy(how = How.XPATH, using = "[//input[@type= 'submit']")
	WebElement submitPostButton;

	@FindBy(how = How.XPATH, using = "[//div[@class= 'post bg-white p-1 my-1']")
	List<WebElement> postContainers;

	@FindBy(how = How.XPATH, using = "[//i[@class= 'fas fa-thumbs-up']")
	WebElement thumbsUpButton;

	@FindBy(how = How.XPATH, using = "[//i[@class= 'fas fa-thumbs-down']")
	WebElement thumbsDownButton;

	@FindBy(how = How.XPATH, using = "[//a[text()= 'Discussion']")
	WebElement discussionButton;

	@FindBy(how = How.TAG_NAME, using = "h4")
	WebElement user;

	@FindBy(how = How.TAG_NAME, using = "p")
	WebElement post;

	public PostPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterPostAndSubmit(String content) {
		postField.sendKeys(content + "-" + Common.getRandomSixDigitCode());
		submitPostButton.click();
	}

	public void enterPost() {
		postField.sendKeys();
	}

	public void clearPost() {
		postField.clear();
	}

	public void submitPost() {
		submitPostButton.click();
	}

	public void thumbsUpPost() {
		validatePostByNameAndContent(expectedUserName, expectedPostContent); 
		if (found) {
			thumbsUpButton.click();
		}
		
		assertTrue(found, "The post [" + expectedPostContent + "] from [" + expectedUserName + "] was not found");
	}

	public void thumbsDownPost() {
		validatePostByNameAndContent(expectedUserName, expectedPostContent); 
		if (found) {
			thumbsDownButton.click();
		}
		
		assertTrue(found, "The post [" + expectedPostContent + "] from [" + expectedUserName + "] was not found");
	}

	public void enterDiscussion() {

		validatePostByNameAndContent(expectedUserName, expectedPostContent); 
		if (found) {
			discussionButton.click();
		}
		
		assertTrue(found, "The post [" + expectedPostContent + "] from [" + expectedUserName + "] was not found");
	}

	public void validatePostByNameAndContent(String expectedUserName, String expectedPostContent) {
		for (WebElement postContainer : postContainers) {
			actualUserName = user.getText();
			actualPostContent = post.getText();
			if (expectedUserName.equals(actualUserName) && expectedPostContent.equals(actualPostContent)) {
				found = true;
				break;
			}
			
		}
		assertTrue(found, "The post [" + expectedPostContent + "] from [" + expectedUserName + "] was not found"); 

	}

}

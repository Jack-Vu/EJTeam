package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DiscussionPage {
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "[//textarea[@placeholder= 'Leave a Comment']")
	WebElement leaveCommentField;

	@FindBy(how = How.XPATH, using = "[//a[text()= 'Back To Posts']")
	WebElement goBackButton;

	@FindBy(how = How.XPATH, using = "[//input[@value= 'Submit']")
	WebElement submitCommentButton;

	public void enterCommentAndSubmit(String comment) {
		leaveCommentField.sendKeys(comment);
		submitCommentButton.click();
	}

	public void submitComment() {
		submitCommentButton.click();
	}

	public void clearComment() {
		leaveCommentField.clear();
	}

	public void goBackToPostsPage() {
		goBackButton.click();
	}

}

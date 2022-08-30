package actitimepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkflowSettingsPage {
	
	public WorkflowSettingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(text(),'open tasks')]/..//div[text()='Add new status']")
	private WebElement addNewStatusButton;

	@FindBy(xpath = "//input[@placeholder='Status name']")
	private WebElement StatusNameTextBox;

	@FindBy(className = "container_tasks")
	private WebElement tasksLink;
	
	@FindBy(xpath = "//div[text()='Apply']")
	private WebElement applyButton;
	
	@FindBy(xpath = "//div[@class=\"deleteIcon\"]")
	private WebElement delteButton;

	public WebElement getAddNewStatusButton() {
		return addNewStatusButton;
	}

	public WebElement getStatusNameTextBox() {
		return StatusNameTextBox;
	}

	public WebElement getTasksLink() {
		return tasksLink;
	}

	public WebElement getApplyButton() {
		return applyButton;
	}

	public WebElement getDelteButton() {
		return delteButton;
	}

	
	
}

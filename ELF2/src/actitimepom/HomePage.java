package actitimepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath  = "//div[contains(@class,'settings')]//div[@class='menu_icon']")
	private WebElement setingsIcon;
	
	@FindBy(className = "container_tt")
	private WebElement timeTrackLink;
	
	@FindBy(id = "container_tasks")
	private WebElement tasksLink;
	
	@FindBy(id = "container_reports")
	private WebElement reportsLink;
	
	@FindBy(id = "container_users")
	private WebElement usersLink;
	
	public WebElement getSetingsIcon() {
		return setingsIcon;
	}

	public WebElement getTimeTrackLink() {
		return timeTrackLink;
	}

	public WebElement getTasksLink() {
		return tasksLink;
	}

	public WebElement getReportsLink() {
		return reportsLink;
	}

	public WebElement getUsersLink() {
		return usersLink;
	}

	public WebElement getWorkflowSettingsLink() {
		return workflowSettingsLink;
	}
	@FindBy(linkText = "Workflow Settings")
	private WebElement workflowSettingsLink;
	
	
}

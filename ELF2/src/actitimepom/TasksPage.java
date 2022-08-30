package actitimepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage {
	public TasksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Test flight']/ancestor::tr//div[@class='taskStatusButton editable']")
	private WebElement statusBox;
	
	@FindBy(xpath = "//div[text()='OPEN TASKS']/..//div[text()='ELF']")
	private WebElement elfButton;

	public WebElement getStatusBox() {
		return statusBox;
	}

	public WebElement getElfButton() {
		return elfButton;
	}
	
	
}

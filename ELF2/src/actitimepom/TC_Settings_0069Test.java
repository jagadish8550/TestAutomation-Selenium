package actitimepom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_Settings_0069Test {
	@Test
	public void LoginTest() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://online.actitime.com/testall/login.do");
		LoginPage login=new LoginPage(driver);
		login.getUserNameTextField().clear();
		login.getUserNameTextField().sendKeys();
		login.getPasswordTextField().clear();
		login.getPasswordTextField().sendKeys("VVMnb%jv");
		login.getLoginButton().click();
		HomePage home=new HomePage(driver);
		home.getSetingsIcon().click();
		home.getWorkflowSettingsLink().click();
		WorkflowSettingsPage workflowSettings=new WorkflowSettingsPage(driver);
		workflowSettings.getAddNewStatusButton().click();
		workflowSettings.getStatusNameTextBox().clear();
		workflowSettings.getStatusNameTextBox().sendKeys("ELF");
		workflowSettings.getApplyButton();
		
	}
}

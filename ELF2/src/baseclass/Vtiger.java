package baseclass;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Vtiger extends BaseClass {
	@Test
	public void someAction() {
		driver.findElement(By.xpath("//a[@title='Calendar']")).click();
		Reporter.log("Clicked on calender",true);
		driver.findElement(By.xpath("//img[@alt='vtiger-crm-logo.png']/.."));
		Reporter.log("Home page is displayed successfully",true);
	}
}

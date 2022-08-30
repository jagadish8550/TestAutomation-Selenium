package demowebshoppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClickOnRegister {
	@Test
	public void clickOnRegister() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/apparel-shoes");
		HomePage home=new HomePage(driver);
		home.getRegisterLink().click();
		home.getRegisterLink().click();
	}
}

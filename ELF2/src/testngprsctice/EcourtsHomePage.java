package testngprsctice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class EcourtsHomePage {
	@Test
	public void ecourtsHomePage() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ecourts.gov.in/ecourts_home/");
		driver.quit();
	}
	@Test
	void homePage() {
		Reporter.log("hello",true);
	}
}

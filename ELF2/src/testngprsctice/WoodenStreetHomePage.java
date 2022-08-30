package testngprsctice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WoodenStreetHomePage {
	@Test
	public void woodenStreetTest() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.woodenstreet.com/");
		driver.quit();
	}
}

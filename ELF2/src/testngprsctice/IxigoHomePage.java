package testngprsctice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IxigoHomePage {
	@Test
	public void ixigoHome() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ixigo.com/");
		driver.quit();
	}
}

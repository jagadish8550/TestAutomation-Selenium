package testngprsctice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TrelloHomePage {
	@Test
	public void trelloHomePage() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trello.com/");
		driver.quit();
	}
}

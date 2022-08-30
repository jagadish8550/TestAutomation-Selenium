package testngprsctice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MavenRepositoryHome {
	@Test
	public void mavenRepository() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mvnrepository.com/");
		driver.close();
	}
}

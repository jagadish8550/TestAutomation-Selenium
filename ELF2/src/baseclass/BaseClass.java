package baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		driver=new ChromeDriver();
		Reporter.log("Browser is launched successfully",true);
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized successfully",true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void login() {
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		Reporter.log("url is passed successfully",true);
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
		Reporter.log("Sign in successfull ",true);
	}
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//span[@title='Atlas Jeniffer(admin)']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		Reporter.log("Signout successfull",true);
	}
	@AfterClass
	public void quitBrowser() {
		driver.quit();
		Reporter.log("browser is closed successfully",true);
	}
}

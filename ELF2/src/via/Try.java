package via;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Try {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://in.via.com/hotels");
		HotelsPage hotels=new HotelsPage(driver);
		hotels.checkInCal("Jul", 31);
		hotels.checkOutCal("Aug", 16);
//		driver.quit();
	}
}

package specific;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AirAsiaCalender {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LocalDateTime ldt=LocalDateTime.now();
		int date = ldt.getDayOfMonth();
		int year = ldt.getYear()+1;
		String mon = ldt.getMonth().toString();
		String month = mon.charAt(0)+mon.substring(1,3).toLowerCase();
		driver.get("https://www.airasia.co.in/home");
		driver.findElement(By.id("start-date-input-button\"")).click();
		calanderHandle(driver, month, date, year);
		//driver.quit();
	}
	public static void calanderHandle(WebDriver driver,String month,int date,int year) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month+" "+year+"']/..//div[text()='"+date+"']")).click();
				break;
			}
			catch (NoSuchElementException e) {
				jse.executeScript("window.scrollBy(0,50)");
			}
		}
	}
}

package specific;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SpiceJetCalender {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		LocalDateTime ldt=LocalDateTime.now();
		//int date = ldt.getDayOfMonth();
		int date = ldt.plusDays(10).getDayOfMonth();
		//System.out.println(date);
		int year = ldt.getYear();
		String mon = ldt.plusMonths(3).toString();
		String month = mon.charAt(0)+mon.substring(1).toLowerCase()+" ";
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
//		JavascriptExecutor jse=(JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,100)");
		calanderHandle(driver, month, date, year);
	}
	public static void calanderHandle(WebDriver driver,String month,int date,int year) {
		Actions action=new Actions(driver);
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month+"' and text()='"+year+"']/../..//div[text()='"+date+"']")).click();
				break;
			}
			catch (NoSuchElementException e) {
				action.moveByOffset(776,528);
				action.click();
				//driver.findElement(By.xpath("//div[contains(@class,'PaginationArrowIcon--next')]")).click();
			}
		}
	}
}

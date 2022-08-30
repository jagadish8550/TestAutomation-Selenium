package specific;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoIbiboCalender {
	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		LocalDateTime ldt=LocalDateTime.now().plusMonths(9);
		int date = ldt.getDayOfMonth();
		int year = ldt.getYear();
		String mon = ldt.getMonth().toString();
		//String mon=ldt.plusMonths(2).toString();
		String month = mon.charAt(0)+mon.substring(1).toLowerCase();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		calanderHandle(driver, month, date, year);
		//Thread.sleep(5000);
		driver.quit();
	}
	public static void calanderHandle(WebDriver driver,String month,int date,int year) {
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month+" "+year+"']/../..//p[text()='"+date+"']")).click();
				driver.findElement(By.xpath("//span[text()='Done']")).click();
				break;
			}
			catch (NoSuchElementException e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
	}
}

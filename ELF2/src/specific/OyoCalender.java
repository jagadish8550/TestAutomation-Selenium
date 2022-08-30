package specific;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OyoCalender {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		LocalDateTime ldt=LocalDateTime.now().plusMonths(9);
		//int date = ldt.getDayOfMonth();
		int date = ldt.getDayOfMonth();
		System.out.println(date);
		int year = ldt.getYear();
		String mon = ldt.plusMonths(3).getMonth().toString();
		String month = mon.charAt(0)+mon.substring(1).toLowerCase();
		driver.get("https://www.oyorooms.com/");
		driver.findElement(By.className("datePickerDesktop__checkInOutText")).click();
		calanderHandle(driver, month, date, year);
	}
	public static void calanderHandle(WebDriver driver,String month,int date,int year) {
		for(;;) {
			try {
				driver.findElement(By.xpath("//span[text()='"+month+"']//following-sibling::span[text()='"+year+"']/../..//span[text()='"+date+"']")).click();
				break;
			}
			catch (NoSuchElementException e) {
				driver.findElement(By.xpath("//div[contains(@class,'PaginationArrowIcon--next')]")).click();
			}
		}
	}
}

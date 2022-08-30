package via;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelsClaenderHandler {
	WebDriver driver;
	HotelsClaenderHandler(WebDriver driver){
		this.driver=driver;
	}
	
	public void checkInCalender(String month,int date) {
		driver.findElement(By.xpath("//label[text()='CHECK IN']/..//div[@class='calendar-icon']")).click();
		driver.findElement(By.xpath("//span[text()='"+month+"']/../../..//div[text()='"+date+"']")).click();
	}
	
	public void checkOutCalenderHandler(String month, int date) {
		driver.findElement(By.xpath("//label[text()='CHECK OUT']/..//div[@class='calendar-icon']")).click();
		for (int i=1;;) {
			try {
				driver.findElement(By.xpath("(//span[text()='"+month+"']/../../..//div[text()='"+date+"'])["+i+"]")).click();
				break;
			} catch (Exception e) {
				i++;
			}
		}
	}
}

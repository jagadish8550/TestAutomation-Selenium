package via;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage {
	WebDriver driver;
	HotelsClaenderHandler calHandler;
	HotelsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkInCal(String month, int date) {
		calHandler=new HotelsClaenderHandler(driver);
		calHandler.checkInCalender(month, date);
	}
	
	public void checkOutCal(String month, int date) {
		calHandler=new HotelsClaenderHandler(driver);
		calHandler.checkOutCalenderHandler(month, date);
	}
	
}

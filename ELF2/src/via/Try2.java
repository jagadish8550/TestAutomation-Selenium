package via;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Try2 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.get("https://www.makemytrip.com/flight/search?itinerary=BLR-LON-29/08/2022&tripType=O&paxType=A-1_C-0_I-0&intl=true&cabinClass=E&ccde=IN&lang=eng");
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		for(int i=0;i<20;i++) {
			jse.executeScript("window.scrollBy(0,500)");
		
//		int flightCount = 0;
//		List<WebElement> flightList = driver.findElements(By.xpath("//p[contains(text(),'Airlines')]/..//span[@class='filterName']/.."));
//		for (WebElement webElement : flightList) {
//			String brandFlightCount = webElement.getText().replaceAll("[^\\d.]", "");
//			System.out.println(brandFlightCount);
//			int count = Integer.valueOf(brandFlightCount);
//			flightCount+=count;
		}
//		
//		System.out.println(flightCount);
		
		WebElement gg = driver.findElement(By.xpath("(//div[@class='listingCardWrap']//span[@style='background-image: url(\"https://imgak.mmtcdn.com/flights/assets/media/dt/common/icons/AI.png?v=11\");'])[2]"));
		System.out.println(gg.isDisplayed());
	}
}

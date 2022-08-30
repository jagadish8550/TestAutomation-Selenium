package specific;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraProductPrice {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/s?k=earphones&i=electronics&ref=nb_sb_noss");
		String price = driver.findElement(By.xpath("//span[text()='realme Buds 2 Wired in Ear Earphones with Mic (Black)']/../../../..//span[@class='a-price-whole']")).getText();
		System.out.println(price);
	}
}

package demowebshoppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "Apparel & Shoes")
	private WebElement apparelAndShoesLink;
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;

	public WebElement getApparelAndShoesLink() {
		return apparelAndShoesLink;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}
}

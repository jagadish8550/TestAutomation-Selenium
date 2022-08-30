package specific;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import datadriven.RetriveFromProperrtyFile;

public class Rediff {
	@Test
	public void sendAndDeleteMail() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.get(RetriveFromProperrtyFile.getValue("url"));
//		driver.findElement(By.linkText("Sign in")).click();
//		Thread.sleep(5000);
		driver.findElement(By.id("login1")).sendKeys(RetriveFromProperrtyFile.getValue("username"));
		driver.findElement(By.id("password")).sendKeys(RetriveFromProperrtyFile.getValue("password"));
		driver.findElement(By.name("proceed")).submit();
		driver.findElement(By.xpath("//b[.='Write mail']")).click();
		driver.findElement(By.id("TO_IDcmp2")).sendKeys(RetriveFromProperrtyFile.getValue("username"),Keys.TAB);
		String subject = RetriveFromProperrtyFile.getValue("subject");
		driver.findElement(By.xpath("//label[text()='Subject:']//following-sibling::input")).sendKeys(subject,Keys.TAB,RetriveFromProperrtyFile.getValue("body"));
//		driver.switchTo().frame(0);
//		driver.findElement(By.xpath("//body/br")).sendKeys(RetriveFromProperrtyFile.getValue("body"));
		driver.findElement(By.xpath("//a[text()='Send']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+subject+"']")));
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//span[text()='"+subject+"']"))).perform();
		driver.findElement(By.xpath("//span[text()='"+subject+"']//following-sibling::span/a")).click();
	}
}
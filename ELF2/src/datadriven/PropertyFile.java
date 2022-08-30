package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFile {
	public static void main(String[] args) throws IOException {
		File f=new File("./testdata/TestData.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties p=new Properties();
		p.load(fis);
		String url=p.getProperty("url");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(p.getProperty("username"));
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(p.getProperty("password"));
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
		driver.quit();
	}
}

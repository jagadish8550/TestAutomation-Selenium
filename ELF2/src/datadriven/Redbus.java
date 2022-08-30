package datadriven;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Redbus {
	public static void main(String[] args) throws CsvValidationException, IOException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		File file=new File("./testdata/busdata.csv");
		FileReader fr=new FileReader(file);
		CSVReader read=new CSVReader(fr);
		String[] firstLine = read.readNext();
		String src = firstLine[0];
		String dest = firstLine[1];
		String month = firstLine[2];
		String year = firstLine[3];
		String date = firstLine[4];
		driver.get("https://www.redbus.in/");
		driver.findElement(By.id("src")).sendKeys(src);
		driver.findElement(By.id("dest")).sendKeys(dest);
		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//td[text()='"+month+" "+year+"']/../..//td[text()='"+date+"']")).click();
		driver.findElement(By.xpath("//li[text()='"+src+"']")).click();
		driver.findElement(By.xpath("//li[text()='"+dest+"']")).click();
		driver.findElement(By.id("search_btn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='found']")));
		String busCount = driver.findElement(By.xpath("//span[text()='found']/span[@class='f-bold busFound']")).getText();
		System.out.println("Bus Count : "+busCount);
		driver.quit();
		read.close();
	}
}

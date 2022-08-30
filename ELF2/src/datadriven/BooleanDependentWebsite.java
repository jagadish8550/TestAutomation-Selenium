package datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BooleanDependentWebsite {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/webpage.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		Sheet sheet = workbook.getSheet("Sheet1");
		boolean bool = sheet.getRow(0).getCell(0).getBooleanCellValue();
		if(bool) {
			driver.get(sheet.getRow(0).getCell(1).getStringCellValue());
			driver.findElement(By.id("username")).clear();
			String usn = sheet.getRow(1).getCell(1).getStringCellValue();
			driver.findElement(By.id("username")).sendKeys(usn);
			driver.findElement(By.id("password")).clear();
			String pass=sheet.getRow(2).getCell(1).getStringCellValue();
			driver.findElement(By.id("password")).sendKeys(pass);
		}else {
			driver.get(sheet.getRow(0).getCell(2).getStringCellValue());
			driver.findElement(By.xpath("//div[text()='LOGIN']")).click();
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,200)");
			String usn = sheet.getRow(1).getCell(2).getStringCellValue();
			driver.findElement(By.xpath("//div[text()='Username / Email']//following-sibling::input")).sendKeys(usn);
			String pass = sheet.getRow(2).getCell(2).getStringCellValue();
			driver.findElement(By.xpath("//div[text()='Password']//following-sibling::input")).sendKeys(pass);
		}
		driver.quit();
			
	}
}

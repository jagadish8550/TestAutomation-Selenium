package specific;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMTFlightsCount {
	Workbook workbook = null;

	public MMTFlightsCount() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./testData/mmtData.xlsx");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MMTFlightsCount mmt = new MMTFlightsCount();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		Sheet sheet = mmt.workbook.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		String url = row.getCell(0).getStringCellValue();
		String fromLocation = row.getCell(1).getStringCellValue();
		String toLocation = row.getCell(2).getStringCellValue();
		int date = (int) row.getCell(3).getNumericCellValue();
		String month = row.getCell(4).getStringCellValue();
		int year = (int) row.getCell(5).getNumericCellValue();

		driver.get(url);
		driver.findElement(By.className("langCardClose")).click();
//		driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();

		driver.findElement(By.id("fromCity")).click();
		WebElement fromLocationTextBox = driver.findElement(By.xpath("//input[@placeholder='From']"));
		fromLocationTextBox.sendKeys(fromLocation);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='SUGGESTIONS ']")));
//		driver.findElement(By.id("fromCity")).click();
		fromLocationTextBox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		driver.findElement(By.id("toCity")).click();
		WebElement toLocationTextBox = driver.findElement(By.xpath("//input[@placeholder='To']"));
		toLocationTextBox.sendKeys(toLocation);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='SUGGESTIONS ']")));
		toLocationTextBox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		calanderHandle(driver, month, date, year);

//		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Search")));
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='OKAY, GOT IT!']")));
			driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();
		} catch (TimeoutException e) {
		}
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='listingCard']//button[not(text()='VIEW ALL')]")));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int i = 0; i < 20; i++) {
			jse.executeScript("window.scrollBy(0,500)");
		}
		List<WebElement> flightList;
		int flightCount = 0;
		try {
			flightList = driver.findElements(By.xpath("//div[@class='listingCard']//button[not(text()='VIEW ALL')]"));
			if (flightList.size() == 0)
				throw new NoSuchElementException("size of list is 0");
			System.out.println("Number of flights located from " + fromLocation + " to " + toLocation + " are : "
					+ flightList.size());
		} catch (NoSuchElementException e) {
			flightList = driver.findElements(By.xpath("//div[@class='listingCard appendBottom5']"));
			for (WebElement webElement : flightList) {
				if (webElement.isDisplayed())
					flightCount++;
			}
			System.out.println(
					"Number of flights located from " + fromLocation + " to " + toLocation + " are : " + flightCount);
		}
	}

	public static void calanderHandle(WebDriver driver, String month, int date, int year) {
		for (;;) {
			try {
				driver.findElement(
						By.xpath("//div[text()='" + month + " " + year + "']/../..//p[text()='" + date + "']")).click();
				break;
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
	}
}

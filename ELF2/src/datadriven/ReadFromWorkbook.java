package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadFromWorkbook {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		
		String data = workbook.getSheet("Sheet1").getRow(12).getCell(4).getStringCellValue();
		System.out.println(data);
		
		double data1 = workbook.getSheet("Sheet1").getRow(13).getCell(4).getNumericCellValue();
		System.out.println(data1);
		
		LocalDateTime date = workbook.getSheet("Sheet1").getRow(14).getCell(4).getLocalDateTimeCellValue();
		System.out.println(date);
		
		boolean bool = workbook.getSheet("Sheet1").getRow(15).getCell(4).getBooleanCellValue();
		System.out.println(bool);
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(workbook.getSheet("Sheet1").getRow(16).getCell(4).getStringCellValue());
	}
}

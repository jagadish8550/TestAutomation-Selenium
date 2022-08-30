package myutils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDrivenUtil {
	public static String[][] excelUtil(String file,String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		int colums = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] arr=new String[rows][colums];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				arr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return arr;
	}
}

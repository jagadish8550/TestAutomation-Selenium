package datadriven;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import myutils.DataDrivenUtil;

public class ToDataProviderFromWorkbook {
	@Test
	public void details() throws EncryptedDocumentException, IOException {
		String path= "./testdata/todataprovider.xlsx";
		String sheetName="Sheet1";
		String[][] arr = DataDrivenUtil.excelUtil(path, sheetName);
		for (String[] strings : arr) {
			for (String s : strings) {
				System.out.println(s);
			}
		}
	}
}

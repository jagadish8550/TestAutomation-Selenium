package datadriven;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVFile {
	public static void main(String[] args) throws IOException, CsvException {
		File file=new File("./testdata/csvfile.csv");
		FileReader fr=new FileReader(file);
		CSVReader read=new CSVReader(fr);
//		String[] firstLine = read.readNext();
//		for (int i = 0; i < firstLine.length; i++) {
//			System.out.println(firstLine[i]);
//		}
//		System.out.println("=========================");
//		String[] secondLine = read.readNext();
//		for (int i = 0; i < secondLine.length; i++) {
//			System.out.println(secondLine[i]);
//		}
		List<String[]> allData = read.readAll();
		for (String[] strings : allData) {
			for (int i = 0; i < strings.length; i++) {
				System.out.println(strings[i]);
			}
		}
		
		read.close();
	}
}

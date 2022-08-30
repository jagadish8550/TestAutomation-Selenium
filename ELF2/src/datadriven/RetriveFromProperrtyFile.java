package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RetriveFromProperrtyFile {
	public static String getValue(String Key) throws IOException {
		File f=new File("./testdata/TestData.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(Key);
		return value;
	}
}

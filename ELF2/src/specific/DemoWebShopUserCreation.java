package specific;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoWebShopUserCreation {
	@DataProvider(name="DataForUserCreation")
	public String[][] userData() throws IOException{
		String arr[][]=new String[2][5];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=getValue("U"+i+j);
			}
		}
		return arr;
	}
	
	@Test(dataProvider = "DataForUserCreation" )
	public void  userCreation(String[] s) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(getValue("url"));//"http://demowebshop.tricentis.com/"
		driver.findElement(By.linkText("Register")).click();
		if(s[0].equals("male"))
			driver.findElement(By.id("gender-male")).click();
		else
			driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys(s[1]);
		driver.findElement(By.id("LastName")).sendKeys(s[2]);
		driver.findElement(By.id("Email")).sendKeys(s[3]);
		driver.findElement(By.id("Password")).sendKeys(s[4]);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(s[4]);
		driver.findElement(By.id("register-button")).submit();
		driver.quit();
	}
	
	public static String getValue(String Key) throws IOException {
		File f=new File("./testdata/demowebshopuserdata.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(Key);
		return value;
	}
}

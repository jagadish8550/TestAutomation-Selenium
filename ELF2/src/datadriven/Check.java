	package datadriven;
	
	import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	
	public class Check {
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://online.actitime.com/testall/login.do");
			driver.findElement(By.id("username")).sendKeys("jagadishraj1998@gmail.com");
			driver.findElement(By.name("pwd")).sendKeys("VVMnb%jv");
			driver.findElement(By.id("loginButton")).click();
			driver.findElement(By.xpath("//div[contains(@class,'settings')]//div[@class='menu_icon']")).click();
			driver.findElement(By.linkText("Workflow Settings")).click();
			driver.findElement(By.xpath("//div[contains(text(),'open tasks')]/..//div[text()='Add new status']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Status name']")).sendKeys("newStatus");
			driver.findElement(By.xpath("//div[text()='Apply']")).click();
			driver.findElement(By.id("container_tt")).click();
			driver.findElement(By.id("container_reports")).click();
			Thread.sleep(3000);
			driver.quit();
		}
	}

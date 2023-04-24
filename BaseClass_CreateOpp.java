package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseClass_CreateOpp {
	public ChromeDriver driver;
	
	public ChromeOptions apt;
	@Parameters({"url","username","password"})
	@BeforeMethod
		public void preCondition(String url,String uName,String password)
		{
		 apt=new ChromeOptions();
		apt.addArguments("--disable-notifications");
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@name='pw']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		System.out.println("precondition executed");
		}
	@AfterMethod
		public void postCondition()
		{
		driver.close();
		System.out.println("postcondition executed");
		}


}

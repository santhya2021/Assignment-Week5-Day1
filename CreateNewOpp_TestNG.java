package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateNewOpp_TestNG extends BaseClass_CreateOpp{
	@DataProvider(name="fetchData")
	public String[][] sendData()
	{
		String [][] data=new String[2][2];
		data[0][0]="Salesforce Automation By kani";
		data[0][1]="4/24/2023";
				
		data[1][0]="Salesforce Automation By Priya";
		data[1][1]="4/24/2023";

		return data;
	}
	@Test(dataProvider="fetchData")
	public void createOpp(String Name,String date) throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(2000);
		WebElement click = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click()", click);
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		Thread.sleep(3000);
		WebElement name = driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow']/input)[2]"));
		name.sendKeys(Name);
		String oppName = name.getText();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys(date);
		
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		String afterName = driver.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation By Santhya']")).getText();
		System.out.println(afterName);
		if(afterName.contains("Salesforce Automation By "))
		{
			System.out.println("Name verified sucessfully");
		}
		else
		{
			System.out.println("Name verification not matched");
		}
		

	}

}

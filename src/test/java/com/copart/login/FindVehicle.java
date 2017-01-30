package com.copart.login;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindVehicle  
{
	protected static WebDriver driver;

	@BeforeTest
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


	
  @Test
  public void findingVechicle() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);  
		//login();
		driver.get("https://www.copart.com");  
		Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@class='btn btn-lblue textbtn dropdown-toggle']")).click();
		driver.findElement(By.xpath("//input[@id='']")).click();
		driver.findElement(By.xpath("//input[@id='']")).sendKeys("1N4AA6AP9GC393625");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
}

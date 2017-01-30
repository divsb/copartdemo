package com.copart.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginHelper {

	protected static WebDriver driver;

	@BeforeTest
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


	public void  login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.copart.com");  
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[@class='btn btn-lblue textbtn dropdown-toggle']")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.linkText("Member")).click();
		//driver.findElement(By.id("username")).sendKeys("talktodeviusa@gmail.com");
		//driver.findElement(By.id("password")).sendKeys("da1004");
		//driver.findElement(By.id("password")).submit();
//				Thread.sleep(3000);
//				driver.findElement(By.linkText("Sign Out")).click();

	}
	//@AfterTest(enabled=false)
	//public void closeBrowser(){
		//driver.findElement(By.linkText("Sign Out")).click();
		//driver.quit();
	}



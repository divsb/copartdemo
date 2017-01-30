package com.copart.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Vehiclefinder extends LoginHelper {

	@Test
	public void vehicleFindByZipcode() throws InterruptedException
	{

		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);  
		login();
		driver.findElement(By.xpath("//input[@id='']")).click();
		//driver.findElement(By.xpath("//input[@id='']")).sendKeys("1N4AA6AP9GC393625");
		driver.findElement(By.xpath("//button[@data-uname='homepageHeadersearchsubmit']")).submit();
		driver.findElement(By.cssSelector("i.fa.fa-search")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@data-uname='homePageFindAVehicle']")).click();
		//Thread.sleep(3000);

		WebElement vehicleNum = driver.findElement(By.xpath("//a[@data-uname='vehicleFinderTab']"));
		String vehiclefindNumber = vehicleNum.getText();
		vehicleNum.click();
		//driver.findElement(By.linkText(Vehicle Finder)).click();
		//driver.findElement(By.xpath("//a[@data-unam='vehicleFinderTab']")).click();
		driver.findElement(By.id("radios-2")).click();
		driver.findElement(By.name("zipcode")).sendKeys("07302");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.btn.btn-lblue.btn-block")).click();
		driver.findElement(By.name("FETI")).click();

		//driver.findElement(By.xpath("//a[@data-uname='ModelFilter']")).click();

		//driver.findElement(By.linkText("Model")).click();   //linktext is also working-after "i tag" open and close-its written as Model-that is the linktext 
		Thread.sleep(5000);	
		//driver.findElement(By.name("MODL")).click();

//		List<WebElement> MODELS = driver.findElements(By.name("MODL"));
//		for (int i = 0; i < MODELS.size(); i++) {
//			if (MODELS.get(i).getAttribute("value").equalsIgnoreCase("Tlx")) {
//				MODELS.get(i).click();
//			}
//		}
		driver.findElement(By.cssSelector("input.form-control.ng-pristine.ng-valid.ng-empty.ng-touched")).sendKeys("Tlx");
		driver.findElement(By.cssSelector("input#lot_model_descTLX")).click(); //model is not working- ask shiva

		driver.findElement(By.xpath("//a[@data-uname='YearFilter']")).click();  // By xpath is also working

		//driver.findElement(By.linkText("Year")).click();- By linktext is also working-after "i tag" open and close-its written as "Year"-that is the linktext 
		//driver.findElement(By.cssSelector("a.collapsed")).click();  --  css is not working- ask shiva
		Thread.sleep(5000);
		driver.findElement(By.id("lot_year2016")).click();

		//driver.findElement(By.xpath("//a[@data-uname='vehiclefinderSearchbutton']")).click();
		//driver.findElement(By.xpath("//button[@type='button']")).click();
		//driver.findElement(By.cssSelector("btn btn-lblue btn-block")).click();
		//driver.findElement(By.xpath("//button[@type='button'])")).click();


	}





}
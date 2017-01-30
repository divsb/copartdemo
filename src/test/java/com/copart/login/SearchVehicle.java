package com.copart.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class SearchVehicle extends LoginHelper {

	@Test(priority=1,enabled=true)
	public void searchingVechicle() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);  
		login();
		driver.findElement(By.xpath("//input[@id='']")).click();
		//driver.findElement(By.xpath("//input[@id='']")).sendKeys("1N4AA6AP9GC393625");
		driver.findElement(By.xpath("//button[@data-uname='homepageHeadersearchsubmit']")).submit();
		driver.findElement(By.cssSelector("i.fa.fa-search")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement lotNum = driver.findElement(By.xpath("//a[@data-uname='lotsearchLotnumber']"));
		String lotNumber = lotNum.getText();
		lotNum.click();

		WebElement lotNumInDetailPage = driver.findElement(By.cssSelector("h3.lot-number.nmt.bg-lblue.white"));
		String lotNumberInDetailPage = lotNumInDetailPage.getText();



		if(lotNumInDetailPage.getAttribute("href")== null){
			System.out.println("Lot number is not editable!!");

			if (lotNumberInDetailPage.contains(lotNumber)) {
				System.out.println("Lot number matched!!");
			}

			WebElement lotDescInDetailPage = driver.findElement(By.cssSelector("span.title"));
			String lotDesc = lotDescInDetailPage.getText();
			System.out.println(lotDesc);


			if(lotDescInDetailPage.getAttribute("href")== null){
				System.out.println("Description is not editable!!");

			}
		}


		//	    	
		//	    	
		//	    }
		//	   
		 // WebElement lotLocation = driver.findElement(By.xpath("//span[@data-uname='lotdetailSaleinformationgriditemvalue']"));
		//String lotLocation =lotLocation.getText(); 
		//
		//
	}
	
	@Test(priority=2,enabled=true)
	public void rowVerification() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);  
		login();
		driver.findElement(By.xpath("//input[@id='']")).click();
		//driver.findElement(By.xpath("//input[@id='']")).sendKeys("1N4AA6AP9GC393625");
		//driver.findElement(By.xpath("//button[@data-uname='homepageHeadersearchsubmit']")).submit();
		//driver.findElement(By.cssSelector("i.fa.fa-search")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String lotNumber = "43259426"; 
		String rowNumber = "E/5010/N050";
	
		driver.findElement(By.linkText(lotNumber)).click();
		Thread.sleep(5000);
		WebElement lotRow = driver.findElement(By.xpath("//span[@data-uname='lotdetailSaleinformationgriditemvalue']"));
		Thread.sleep(5000);
		System.out.println("Row Number in website: "+lotRow.getText());
		if (lotRow.getText().equals(rowNumber)) {
			System.out.println("Lot row number matched with expected row number");
		}
		if (lotRow.getAttribute("href")==null) {
			System.out.println("Lot row is not editable");
		}
		
		
	}
}



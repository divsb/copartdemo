package com.copart.login;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sortfunchightolow extends LoginHelper {

	@Test
	public void f() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		login();  
		Thread.sleep(2000);
		// clicks on search text field
		//driver.findElement(By.xpath("//input[@id='']")).click();
		// Clicks on search magnifier
		driver.findElement(By.cssSelector("i.fa.fa-search")).click();
		driver.findElement(By.id("lot_Number")).click();driver.findElement(By.id("lot_Number")).click();
		Thread.sleep(6000);
		// Store all lot numbers in a list
		List<WebElement> lotNumbers = driver.findElements(By.xpath("//a[@data-uname='lotsearchLotnumber']"));  
		List<String> lotNumList = new ArrayList<String>();
		List<String> lotNumList2 = new ArrayList<String>();

		for (int i = 0; i < lotNumbers.size(); i++) {
			lotNumbers = driver.findElements(By.xpath("//a[@data-uname='lotsearchLotnumber']"));
			//lotNumbers = driver.findElements(By.xpath("//a[@data-uname='lotsearchLotnumber']"));
			System.out.println(lotNumbers.get(i));
			System.out.println(lotNumbers.get(i).getText());
			lotNumList.add(lotNumbers.get(i).getText());
			//lotNumbers.get(i).click();
			//driver.navigate().back();
		}

		lotNumList2.addAll(lotNumList);
		/* Sorted List in reverse order ie Descending order*/ 
		Collections.sort(lotNumList,  Collections.reverseOrder());

		System.out.println("ArrayList in descending order:");
		for(String str: lotNumList){
			System.out.println(str);
		}
		if (lotNumList2.equals(lotNumList)) {
			System.out.println("Lot numbers in descending order");
		} else{
			System.err.println("Lot numbers are not in descending order");
		}

	}
}

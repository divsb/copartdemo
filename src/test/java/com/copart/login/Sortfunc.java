package com.copart.login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Sortfunc extends LoginHelper {
	@Test
	public void f() throws InterruptedException {
		login();
		// clicks on search text field
		driver.findElement(By.xpath("//input[@id='']")).click();
		// Clicks on search magnifier
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Store all lot numbers in a list
		List<WebElement> lotNumbers = driver.findElements(By.xpath("//a[@data-uname='lotsearchLotnumber']"));

		List<String> lotNumList = new ArrayList<String>();
		List<String> lotNumList2 = new ArrayList<String>();

		for (int i = 0; i < lotNumbers.size(); i++) {
			//lotNumbers = driver.findElements(By.xpath("//a[@data-uname='lotsearchLotnumber']"));
			System.out.println(lotNumbers.get(i));
			System.out.println(lotNumbers.get(i).getText());
			lotNumList.add(lotNumbers.get(i).getText());
//			lotNumbers.get(i).click();
//			driver.navigate().back();
		}

		lotNumList2.addAll(lotNumList);
		Collections.sort(lotNumList);
		if (lotNumList.equals(lotNumList2)) {
			System.out.println("Lot numbers are sorted by default");
		} else {
			System.out.println("Lot numbers are not sorted by default");
		}
		
		Random random = new Random();
		int pickedNumber = random.nextInt(lotNumbers.size()-1);
		lotNumbers.get(pickedNumber).click();
		

	}
}

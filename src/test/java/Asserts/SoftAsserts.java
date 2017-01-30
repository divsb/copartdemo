package Asserts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SoftAsserts {
	@Test(enabled=false)
	public void f() {

		String s = "Devi";
		String s1 = "Devi";
		Assert.assertEquals(s, s1);
		System.out.println("Bother Strings are same");

		boolean a = false;
		boolean b = false;
		Assert.assertEquals(a,b);
		System.out.println("A and B are not same");

		int i =10;
		int j =10;
		Assert.assertEquals(i, j, "Both Intergers are not same");

		Assert.assertTrue(i==j,"Both I and J are not same");
		Assert.assertFalse(i!=j, "Both I and J are same");
		System.out.println("It will not execute");

		Assert.assertNotEquals(i, j);
		System.out.println("fkjsdalkjflksdjflsdf sdalkjfsld fjasdalkjf ");

		if (i!=j) {
			Assert.fail("failed");
		} else {
			System.out.println("");
		}
	}

@Test
public void SoftAsserts() 
{
	SoftAssert softAssert = new SoftAssert();
	String str = "Selenium";
	String str2 = "Appium";
   softAssert.assertEquals(str,str2);
   
	
	int i = 12;
	int j =13;
	softAssert.assertTrue(i==j, "Expected is "+j+" But actual is "+i);
	System.out.println("Program still continues.........................");

	softAssert.assertAll();
}


}

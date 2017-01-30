package ReadvaluesfromExcel;

import org.testng.Reporter;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import com.copart.login.LoginHelper;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadLotvalues extends LoginHelper {

	@Test
	public void readdata() throws BiffException,IOException,InterruptedException{

		File file = new File(System.getProperty("user.dir")+"\\LoginTestData.xls");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rows = sheet.getRows();

		driver.get("https://www.copart.com");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn btn-lblue textbtn dropdown-toggle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Member")).click();
		// In getCell(), first parameter should be column index and second parameter should be row index
		driver.findElement(By.name("username")).sendKeys(sheet.getCell(0,1).getContents());
		driver.findElement(By.name("password")).sendKeys(sheet.getCell(1,1).getContents());
		driver.findElement(By.name("password")).submit();
		Thread.sleep(3000);
		try {
			// Accepting TC's
			driver.findElement(By.cssSelector("button.btn.btn-lblue")).click();
		} catch (Exception e) {}
		System.out.println("Login Completed");
		Reporter.log("Login Completed");

		
		for (int i = 1; i < rows; i++) {
			// Clearing values from Searcch field
			driver.findElement(By.xpath("//input[@id='']")).clear(); 
			// Clicks on LOt search field
			driver.findElement(By.xpath("//input[@id='']")).click();
			// Fetching lot number from excel and entering in Lot search field
			System.err.println("Searching with: "+sheet.getCell(2,i).getContents());
			driver.findElement(By.xpath("//input[@id='']")).sendKeys(sheet.getCell(2,i).getContents());
			// Clicking on Search field magnifier
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);

		}
	}
}
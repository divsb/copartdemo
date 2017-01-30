package ReadvaluesfromExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.copart.login.LoginHelper;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadvalsfromExcel extends LoginHelper{
	
	
	
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
		System.out.println("Login Completed");
		
		for (int i = 0; i < rows; i++) {
			driver.findElement(By.linkText(sheet.getCell(2, i).getContents())).click();
			//
			// --- Your code ---
			//
			driver.navigate().back();
		}





	}
}

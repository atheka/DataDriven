package com.testcases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteDataToExcel {
	public static WebDriver driver;

	@Test

	public void GetURL() throws EncryptedDocumentException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		FileInputStream fs = new FileInputStream("./OutputTestData/Output.xlsx");
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
		String Url = driver.getCurrentUrl();
		String Title = driver.getTitle();
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet("PageDetails");
		Row rw = sh.createRow(0);
		Row rw1 = sh.createRow(1);
		Cell cell = rw.createCell(0);
		Cell cell1 = rw1.createCell(0);
		cell.setCellValue(Url);
		cell1.setCellValue(Title); 
		FileOutputStream fs1 = new FileOutputStream("./OutputTestData/Output.xlsx");
		wb.write(fs1);
		driver.quit();

	}
}

package com.testcases;

import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Properties;

public class PropertyFileExample
{
	public static WebDriver driver;
     @Test
   public void ReadData() throws IOException
    		{
    			//Step 1 we give the location for the property file
    			FileReader file = new FileReader("./InputTestData/TestData.properties");
    			
    			//Step 2 create an object for Properties class
    			
    			Properties prop = new Properties();
    			
    			//Step 3 load the file into property
    			
    			prop.load(file);
    			
    			System.out.println(prop.getProperty("userid"));
    			
    			String Name = prop.getProperty("Name");
    			
    			System.out.println(Name);
    		}
     @Test
 	
 	public void WriteData() throws IOException, InterruptedException
 	{
 		driver = new ChromeDriver();
 		driver.manage().window().maximize();
 		driver.get("https://automationexercise.com/");
 		
 		String url = driver.getCurrentUrl();
 		String title = driver.getTitle();
 		
 		//Step 1 we give the location for the property file
 		String file = "./OutputTestData/OutputData.properties";
 				
 				//Step 2 create an object for Properties class
 				
 		Properties prop = new Properties();
 	
 		
 		try {
 			// Create output stream  to write the file
 			OutputStream os = new FileOutputStream(file);
 			//Write the data  to file
 			prop.setProperty("URL", url);
 			prop.setProperty("Title", title);
 			
 			prop.store(os, "DataSaved page   Title and URL");
 			
 			// Close the output  stream
 			os.close();
 			
 		}
 		
 		catch(Exception e) {
 			System.out.println(e);
 		}
 		
 		FileReader file1= new FileReader("./InputTestData/MenuData.properties");
		
		//Step 2 create an object for Properties class
		
		Properties prop1 = new Properties();
		
		//Step 3 load the file into property
		
		prop1.load(file1);
		Thread.sleep(20000);
		String  WomenLocator=prop1.getProperty("WomenLocator");
		WebElement WomenMenu=driver.findElement(By.xpath(WomenLocator));
	   Actions a = new Actions(driver);
		a.moveToElement(WomenMenu).click().perform();
		String  MenLocator=prop1.getProperty("MenLocator");
		WebElement menMenu=driver.findElement(By.xpath(MenLocator));
		Actions b = new Actions(driver);
		b.moveToElement(menMenu).click().perform();
		driver.quit();
 	}
	}


package com.quality;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Junit {
	WebDriver driver = null;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\HECTOR\\Downloads\\chromedriver.exe");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/HECTOR/workspace/"+
		"ZonePractice/RepositoryTest.properties");
		prop.load(ip);
		String Browsername = prop.getProperty("browser");
		
		if(Browsername.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\HECTOR\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("el browser es: "+prop.getProperty("browser"));
		}else if(Browsername.equals("FF")){
			driver = new FirefoxDriver();
		}else if(Browsername.equals("Safari")){
			driver = new SafariDriver();			
		}else if (Browsername.equals("IE")){
			driver = new InternetExplorerDriver();
		}else{
			System.out.println("invalid browser");
		}
	
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id(prop.getProperty("headertopidLocator"))).isDisplayed();
		System.out.println("logo is displayed");
		
		driver.findElement(By.id(prop.getProperty("nameidLocator"))).sendKeys(prop.getProperty("name"));
		driver.findElement(By.id(prop.getProperty("lastnameLocator"))).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.xpath(prop.getProperty("categoryxpathLocator"))).click();
		driver.findElement(By.cssSelector(prop.getProperty("gendercssLocator"))).click();
		driver.findElement(By.id(prop.getProperty("addidLocator"))).click();
		driver.findElement(By.id(prop.getProperty("saveidLocator"))).click();
		driver.findElement(By.id(prop.getProperty("clearidLocator"))).click();
	}

}

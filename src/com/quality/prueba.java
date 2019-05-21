package com.quality;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class prueba {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\HECTOR\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("objRepository.properties");
		prop.load(ip);		
		System.out.println(prop.getProperty("URL"));
		
		Thread.sleep(2000);
		driver.get("URL");
		System.out.println("la URL es: "+driver.getCurrentUrl());

	}

}

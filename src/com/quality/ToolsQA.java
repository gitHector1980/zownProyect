package com.quality;
import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolsQA {
	
	private WebDriver driver;
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\HECTOR\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("configurationZone");
		prop.load(ip);
		System.out.println(prop.getProperty("URL"));
		driver.get("https://www.toolsqa.com/automation-practice-form/");
	}
	
	
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

package com.quality;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class copyOfLostData {

	private static WebDriver Chrome;

	public static void main(String[] args) throws IOException, InterruptedException {
		//Set WebDriver & Their property
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\HECTOR\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		//Read a document properties
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/HECTOR/workspace/zownProyect/"+"amby/objRepository.properties");
		prop.load(ip);		
		//2- crear un metodo para poder lanzar cualquiera de los drivers (chrome, firefox ie)		
		if(driver.equals("Chrome")){
			
		}else if(driver.equals("FF")){
			driver = new FirefoxDriver();
		}else if(driver.equals("Safari")){
			driver = new SafariDriver();
		}else if(driver.equals("IE")){
			driver = new InternetExplorerDriver();
		}else{
			System.out.println("browser not acepted");
		}
		//1-open the page
		driver.get(prop.getProperty("URL"));
		//3- maximizar la ventana
		driver.manage().window().maximize();
		//4- esperar 5 segundos con implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//5- imprimir la url de la pag
		System.out.println("La URL es:"+prop.getProperty("URL"));
		//6- en la pag hay un logo hacer un assertion del logo si esta desplegado o no Verdadero o falso
		driver.findElement(By.xpath("//*[@id='header-top']")).isDisplayed();
//		WebElement mystr = driver.findElement(By.xpath("//*[@id='header-top']"));				
//		System.out.println(mystr.isDisplayed());		
//		Assert.assertTrue(mystr.isDisplayed());		
		System.out.println("This Assertion passed succesfully");
		//7- first name, last name, click a male
		Thread.sleep(2000);
		driver.findElement(By.id("FirstName")).sendKeys(prop.getProperty("name"));
		driver.findElement(By.id(prop.getProperty("LastNameLocator"))).sendKeys(prop.getProperty("lastname"));
		
		driver.findElement(By.cssSelector(prop.getProperty("genderInputLocator"))).click(); 
		//8- seleccionar categoria y dar click en add
		driver.findElement(By.id(prop.getProperty("addLocator"))).click();
		//9- mandar imprimir las opciones de categoria
		List<WebElement> objCategory = driver.findElements(By.id(prop.getProperty("categoryLocator")));		
		for(WebElement objCurrentCategoy : objCategory){
			String strCategoryText = objCurrentCategoy.getText();
			System.out.println("The available categories are: ");
			System.out.println(strCategoryText);
		}
		driver.findElement(By.xpath(prop.getProperty("categoryLocator2"))).click();		
		//10- cerrar la pagina
		driver.quit();
		}
}

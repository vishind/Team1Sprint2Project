package QuotationValidation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RequestProperty {

	public static void main(String[] args) throws IOException {
		 WebDriver driver;
    	 File src= new File("./TestResources/RetrieveQuo.property");
    	 FileInputStream fis = new FileInputStream(src);
    	 
    	 Properties prop = new Properties();
    	 prop.load(fis);
    	 
    	 System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
    	 driver = new ChromeDriver();
    	 driver.get(prop.getProperty("url"));
    	 driver.manage().window().maximize();
 		
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 	       driver.findElement(By.id(prop.getProperty("RetriveQuotation"))).click();
 	       
 	      driver.findElement(By.name(prop.getProperty("input"))).sendKeys("12696");
	      
 	    driver.findElement(By.id(prop.getProperty("retrieve"))).click();			
    	 
    	 driver.findElement(By.xpath(prop.getProperty("user_id"))).isDisplayed();
        System.out.println("Insurance Name is:" + driver.findElement(By.xpath(prop.getProperty("user_id"))).getText());
 		 
 		if(driver.findElement(By.xpath(prop.getProperty("37895"))).isDisplayed());
 		System.out.println("Value is:" + driver.findElement(By.xpath(prop.getProperty("37895"))).getText());
 		
 		if(driver.findElement(By.xpath(prop.getProperty("Registration"))).isDisplayed());
 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath(prop.getProperty("Registration"))).getText());
 		
 		if(driver.findElement(By.xpath(prop.getProperty("dddd"))).isDisplayed());
 		System.out.println("Value is:" + driver.findElement(By.xpath(prop.getProperty("dddd"))).getText());
    	 
    	if(driver.findElement(By.xpath(prop.getProperty("Annual mileage"))).isDisplayed());
  		System.out.println("Insurance Name is:" + driver.findElement(By.xpath(prop.getProperty("Annual mileage"))).getText());
  		 
  		if(driver.findElement(By.xpath(prop.getProperty("ffff"))).isDisplayed());
  		System.out.println("Value is:" + driver.findElement(By.xpath(prop.getProperty("ffff"))).getText());
 		
 		if(driver.findElement(By.xpath(prop.getProperty("Estimated value"))).isDisplayed());
 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath(prop.getProperty("Estimated value"))).getText());
 		
 		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("eeee"))).isDisplayed());
		System.out.println("Value is:" + driver.findElement(By.xpath(prop.getProperty("eeee"))).getText());
 	       
 		if(driver.findElement(By.xpath(prop.getProperty("Start of policy"))).isDisplayed());
 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath(prop.getProperty("Start of policy"))).getText());
 		 
 		if(driver.findElement(By.xpath(prop.getProperty("2016.10.17"))).isDisplayed());
 		System.out.println("Value is:" + driver.findElement(By.xpath(prop.getProperty("2016.10.17"))).getText());
 			   	
          driver.close();
          driver.quit();
	}

}

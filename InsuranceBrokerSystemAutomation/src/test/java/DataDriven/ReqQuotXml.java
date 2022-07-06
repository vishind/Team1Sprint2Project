package DataDriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ReqQuotXml {



	static String driverPath = "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
	@Test()
	@Parameters({"bdc", "incidents","registration","annualMileage","estimatedValue","parkingLoc","year","month","date"})
	public void fill(@Optional("No cover")String bdc, @Optional("Car hit")String incidents, @Optional("OD02AT0001")String registration, @Optional("35 kmpl")String annualMileage, @Optional("150000")String estimatedValue, @Optional("Public Place")String parkingLoc,@Optional("2016")String year, @Optional("February")String month, @Optional("15")String date) {
		
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.guru99.com/insurance/v1/header.php");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        
        driver.findElement(By.id("newquote")).click();
        driver.findElement(By.id("quotation_breakdowncover")).sendKeys(bdc);
        
        WebElement radio1 = driver.findElement(By.id("quotation_windscreenrepair_t"));
  	  	WebElement radio2 = driver.findElement(By.id("quotation_windscreenrepair_f"));
  	   	radio2.click();
        
        driver.findElement(By.id("quotation_incidents")).sendKeys(incidents);
        driver.findElement(By.id("quotation_vehicle_attributes_registration")).sendKeys(registration);
        driver.findElement(By.id("quotation_vehicle_attributes_mileage")).sendKeys(annualMileage);
        driver.findElement(By.id("quotation_vehicle_attributes_value")).sendKeys(estimatedValue);
        driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation")).sendKeys(parkingLoc);
        driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i")).sendKeys(year);
        driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i")).sendKeys(month);
        driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i")).sendKeys(date);
        
        driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[8]/input[1]")).click();
        
        System.out.println("Page title is : " + driver.getTitle());
        WebElement l = driver.findElement(By.cssSelector("#calculatedpremium"));
        System.out.println(l.toString());
        
        driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[8]/input[3]")).click();
        
        String strUrl = driver.getCurrentUrl();
        System.out.println("Current Url is:"+ strUrl);
        
        if(driver.findElement(By.xpath("//body")).isDisplayed()) {
        	
        	System.out.println(driver.findElement(By.xpath("//body")).getText());
	 	}
	}
}
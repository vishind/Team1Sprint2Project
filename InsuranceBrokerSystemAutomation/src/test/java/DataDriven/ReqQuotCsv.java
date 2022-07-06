package DataDriven;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.bytecode.opencsv.CSVReader;

public class ReqQuotCsv {

	static String driverPath = "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
	public static void main(String[] args) throws InterruptedException, IOException  {
		 	
		System.setProperty("webdriver.chrome.driver",driverPath);           
		WebDriver driver = new ChromeDriver();
	    driver.get("https://demo.guru99.com/insurance/v1/header.php");
	    driver.manage().window().maximize();
	    
		CSVReader reader = new CSVReader(new FileReader("./TestResources/ReqQuotation.csv"));
		
		// this will load content into list
	    java.util.List<String[]> li=reader.readAll();
	    System.out.println("Total rows that we have is "+li.size());
	             
	    // create Iterator reference
	    Iterator<String[]>i1= li.iterator();
	    
	    // Iterate all values
	    while(i1.hasNext()) {
	       String[] str=i1.next();
			
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(By.linkText("Request Quotation")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    //get the height of the webpage and scroll to the end
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    
	    Select drpBdc = new Select(driver.findElement(By.id("quotation_breakdowncover")));
	    drpBdc.selectByValue(str[0]);
	    
	    WebElement radio1 = driver.findElement(By.id("quotation_windscreenrepair_t"));
  	  	WebElement radio2 = driver.findElement(By.id("quotation_windscreenrepair_f"));
  	   	radio2.click();
    
	    driver.findElement(By.id("quotation_incidents")).sendKeys(str[1]);
	    driver.findElement(By.id("quotation_vehicle_attributes_registration")).sendKeys(str[2]);
	    driver.findElement(By.id("quotation_vehicle_attributes_mileage")).sendKeys(str[3]);
	    driver.findElement(By.id("quotation_vehicle_attributes_value")).sendKeys(str[4]);
	    //driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation")).sendKeys(str[7]);
	    Select drpPl = new Select(driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation")));
	    drpPl.selectByVisibleText(str[5]);
	    
	    Select drpYears = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i")));
	    drpYears.selectByValue(str[6]);
	    
	    Select drpMonths= new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i")));
	    drpMonths.selectByVisibleText(str[7]);
	    
	    Select drpDays= new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i")));
	    drpDays.selectByValue(str[8]);
	    
	    //driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i")).sendKeys(str[8]);
	    //driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i")).sendKeys(str[9]);
	    //driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i")).sendKeys(str[10]);
	    
	    driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[8]/input[1]")).click();
	    
	    System.out.println("Page title is : " + driver.getTitle());
	    WebElement l =driver.findElement(By.id("calculatedpremium"));
	    System.out.println(l.getText());
	    
	    driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[8]/input[3]")).click();
        
        WebElement m = driver.findElement(By.xpath("/html[1]/body[1]"));
        System.out.println(m.getText());
    	}
	}
}
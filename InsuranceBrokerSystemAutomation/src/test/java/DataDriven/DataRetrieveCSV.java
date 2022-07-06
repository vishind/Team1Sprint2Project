package DataDriven;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.bytecode.opencsv.CSVReader;

public class DataRetrieveCSV {

	static String driverPath = "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
    static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException  {
		 System.setProperty("webdriver.chrome.driver",driverPath);           
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://demo.guru99.com/insurance/v1/header.php");
	       

     
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newquote")));
		
		driver.findElement(By.id("newquote")).click();
		driver.findElement(By.name("submit")).click();
		
		
		
		driver.navigate().back();
		
		driver.findElement(By.id("retrieve")).click();
		CSVReader reader = new CSVReader(new FileReader("./TestResources/Retrieve.csv"));
		
		java.util.List<String[]> li=reader.readAll();
	   
	    Iterator<String[]>i1= li.iterator();
	    while(i1.hasNext()){
	        String[] str=i1.next();
		driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[3]/form[1]/input[1]")).sendKeys(str[0]);
		driver.findElement(By.id("getquote")).click();
	     driver.navigate().back();
		
       
       
	
}
	}
}


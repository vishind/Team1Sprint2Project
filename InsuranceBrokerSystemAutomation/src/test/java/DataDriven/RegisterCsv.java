package DataDriven;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import au.com.bytecode.opencsv.CSVReader;

public class RegisterCsv {
	static String driverPath = "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
    static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException  {
		 System.setProperty("webdriver.chrome.driver",driverPath);           
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://demo.guru99.com/insurance/v1/index.php");
	       
	CSVReader reader = new CSVReader(new FileReader("./TestResources/RegisterAndLogin.csv"));
	  
	
   // this will load content into list
    java.util.List<String[]> li=reader.readAll();
    System.out.println("Total rows that we have is "+li.size());
             
   // create Iterator reference
    Iterator<String[]>i1= li.iterator();
    
   // Iterate all values
   while(i1.hasNext()){
       String[] str=i1.next();
       
     
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.findElement(By.linkText("Register")).click();
      
       
       Select title= new Select(driver.findElement(By.id("user_title")));
       title.selectByVisibleText(str[0]);
       
       driver.findElement(By.id("user_firstname")).sendKeys(str[1]);
       driver.findElement(By.id("user_surname")).sendKeys(str[2]);
       driver.findElement(By.id("user_phone")).sendKeys(str[3]);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       Select drpYears = new Select(driver.findElement(By.xpath("//*[@id=\"user_dateofbirth_1i\"]")));
       drpYears.selectByValue(str[4]);
       
       
       Select drpMonths= new Select(driver.findElement(By.id("user_dateofbirth_2i")));
       drpMonths.selectByVisibleText(str[5]);
       
     
       Select drpDays= new Select(driver.findElement(By.id("user_dateofbirth_3i")));
       drpDays.selectByValue(str[6]);
       
       WebElement radioFP = driver.findElement(By.id("licencetype_t"));  
       radioFP.click();
       
       
       Select occupation = new Select(driver.findElement(By.id("user_occupation_id")));
       occupation.selectByVisibleText(str[7]);
       
       
       
       driver.findElement(By.id("user_address_attributes_street")).sendKeys(str[8]);
       
       driver.findElement(By.id("user_address_attributes_city")).sendKeys(str[9]);
       
       driver.findElement(By.id("user_address_attributes_county")).sendKeys(str[10]);
       
       driver.findElement(By.id("user_address_attributes_postcode")).sendKeys(str[11]);
       
       driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys(str[12]);
       
       driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys(str[13]);
       
       driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys(str[14]);
       
       driver.findElement(By.name("submit")).click();
       
       
       Thread.sleep(3000);
       driver.findElement(By.id("email")).sendKeys(str[15]);
       
       driver.findElement(By.id("password")).sendKeys(str[16]);
       
       driver.findElement(By.name("submit")).click();
       
       
 
	
}
	}
}
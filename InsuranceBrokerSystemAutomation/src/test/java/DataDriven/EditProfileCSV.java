package DataDriven;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.bytecode.opencsv.CSVReader;

public class EditProfileCSV {

	static String driverPath = "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("email")).sendKeys("vis@gmail.com");
		driver.findElement(By.id("password")).sendKeys("vishal5678");
		driver.findElement(By.name("submit")).click();
		
		//Adding Explicit wait
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("editprofile")));
		
		driver.findElement(By.id("editprofile")).click();
		
		CSVReader reader = new CSVReader(new FileReader("./TestResources/EditProfile.csv"));

        // this will load content into list
        List<String[]> li=reader.readAll();
        System.out.println("Total rows that we have is "+li.size());

        // create Iterator reference
        Iterator<String[]>i1= li.iterator();

        // Iterate all values
        while(i1.hasNext()){
            
        	String[] str=i1.next();
            
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            Select title= new Select(driver.findElement(By.id("user_title")));
	        title.selectByValue(str[0]);
	        driver.findElement(By.id("user_surname")).sendKeys(str[1]);
	        driver.findElement(By.id("user_firstname")).sendKeys(str[2]);
	        driver.findElement(By.id("user_phone")).sendKeys(str[3]);
	        
	        
	        Select year= new Select(driver.findElement(By.id("user_dateofbirth_1i")));
	        year.selectByValue(str[4]);
	     
	        Select drpMonths= new Select(driver.findElement(By.id("user_dateofbirth_2i")));
	        drpMonths.selectByVisibleText(str[5]);
	        
	      
	        Select drpDays= new Select(driver.findElement(By.id("user_dateofbirth_3i")));
	        drpDays.selectByValue(str[6]);
	        
	        
	       
	        
	  	  WebElement radio2 = driver.findElement(By.id("user_licencetype_f"));
	  	  
	  	   radio2.click();
	  	   
	  	   
	  	 Select years= new Select(driver.findElement(By.id("user_licenceperiod")));
	        years.selectByValue(str[7]);
	        
	        Select occupation= new Select(driver.findElement(By.id("user_occupation_id")));
	        occupation.selectByVisibleText(str[8]);
	        
	        
	        driver.findElement(By.id("user_address_attributes_street")).sendKeys(str[9]);
	        driver.findElement(By.id("user_address_attributes_city")).sendKeys(str[10]);
	        driver.findElement(By.id("user_address_attributes_county")).sendKeys(str[11]);
	        driver.findElement(By.id("user_address_attributes_postcode")).sendKeys(str[12]);
	        
            driver.findElement(By.name("commit")).click();
	        
	        driver.findElement(By.xpath("//body/div[3]/form[1]/input[1]")).click();
	        

    	
}
	}
}


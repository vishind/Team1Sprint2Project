package EditProfile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EditProfile {


	public static void main(String[]args) {
		System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/insurance/v1/header.php");
		//Maximizing window
		driver.manage().window().maximize();
		
		//Explicit wait with conditions
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("editprofile")));
		driver.findElement(By.id("editprofile")).click();
		
		//Assert status line
		 Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Editing user profile')]")).getText().contains("Editing user profile"));
			System.out.println(" Title name  is:" + driver.findElement(By.xpath("//h1[contains(text(),'Editing user profile')]")).getText());
		   
		
		Select day= new Select(driver.findElement(By.id("user_title")));
        day.selectByValue("Ms");
        driver.findElement(By.id("user_surname")).sendKeys("abcd");
        driver.findElement(By.id("user_firstname")).sendKeys("xyz");
        driver.findElement(By.id("user_phone")).sendKeys("9876543210");
        
        
        Select year= new Select(driver.findElement(By.id("user_dateofbirth_1i")));
        year.selectByValue("1937");
     
        Select month= new Select(driver.findElement(By.id("user_dateofbirth_2i")));
        month.selectByVisibleText("February");
        
        Select date= new Select(driver.findElement(By.id("user_dateofbirth_3i")));
        date.selectByValue("5");
        
        WebElement radio1 = driver.findElement(By.id("user_licencetype_t")); 
  	  WebElement radio2 = driver.findElement(By.id("user_licencetype_f"));
  	  
  	   radio2.click();
  	   
  	   
  	 Select years= new Select(driver.findElement(By.id("user_licenceperiod")));
        years.selectByValue("4");
        
        Select occupation= new Select(driver.findElement(By.id("user_occupation_id")));
        occupation.selectByVisibleText("Doctor");
        
        
        driver.findElement(By.id("user_address_attributes_street")).sendKeys("aswathnagar");
        driver.findElement(By.id("user_address_attributes_city")).sendKeys("marathahalli");
        driver.findElement(By.id("user_address_attributes_county")).sendKeys("india");
        driver.findElement(By.id("user_address_attributes_postcode")).sendKeys("560037");
        
        driver.findElement(By.name("commit")).click();
        
        driver.findElement(By.xpath("//body/div[3]/form[1]/input[1]")).click();

         //closing driver
        
        driver.close();
}



	}



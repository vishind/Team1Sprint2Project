package DataDriven;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EditprofileXML {

	static String driverPath = "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
	@Test()
	@Parameters({"uTitle","uSurname","uFirstname","uPhone","uYear","uMonth","uDate","uYears","uOccupation","uStreet","uCity","uCountry","uPincode"})

	public void login(@Optional("Miss") String uTitle,@Optional("Majjiga") String uSurname,@Optional("Pavani") String uFirstname,@Optional("9870654321") String uPhone,@Optional("1954") String uYear,@Optional("February") String uMonth,@Optional("11") String uDate,@Optional("10") String uYears,@Optional("Actor") String uOccupation,@Optional("Marathahalli") String uStreet,@Optional("banglore") String uCity,@Optional("india") String uCountry,@Optional("560037") String uPincode)
	{
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/insurance/v1/header.php");
		
		driver.manage().window().maximize();
		
		/*driver.findElement(By.id("email")).sendKeys(uEmail);
		driver.findElement(By.id("password")).sendKeys(uPassword);
		driver.findElement(By.name("submit")).click();*/
		//driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("editprofile")));
		
		driver.findElement(By.id("editprofile")).click();
		
		 Select title= new Select(driver.findElement(By.id("user_title")));
	        title.selectByValue(uTitle);
	        driver.findElement(By.id("user_surname")).sendKeys(uSurname);
	        driver.findElement(By.id("user_firstname")).sendKeys(uFirstname);
	        driver.findElement(By.id("user_phone")).sendKeys(uPhone);
	        
	        
	        Select year= new Select(driver.findElement(By.id("user_dateofbirth_1i")));
	        year.selectByValue(uYear);
	     
	        Select month= new Select(driver.findElement(By.id("user_dateofbirth_2i")));
	        month.selectByVisibleText(uMonth);
	        
	        Select date= new Select(driver.findElement(By.id("user_dateofbirth_3i")));
	        date.selectByValue(uDate);
	        
	        
	  	  WebElement radio2 = driver.findElement(By.id("user_licencetype_f"));
	  	  
	  	   radio2.click();
	  	   
	  	   
	  	 Select years= new Select(driver.findElement(By.id("user_licenceperiod")));
	        years.selectByValue(uYears);
	        
	        Select occupation= new Select(driver.findElement(By.id("user_occupation_id")));
	        occupation.selectByVisibleText(uOccupation);
	        
	        
	        driver.findElement(By.id("user_address_attributes_street")).sendKeys(uStreet);
	        driver.findElement(By.id("user_address_attributes_city")).sendKeys(uCity);
	        driver.findElement(By.id("user_address_attributes_county")).sendKeys(uCountry);
	        driver.findElement(By.id("user_address_attributes_postcode")).sendKeys(uPincode);
	        
	        driver.findElement(By.name("commit")).click();
	        
	        driver.findElement(By.xpath("//body/div[3]/form[1]/input[1]")).click();
	        

}
}



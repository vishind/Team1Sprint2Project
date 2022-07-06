package Register;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDef {
	WebDriver driver;
	
	 @Given("^User launches Insurance Broker System Page$")
	    public void User_launches_Insurance_Broker_System_Page() {
	        
	        System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
	        driver=new ChromeDriver();
	        driver.get("https://demo.guru99.com/insurance/v1/index.php");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement(By.linkText("Register")).click();
	       
	    }
	    
	    @When("^User Register and login on page$")
	    public void User_Register_and_login_on_page(DataTable details) throws InterruptedException  {
	    	List<List<String>> data = details.cells();
			
	    
	        Select title= new Select(driver.findElement(By.id("user_title")));
	        title.selectByVisibleText(data.get(0).get(0));
	        
	        driver.findElement(By.id("user_firstname")).sendKeys(data.get(0).get(1));
	        driver.findElement(By.id("user_surname")).sendKeys(data.get(0).get(2));
	        driver.findElement(By.id("user_phone")).sendKeys(data.get(0).get(3));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        Select drpYears = new Select(driver.findElement(By.xpath("//*[@id=\"user_dateofbirth_1i\"]")));
	        drpYears.selectByValue(data.get(0).get(4));
	        
	        
	        Select drpMonths= new Select(driver.findElement(By.id("user_dateofbirth_2i")));
	        drpMonths.selectByVisibleText(data.get(0).get(5));
	        
	      
	        Select drpDays= new Select(driver.findElement(By.id("user_dateofbirth_3i")));
	        drpDays.selectByValue(data.get(0).get(6));
	        
	        WebElement radioFP = driver.findElement(By.id("licencetype_t"));  
	        radioFP.click();
	        
	        
	        Select occupation = new Select(driver.findElement(By.id("user_occupation_id")));
	        occupation.selectByVisibleText(data.get(0).get(7));
	        
	        
	        
	        driver.findElement(By.id("user_address_attributes_street")).sendKeys(data.get(0).get(8));
	        
	        driver.findElement(By.id("user_address_attributes_city")).sendKeys(data.get(0).get(9));
	        
	        driver.findElement(By.id("user_address_attributes_county")).sendKeys(data.get(0).get(10));
	        
	        driver.findElement(By.id("user_address_attributes_postcode")).sendKeys(data.get(0).get(11));
	        
	        driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys(data.get(0).get(12));
	        
	        driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys(data.get(0).get(13));
	        
	        driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys(data.get(0).get(14));
	        
	        driver.findElement(By.name("submit")).click();
	        
	        
	        Thread.sleep(3000);
	        driver.findElement(By.id("email")).sendKeys(data.get(0).get(15));
	        
	        driver.findElement(By.id("password")).sendKeys(data.get(0).get(16));
	        
	        driver.findElement(By.name("submit")).click();
	    
	    
	    }
	    
	    @Then("^User login successfully$")
	    public void User_login_successfully() 
	    {
	    	 if(driver.findElement(By.xpath("/html/body/div[3]/h4")).isDisplayed())
	    	 {
	         	System.out.println("Welcome "+driver.findElement(By.xpath("/html/body/div[3]/h4")).getText());
	         }
	    	System.out.println("Login Succesfully");
	    	
	    }
}
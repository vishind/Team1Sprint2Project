package Login;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	
	WebDriver driver;
	
	 @Given("^User is on Insurance Broker System Page$")
	    public void User_is_on_Insurance_Broker_System_Page() {
	        
	        System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
	        driver=new ChromeDriver();
	        driver.get("https://demo.guru99.com/insurance/v1/index.php");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	       
	    }
	    
	    @When("^User enters details for Login$")
	    public void User_enters_details_for_Login(DataTable details) throws InterruptedException  {
	    	List<List<String>> data = details.cells();
			

	    	driver.findElement(By.id("email")).sendKeys(data.get(0).get(0));

	    	driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
	     
	    
	    }
	    
	    @Then("^User is login successfully$")
	    public void User_is_login_successfully() throws InterruptedException 
	    {
	    	Thread.sleep(3000);

	    	driver.findElement(By.name("submit")).click();
	    	
	    	if(driver.findElement(By.xpath("/html/body/div[3]/h4")).isDisplayed())
	    	 {
	         	System.out.println("Welcome "+driver.findElement(By.xpath("/html/body/div[3]/h4")).getText());
	         }
	    	System.out.println("User login Succesfully");
	    	driver.close();
	    }
	
	

}

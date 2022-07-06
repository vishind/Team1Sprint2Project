package Edit;

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

public class EditProfileStepDef {
	WebDriver driver;

	 @Given("^User launches login page$")
	    public void User_launches_login_page() {
	        
	        System.setProperty("webdriver.chrome.driver", "D:\\\\Chromedriver\\\\chromedriver_win32\\\\chromedriver.exe");
	        driver=new ChromeDriver();
	        driver.get("https://demo.guru99.com/insurance/v1/header.php");
	        driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			/*driver.findElement(By.id("email")).sendKeys("vis@gmail.com");
			driver.findElement(By.id("password")).sendKeys("vishal5678");
			driver.findElement(By.name("submit")).click();*/
	    }
			@When("^User Enter all details$")
			public void User_Enter_all_details(DataTable details) {
				
				List<List<String>> data = details.cells();
				
				driver.findElement(By.id("editprofile")).click();
				
				Select day= new Select(driver.findElement(By.id("user_title")));
		        day.selectByValue(data.get(0).get(0));
		        driver.findElement(By.id("user_surname")).sendKeys(data.get(0).get(1));
		        driver.findElement(By.id("user_firstname")).sendKeys(data.get(0).get(2));
		        driver.findElement(By.id("user_phone")).sendKeys(data.get(0).get(3));
		        
		        
		        Select year= new Select(driver.findElement(By.id("user_dateofbirth_1i")));
		        year.selectByValue(data.get(0).get(4));
		     
		        Select drpMonths= new Select(driver.findElement(By.id("user_dateofbirth_2i")));
		        drpMonths.selectByVisibleText(data.get(0).get(5));
		        
		        Select date= new Select(driver.findElement(By.id("user_dateofbirth_3i")));
		        date.selectByValue(data.get(0).get(6));
		        
		  	  WebElement radio2 = driver.findElement(By.id("user_licencetype_f"));
		  	  
		  	   radio2.click();
		  	   
		  	   
		  	 Select years= new Select(driver.findElement(By.id("user_licenceperiod")));
		        years.selectByValue(data.get(0).get(7));
		        
		        Select occupation= new Select(driver.findElement(By.id("user_occupation_id")));
		        occupation.selectByVisibleText(data.get(0).get(8));
		        
		        
		        driver.findElement(By.id("user_address_attributes_street")).sendKeys(data.get(0).get(9));
		        driver.findElement(By.id("user_address_attributes_city")).sendKeys(data.get(0).get(10));
		        driver.findElement(By.id("user_address_attributes_county")).sendKeys(data.get(0).get(11));
		        driver.findElement(By.id("user_address_attributes_postcode")).sendKeys(data.get(0).get(12));
		        
		       
		}
			@Then("^the profile edited successfully$")
			public void the_profile_edited_successfully() {
				
				driver.findElement(By.xpath("//body/div[3]/form[1]/input[1]")).click();
				System.out.println("Edit profile successfully");
				
			}

}

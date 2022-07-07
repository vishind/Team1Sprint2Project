package RetrieveQuotation;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class RetieveQuotationStepDef {

	WebDriver driver;
	
	 @Given("^User launches on Retrieve Quotation page$")
	    public void user_launches_on_Retrieve_Quotation_page() {
	        
	        System.setProperty("webdriver.chrome.driver", "D:\\\\Chromedriver\\\\chromedriver_win32\\\\chromedriver.exe");
	        driver=new ChromeDriver();
	        driver.get("https://demo.guru99.com/insurance/v1/header.php");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.findElement(By.xpath("//li[@id='retrieve']")).click();	        
	    }
	    
	    @When("^User fills the quotation number clicks it$")
	    public void user_fills_the_quotation_number_clicks_it() throws InterruptedException  {
	    	driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[3]/form[1]/input[1]")).sendKeys("12696");
	    	driver.findElement(By.xpath("//input[@id='getquote']")).click();
	    }
		    
	    @Then("^The Retrieve Quotation page opens successfully$")
		public void the_Retrieve_Quotation_page_opens_successfully() throws InterruptedException {
			
	    	driver.findElement(By.xpath("//font[contains(text(),'Retrieve Quotation')]")).isDisplayed(); {
		 		System.out.println("Quotation is:" + driver.findElement(By.xpath("//font[contains(text(),'Retrieve Quotation')]")));
		 		}
		 		
		 		driver.findElement(By.xpath("//tbody/tr[4]/td[1]/b[1]")).isDisplayed(); {
		 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath("//tbody/tr[4]/td[1]/b[1]")).getText());
		 		}
		 		 
		 		driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).isDisplayed(); {
		 		System.out.println("Value is:" + driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText());
		 		}
		 		
		 		driver.findElement(By.xpath("//tbody/tr[6]/td[1]/b[1]")).isDisplayed(); {
		 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath("//tbody/tr[6]/td[1]/b[1]")).getText());
		 		}
		 		
		 		driver.findElement(By.xpath("//tbody/tr[6]/td[2]")).isDisplayed(); {
		 		System.out.println("Value is:" + driver.findElement(By.xpath("//tbody/tr[6]/td[2]")).getText());
		 		}
		 		
		 		driver.findElement(By.xpath("//tbody/tr[8]/td[1]/b[1]")).isDisplayed(); {
		 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath("//tbody/tr[8]/td[1]/b[1]")).getText());
		 		}
		 		
		 		driver.findElement(By.xpath("//tbody/tr[8]/td[2]")).isDisplayed(); {
		 		System.out.println("Value is:" + driver.findElement(By.xpath("//tbody/tr[8]/td[2]")).getText());
		 		}
		 		
		 		driver.findElement(By.xpath("//tbody/tr[9]/td[1]/b[1]")).isDisplayed(); {
		 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath("//tbody/tr[9]/td[1]/b[1]")).getText());
		 		}
		 		 
		 		driver.findElement(By.xpath("//tbody/tr[9]/td[2]")).isDisplayed(); {
		 		System.out.println("Value is:" + driver.findElement(By.xpath("//tbody/tr[9]/td[2]")).getText());
		 		}
		 		
		 		driver.findElement(By.xpath("//tbody/tr[10]/td[1]/b[1]")).isDisplayed(); {
		 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath("//tbody/tr[10]/td[1]/b[1]")).getText());
		 		}
		 		 
		 		driver.findElement(By.xpath("//tbody/tr[10]/td[2]")).isDisplayed(); {
		 		System.out.println("Value is:" + driver.findElement(By.xpath("//tbody/tr[10]/td[2]")).getText());
		 		}
	     		       	 driver.close();
		}

}

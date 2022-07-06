package Request;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestQuotationStepDef {
	WebDriver driver;
	
	 @Given("^User launches Request Quotation page$")
	 public void User_launches_Request_Quotation_page() {
		 
		 System.setProperty("webdriver.chrome.driver", "D:\\\\Chromedriver\\\\chromedriver_win32\\chromedriver.exe");
	     driver=new ChromeDriver();
	     driver.get("https://demo.guru99.com/insurance/v1/header.php");
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver.findElement(By.id("newquote")).click();
	 }
	    
	 @When("^User enters Quotation details$")
	 public void User_enters_Quotation_details(DataTable details) throws InterruptedException  {
		 
		 List<List<String>> data = details.cells();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
		 driver.findElement(By.linkText("Request Quotation")).click();
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//get the height of the webpage and scroll to the end
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    
		Select drpBdc = new Select(driver.findElement(By.id("quotation_breakdowncover")));
		drpBdc.selectByValue(data.get(0).get(0));
		    
		WebElement radio1 = driver.findElement(By.id("quotation_windscreenrepair_t"));
	  	WebElement radio2 = driver.findElement(By.id("quotation_windscreenrepair_f"));
	  	radio2.click();
	    
		driver.findElement(By.id("quotation_incidents")).sendKeys(data.get(0).get(1));
		driver.findElement(By.id("quotation_vehicle_attributes_registration")).sendKeys(data.get(0).get(2));
		driver.findElement(By.id("quotation_vehicle_attributes_mileage")).sendKeys(data.get(0).get(3));
		driver.findElement(By.id("quotation_vehicle_attributes_value")).sendKeys(data.get(0).get(4));
		    
		Select drpPl = new Select(driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation")));
		drpPl.selectByVisibleText(data.get(0).get(5));
		    
		Select drpYears = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i")));
		drpYears.selectByValue(data.get(0).get(6));
		    
		Select drpMonths= new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i")));
		drpMonths.selectByVisibleText(data.get(0).get(7));
		    
		Select drpDays= new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i")));
		drpDays.selectByValue(data.get(0).get(8));
	 }
	 
	 @And("^User clicks Calculate Premium gets premium details$")
	 public void User_clicks_Calculate_Premium_gets_premium_details() {
		 
		driver.findElement(By.cssSelector("div.content:nth-child(7) div.navigation.ui-tabs.ui-widget.ui-widget-content.ui-corner-all:nth-child(3) div.ui-tabs-panel.ui-widget-content.ui-corner-bottom:nth-child(4) form.new_quotation:nth-child(3) div.actions:nth-child(10) > input.btn.btn-default:nth-child(1)"));
		 
	 }
	    
	 @Then("^User clicks Save Quotation gets quotation details$")
	 public void User_clicks_Save_Quotation_gets_quotation_details() {
		 
		System.out.println("Page title is : " + driver.getTitle());
		
		if(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/form[1]/p[1]")).isDisplayed()) {
			 
			System.out.println("Text content: "+ driver.findElement(By.id("calculatedpremium")).getText());
	    }
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[8]/input[3]")).click();
		WebElement m =driver.findElement(By.xpath("/html[1]/body[1]"));
		System.out.println(m.getText());
		driver.close();
	 }

}

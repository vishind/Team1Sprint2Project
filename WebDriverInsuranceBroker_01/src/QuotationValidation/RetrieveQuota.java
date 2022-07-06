package QuotationValidation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RetrieveQuota {
	


	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		 String baseUrl = "https://demo.guru99.com/insurance/v1/header.php";
		 driver.get(baseUrl);
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	 		driver.manage().window().maximize();
	 		 String Title=driver.getTitle();
	 	     System.out.println("The title of the page is "+Title);
	 	   
	 	     String url=driver.getCurrentUrl();
	 	     System.out.println("The URL of the page is "+url);

	 		//driver.manage().window.maximize();
	 				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
	 		
	 		driver.findElement(By.id("ui-id-3")).click();
	 		
	         driver.findElement(By.name("id")).sendKeys("12696");
	         driver.findElement(By.id("getquote")).click(); 
	 		
	 		driver.findElement(By.xpath("//font[contains(text(),'Retrieve Quotation')]")).isDisplayed(); {
	 		System.out.println("Quotation is:" + driver.findElement(By.xpath("//font[contains(text(),'Retrieve Quotation')]")));
	 		}
	 		
	 		driver.findElement(By.xpath("//tbody/tr[4]/td[1]/b[1]")).isDisplayed(); {
	 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath("//tbody/tr[4]/td[1]/b[1]")).getText());
	 		}
	 		 
	 		driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).isDisplayed(); {
	 		System.out.println("Value is:" + driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText());
	 		}
	 		
	 		if(driver.findElement(By.xpath("//tbody/tr[6]/td[1]/b[1]")).isDisplayed()) {
		 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath("//tbody/tr[6]/td[1]/b[1]")).getText());
		 		}
		 		
		 		if(driver.findElement(By.xpath("//tbody/tr[6]/td[2]")).isDisplayed()) {
		 		System.out.println("Value is:" + driver.findElement(By.xpath("//tbody/tr[6]/td[2]")).getText());
		 		}
		 		
		 		if(driver.findElement(By.xpath("//tbody/tr[8]/td[1]/b[1]")).isDisplayed()) {
		 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath("//tbody/tr[8]/td[1]/b[1]")).getText());
		 		}
		 		
		 		if(driver.findElement(By.xpath("//tbody/tr[8]/td[2]")).isDisplayed()) {
		 		System.out.println("Value is:" + driver.findElement(By.xpath("//tbody/tr[8]/td[2]")).getText());
		 		}
		 		
		 		if(driver.findElement(By.xpath("//tbody/tr[9]/td[1]/b[1]")).isDisplayed()) {
		 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath("//tbody/tr[9]/td[1]/b[1]")).getText());
		 		}
		 		 
		 		if(driver.findElement(By.xpath("//tbody/tr[9]/td[2]")).isDisplayed()) {
		 		System.out.println("Value is:" + driver.findElement(By.xpath("//tbody/tr[9]/td[2]")).getText());
		 		}
		 		
		 		if(driver.findElement(By.xpath("//tbody/tr[10]/td[1]/b[1]")).isDisplayed()) {
		 		System.out.println("Insurance Name is:" + driver.findElement(By.xpath("//tbody/tr[10]/td[1]/b[1]")).getText());
		 		}
		 		
		 		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr[10]/td[2]")).getText(),"2016.10.17");
				System.out.println("Value is:" + driver.findElement(By.xpath("//tbody/tr[10]/td[2]")).getText());
		 	            driver.navigate().back();

		}



		}

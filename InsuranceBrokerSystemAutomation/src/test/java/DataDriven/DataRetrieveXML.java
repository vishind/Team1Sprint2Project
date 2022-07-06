package DataDriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataRetrieveXML {
static String driverPath = "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
	
	WebDriver driver;
	
	@Test
	@Parameters({"identificationnumber"})
	public void DataretriveXML(@Optional("12445")String identificationnumber)
	{
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/insurance/v1/header.php");
		

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newquote")));
		
		driver.findElement(By.id("newquote")).click();
		driver.findElement(By.name("submit")).click();
		
		
		
		driver.navigate().back();
		
		driver.findElement(By.id("retrieve")).click();
		
		driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[3]/form[1]/input[1]")).sendKeys(identificationnumber);
		driver.findElement(By.id("getquote")).click();
		
		driver.navigate().back();

}
}
       



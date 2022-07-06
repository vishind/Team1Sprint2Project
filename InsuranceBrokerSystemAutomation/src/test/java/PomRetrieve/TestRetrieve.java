package PomRetrieve;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestRetrieve {

String driverpath="D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
WebDriver driver;
RetriveQuotation objRet;
@BeforeTest
public void setup(){
    System.setProperty("webdriver.chrome.driver", driverpath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/insurance/v1/header.php");
		 driver.manage().window().maximize();
       
   }
   
   @Test(priority=0)
   public void test_Page_Appear_Correct(){
	   objRet=new RetriveQuotation(driver);
	   objRet.RetriveQuotation("12344");
	   
   }

}

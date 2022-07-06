package PomRequest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestIBS {
	String driverPath = "D:\\\\Chromedriver\\\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    ReqQuotationPage objReq;
   QuotationFillupPage objQuo;
   QuotdetailPage objQuotDet;
    @BeforeTest
    public void setup(){
    System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/insurance/v1/header.php");
        System.out.println(driver.getTitle());
    }
    
    @Test(priority=0)
    public void test_Page_Appear_Correct() throws InterruptedException, IOException{
    
    objReq = new ReqQuotationPage(driver);
    objReq.clickSignIn();
    Assert.assertTrue(objReq.getTitle().matches("[A-Z|a-z|\\W]+"));
    objQuo = new QuotationFillupPage(driver);

    objQuo.quotFill("No cover","Car accident","OD02AT0001","35 kmpl","150000","Public Place","2016","February","15");
    
    objQuotDet = new QuotdetailPage(driver);
    	
    String strUrl = driver.getCurrentUrl();
    System.out.println("Current Url is:"+ strUrl);
        
    if(driver.findElement(By.xpath("//body")).isDisplayed()) {
        	
    	System.out.println(driver.findElement(By.xpath("//body")).getText());
    }
    }
}

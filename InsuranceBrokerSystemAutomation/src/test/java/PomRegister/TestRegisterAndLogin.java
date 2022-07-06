package PomRegister;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRegisterAndLogin {
	String driverPath = "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    RegisterAndLogin objReLogin;
    Home objHome;
    Account objAcc;
    @BeforeTest
    public void setup(){
    System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
        System.out.println(driver.getTitle());
    }
    
    @Test(priority=0)
    public void test_Page_Appear_Correct() throws InterruptedException, IOException{
    
    //Create Object Of Home page
    objHome = new Home(driver);
    objHome.clickRegister();
    //Create an object of Account page
    objAcc = new Account(driver);
    //create an object of RegisterandLogin
    objReLogin = new RegisterAndLogin(driver);
    Thread.sleep(3000);
    objReLogin.register("Mr","Vishal","Shinde","9865895896","1992","December","11","Academic","MG Road,Pune","Pune","India","411025","vis1@gmail.com","vishal5678","vishal5678");
    
    objReLogin.login("vis@gmail.com","vishal5678");
    Assert.assertTrue(objAcc.getemail().matches("[A-Z|a-z|\\W]+"));
    
    if(driver.findElement(By.xpath("/html/body/div[3]/h4")).isDisplayed())
	 	{
    	System.out.println("Welcome "+driver.findElement(By.xpath("/html/body/div[3]/h4")).getText());
	 	}
    	System.out.println("Login Succesfully");
    	driver.close();
    
    }
}

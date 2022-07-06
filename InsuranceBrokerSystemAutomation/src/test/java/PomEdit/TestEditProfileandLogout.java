package PomEdit;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestEditProfileandLogout {


	String driverPath = "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
   EditProfile objEdit;
    
    @BeforeTest
    public void setup(){
    System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       /* driver.get("https://demo.guru99.com/insurance/v1/index.php");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("email")).sendKeys("vis@gmail.com");
		driver.findElement(By.id("password")).sendKeys("vishal5678");
		driver.findElement(By.name("submit")).click();*/
		
		
		 driver.get("https://demo.guru99.com/insurance/v1/header.php");
		 driver.manage().window().maximize();
        
    }
    
    @Test(priority=0)
    public void test_Page_Appear_Correct(){
    
    
    
   
    objEdit = new EditProfile(driver);
    
   
    
    objEdit.editProfile("Miss","majjiga","pavani","9870654321","1954","February","11","10","Actor","Marathahalli","banglore","india","560037");
    }
    
    }
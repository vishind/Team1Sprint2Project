package DataDriven;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class RegisterXML {
	static String driverPath = "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    
   
    @Test
    @Parameters({"Title","firstName","surName","phone","Year","Month","Date","Occupat","Street","City","Country","Postcode","Email","Password","PassConfo","Ema","Passw"})
    public void login(@Optional("Mr")String Title,@Optional("Vishal") String firstName,@Optional("Shinde")String surName,@Optional("9865895896")String phone,@Optional("1992")String Year,@Optional("December")String Month,@Optional("11")String Date,@Optional("Academic")String Occupat,@Optional("MG Road,Pune")String Street,@Optional("Pune")String City,@Optional("India")String Country,@Optional("411025")String Postcode,@Optional("vis1@gmail.com")String Email,@Optional("vishal5678")String Password,@Optional("vishal5678")String PassConfo,@Optional("vis@gmail.com")String Ema,@Optional("vishal5678")String Passw ) throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver",driverPath);           
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Register")).click();
       
    																																																																																																																							
    	
    	
         Select title= new Select(driver.findElement(By.id("user_title")));
         title.selectByVisibleText(Title);
         
         driver.findElement(By.id("user_firstname")).sendKeys(firstName);
         driver.findElement(By.id("user_surname")).sendKeys(surName);
         driver.findElement(By.id("user_phone")).sendKeys(phone);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         Select drpYears = new Select(driver.findElement(By.xpath("//*[@id=\"user_dateofbirth_1i\"]")));
         drpYears.selectByValue(Year);
         
         
         Select drpMonths= new Select(driver.findElement(By.id("user_dateofbirth_2i")));
         drpMonths.selectByVisibleText(Month);
         
       
         Select drpDays= new Select(driver.findElement(By.id("user_dateofbirth_3i")));
         drpDays.selectByValue(Date);
         
         WebElement radioFP = driver.findElement(By.id("licencetype_t"));  
         radioFP.click();
         
         
         Select occupation = new Select(driver.findElement(By.id("user_occupation_id")));
         occupation.selectByVisibleText(Occupat);
         
         
         
         driver.findElement(By.id("user_address_attributes_street")).sendKeys(Street);
         
         driver.findElement(By.id("user_address_attributes_city")).sendKeys(City);
         
         driver.findElement(By.id("user_address_attributes_county")).sendKeys(Country);
         
         driver.findElement(By.id("user_address_attributes_postcode")).sendKeys(Postcode);
         
         driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys(Email);
         
         driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys(Password);
         
         driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys(PassConfo);
         
         driver.findElement(By.name("submit")).click();
         
         
         Thread.sleep(3000);
         driver.findElement(By.id("email")).sendKeys(Ema);
         
         driver.findElement(By.id("password")).sendKeys(Passw);
         
         driver.findElement(By.name("submit")).click();
         
        
	
    }
}

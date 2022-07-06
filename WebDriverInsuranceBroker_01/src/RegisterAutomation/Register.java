package RegisterAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Register {
	
  public static void main(String[] args) throws InterruptedException, IOException {
       
        System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");           
        // Create WebDriver Instance
        WebDriver driver = new ChromeDriver();
       //maximize the window
        driver.manage().window().maximize();
        
        //launch the Webpage
        driver.get("https://demo.guru99.com/insurance/v1/index.php");

        
        // Displaying page title
        String Title=driver.getTitle();
        System.out.println("The title of the page is "+Title);
        
        String url=driver.getCurrentUrl();
        System.out.println("The URL of the page is "+url);
        //Displaying page url
      
        //Explicit conditional wait
        WebDriverWait waitA = new WebDriverWait(driver,Duration.ofSeconds(20));
		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register")));
        
        driver.findElement(By.linkText("Register")).click();
        
        //Read the file
        FileInputStream fis = new FileInputStream("D:\\Sprint2Project\\data\\Book.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
    		XSSFSheet ws = workbook.getSheetAt(0);

    		int rownum  = ws.getLastRowNum();
    		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
    		System.out.println(colnum);
    		System.out.println(rownum);
    		
    		for(int i = 0; i <= rownum ; i++) 
    		{
    		  
    			
    	WebDriverWait waitAC = new WebDriverWait(driver,Duration.ofSeconds(15));
    	waitAC.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_title")));
    	      		
        
       
        Select title= new Select(driver.findElement(By.id("user_title")));
        title.selectByVisibleText(ws.getRow(i).getCell(0).toString());
        
        driver.findElement(By.id("user_firstname")).sendKeys(ws.getRow(i).getCell(1).toString());
        driver.findElement(By.id("user_surname")).sendKeys(ws.getRow(i).getCell(2).toString());
        driver.findElement(By.id("user_phone")).sendKeys(ws.getRow(i).getCell(3).toString());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select drpYears = new Select(driver.findElement(By.xpath("//*[@id=\"user_dateofbirth_1i\"]")));
        drpYears.selectByValue(ws.getRow(i).getCell(4).toString());
        
        //Select the dropdown list
        Select drpMonths= new Select(driver.findElement(By.id("user_dateofbirth_2i")));
        drpMonths.selectByVisibleText(ws.getRow(i).getCell(5).toString());
        
      
        Select drpDays= new Select(driver.findElement(By.id("user_dateofbirth_3i")));
        drpDays.selectByValue(ws.getRow(i).getCell(6).toString());
        
        WebElement radioFP = driver.findElement(By.id("licencetype_t"));  
        radioFP.click();
        
        
        Select occupation = new Select(driver.findElement(By.id("user_occupation_id")));
        occupation.selectByVisibleText(ws.getRow(i).getCell(7).toString());
        
        
        
        driver.findElement(By.id("user_address_attributes_street")).sendKeys(ws.getRow(i).getCell(8).toString());
        
        driver.findElement(By.id("user_address_attributes_city")).sendKeys(ws.getRow(i).getCell(9).toString());
        
        driver.findElement(By.id("user_address_attributes_county")).sendKeys(ws.getRow(i).getCell(10).toString());
        
        driver.findElement(By.id("user_address_attributes_postcode")).sendKeys(ws.getRow(i).getCell(11).toString());
        
        driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys(ws.getRow(i).getCell(12).toString());
        
        driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys(ws.getRow(i).getCell(13).toString());
        
        driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys(ws.getRow(i).getCell(14).toString());
        
        driver.findElement(By.name("submit")).click();
        
        
        WebDriverWait waitAD = new WebDriverWait(driver,Duration.ofSeconds(20));
    	waitAD.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    	
        driver.findElement(By.id("email")).sendKeys(ws.getRow(i).getCell(15).toString());
        
        driver.findElement(By.id("password")).sendKeys(ws.getRow(i).getCell(16).toString());
        
    	}
    		 driver.findElement(By.name("submit")).click();
    		 
    		 WebDriverWait waitAD = new WebDriverWait(driver,Duration.ofSeconds(20));
    	    waitAD.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/h4")));
    	    	
    	
    	Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/h4")).getText().contains("[A-Z|a-z|\\W]+"));

        if(driver.findElement(By.xpath("/html/body/div[3]/h4")).isDisplayed())
   	 	{
        	System.out.println("Welcome "+driver.findElement(By.xpath("/html/body/div[3]/h4")).getText());
        	System.out.println("Login Succesfully");
   	 	}
        
        if(driver.findElement(By.xpath("//h2[contains(text(),'Broker Insurance WebPage')]")).isDisplayed())
        {
		System.out.println("Page Title is:" + driver.findElement(By.xpath("//h2[contains(text(),'Broker Insurance WebPage')]")).getText());
        }
        driver.close();
        driver.quit();
  }
}


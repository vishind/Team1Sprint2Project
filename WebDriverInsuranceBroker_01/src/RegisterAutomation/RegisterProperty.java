package RegisterAutomation;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterProperty {
	
	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver;
		File src = new File("./TestResources/Register.property");
		FileInputStream fis = new FileInputStream(src);
		
		 // Load the properties File
		Properties prop = new Properties();
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriver"));
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		driver.manage().window().maximize();
		 
	        String Title=driver.getTitle();
	        System.out.println("The title of the page is "+Title);
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        driver.findElement(By.linkText(prop.getProperty("register"))).click();
	        
	        
	        FileInputStream fis1 = new FileInputStream("D:\\Sprint2Project\\data\\Book.xlsx");
	        XSSFWorkbook workbook = new XSSFWorkbook(fis1);
	    		XSSFSheet ws = workbook.getSheetAt(0);

	    		int rownum  = ws.getLastRowNum();
	    		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
	    		System.out.println(colnum);
	    		System.out.println(rownum);
	    		
	
	    		for(int i = 0; i <= rownum ; i++) 
	    		{
	    		  

	    	WebDriverWait waitAC = new WebDriverWait(driver,Duration.ofSeconds(15));
	    	waitAC.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_title")));
	    	      		
	        Select title= new Select(driver.findElement(By.id(prop.getProperty("title"))));
	        title.selectByVisibleText(ws.getRow(i).getCell(0).toString());
	        
	        driver.findElement(By.id(prop.getProperty("firstname"))).sendKeys(ws.getRow(i).getCell(1).toString());
	        driver.findElement(By.id(prop.getProperty("lastname"))).sendKeys(ws.getRow(i).getCell(2).toString());
	        driver.findElement(By.id(prop.getProperty("phone"))).sendKeys(ws.getRow(i).getCell(3).toString());
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        Select drpYears = new Select(driver.findElement(By.xpath(prop.getProperty("year"))));
	        drpYears.selectByValue(ws.getRow(i).getCell(4).toString());
	        
	        
	        Select drpMonths= new Select(driver.findElement(By.id(prop.getProperty("month"))));
	        drpMonths.selectByVisibleText(ws.getRow(i).getCell(5).toString());
	        
	      
	        Select drpDays= new Select(driver.findElement(By.id(prop.getProperty("date"))));
	        drpDays.selectByValue(ws.getRow(i).getCell(6).toString());
	        
	        WebElement radioFP = driver.findElement(By.id(prop.getProperty("radoo")));  
	        radioFP.click();
	        
	        
	        Select occupation = new Select(driver.findElement(By.id(prop.getProperty("occup"))));
	        occupation.selectByVisibleText(ws.getRow(i).getCell(7).toString());
	        
	        
	        
	        driver.findElement(By.id(prop.getProperty("street"))).sendKeys(ws.getRow(i).getCell(8).toString());
	        
	        driver.findElement(By.id(prop.getProperty("city"))).sendKeys(ws.getRow(i).getCell(9).toString());
	        
	        driver.findElement(By.id(prop.getProperty("country"))).sendKeys(ws.getRow(i).getCell(10).toString());
	        
	        driver.findElement(By.id(prop.getProperty("postcode"))).sendKeys(ws.getRow(i).getCell(11).toString());
	        
	        driver.findElement(By.id(prop.getProperty("email"))).sendKeys(ws.getRow(i).getCell(12).toString());
	        
	        driver.findElement(By.id(prop.getProperty("password"))).sendKeys(ws.getRow(i).getCell(13).toString());
	        
	        driver.findElement(By.id(prop.getProperty("passwordconfo"))).sendKeys(ws.getRow(i).getCell(14).toString());
	        
	        driver.findElement(By.name(prop.getProperty("submitt"))).click();
	        
	        
	        Thread.sleep(3000);
	        driver.findElement(By.id(prop.getProperty("ema"))).sendKeys(ws.getRow(i).getCell(15).toString());
	        
	        driver.findElement(By.id(prop.getProperty("passww"))).sendKeys(ws.getRow(i).getCell(16).toString());
	        
	        driver.findElement(By.name(prop.getProperty("submittt"))).click();
	        
	    		}
	        
	        if(driver.findElement(By.xpath("/html/body/div[3]/h4")).isDisplayed())
	   	 	{
	        	System.out.println("Welcome "+driver.findElement(By.xpath("/html/body/div[3]/h4")).getText());
	        }
	        System.out.println("Login Succesfully");
	        
	        
	        if(driver.findElement(By.xpath("//h2[contains(text(),'Broker Insurance WebPage')]")).isDisplayed())
	        {
			System.out.println("Page Title is:" + driver.findElement(By.xpath("//h2[contains(text(),'Broker Insurance WebPage')]")).getText());
	       
	        }
}
}

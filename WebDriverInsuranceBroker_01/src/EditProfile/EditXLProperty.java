package EditProfile;
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
import org.testng.Assert;

public class EditXLProperty {


	public static void main(String[]args) throws IOException {
		//Create WebDriver Instance
	WebDriver driver;
	File src=new File("./TestResources/Insurance.property");
	FileInputStream fis =new FileInputStream(src);
	//Load the properties File
	Properties prop=new Properties();
	prop.load(fis);
	System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");                    
    driver = new ChromeDriver();                    
    driver.get(prop.getProperty("url")); 
    //Maximizing the  Window
    driver.manage().window().maximize();  
    
    //Clicking on editProfile

    driver.findElement(By.id(prop.getProperty("editprofile"))).click();
    
    
    
    FileInputStream fis1 = new FileInputStream("D:\\Sprint2Project\\data\\EditProfileDatatable.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis1);
		XSSFSheet ws = workbook.getSheetAt(0);

		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		
	
		

		for(int i = 0; i <= rownum ; i++) {
		   
			WebDriverWait waitAC = new WebDriverWait(driver,Duration.ofSeconds(15));
	    	waitAC.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("title"))));
	    	
    
    
    
    
    //Assert status line
   Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("pagetitle"))).getText().contains("Editing user profile"));
   //Print the title name of the page
	System.out.println(" Title name  is:" + driver.findElement(By.xpath(prop.getProperty("pagetitle"))).getText());
   
    
    
   
    Select day= new Select(driver.findElement(By.id(prop.getProperty("title"))));
    day.selectByValue(ws.getRow(i).getCell(0).toString());
    driver.findElement(By.id(prop.getProperty("surname"))).sendKeys(ws.getRow(i).getCell(1).toString());
    driver.findElement(By.id(prop.getProperty("firstname"))).sendKeys(ws.getRow(i).getCell(2).toString());
    driver.findElement(By.id(prop.getProperty("phone"))).sendKeys(ws.getRow(i).getCell(3).toString());
    
    
    Select year= new Select(driver.findElement(By.id(prop.getProperty("year"))));
    year.selectByValue(ws.getRow(i).getCell(4).toString());
 
    Select month= new Select(driver.findElement(By.id(prop.getProperty("month"))));
    month.selectByVisibleText(ws.getRow(i).getCell(5).toString());
    
    Select date= new Select(driver.findElement(By.id(prop.getProperty("date"))));
    date.selectByValue(ws.getRow(i).getCell(6).toString());
    
   
	  WebElement radio2 = driver.findElement(By.id(prop.getProperty("licence")));
	  
	   radio2.click();
	   
	   
	 Select years= new Select(driver.findElement(By.id(prop.getProperty("years"))));
    years.selectByValue(ws.getRow(i).getCell(7).toString());
    
    Select occupation= new Select(driver.findElement(By.id(prop.getProperty("occupation"))));
    occupation.selectByVisibleText(ws.getRow(i).getCell(8).toString());
    
    
    driver.findElement(By.id(prop.getProperty("street"))).sendKeys(ws.getRow(i).getCell(9).toString());
    driver.findElement(By.id(prop.getProperty("city"))).sendKeys(ws.getRow(i).getCell(10).toString());
    driver.findElement(By.id(prop.getProperty("country"))).sendKeys(ws.getRow(i).getCell(11).toString());
    driver.findElement(By.id(prop.getProperty("pincode"))).sendKeys(ws.getRow(i).getCell(12).toString());
    
    driver.findElement(By.name(prop.getProperty("update"))).click();
    
    driver.findElement(By.xpath(prop.getProperty("logout"))).click();
		 }
    
    //Closing driver
    
       driver.close();

}



}



  






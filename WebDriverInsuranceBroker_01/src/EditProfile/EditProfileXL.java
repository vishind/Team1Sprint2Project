package EditProfile;

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

public class EditProfileXL {


	public static void main(String[]args) throws IOException {
		System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/insurance/v1/header.php");
		//Maximizing window
		driver.manage().window().maximize();
		
		//Explicit wait with conditions
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("editprofile")));
		driver.findElement(By.id("editprofile")).click();
		
		
		 
	    FileInputStream fis1 = new FileInputStream("D:\\Sprint2Project\\data\\EditProfileDatatable.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis1);
			XSSFSheet ws = workbook.getSheetAt(0);

			int rownum  = ws.getLastRowNum();
			int colnum = ws.getRow(0).getPhysicalNumberOfCells();
			System.out.println(colnum);
			System.out.println(rownum);
			
		
			

			for(int i = 0; i <= rownum ; i++) {
			   
		
		//Assert status line
		 Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Editing user profile')]")).getText().contains("Editing user profile"));
			System.out.println(" Title name  is:" + driver.findElement(By.xpath("//h1[contains(text(),'Editing user profile')]")).getText());
		   
		
		Select day= new Select(driver.findElement(By.id("user_title")));
        day.selectByValue(ws.getRow(i).getCell(0).toString());
        driver.findElement(By.id("user_surname")).sendKeys(ws.getRow(i).getCell(1).toString());
        driver.findElement(By.id("user_firstname")).sendKeys(ws.getRow(i).getCell(2).toString());
        driver.findElement(By.id("user_phone")).sendKeys(ws.getRow(i).getCell(3).toString());
        
        
        Select year= new Select(driver.findElement(By.id("user_dateofbirth_1i")));
        year.selectByValue(ws.getRow(i).getCell(4).toString());
     
        Select month= new Select(driver.findElement(By.id("user_dateofbirth_2i")));
        month.selectByVisibleText(ws.getRow(i).getCell(5).toString());
        
        Select date= new Select(driver.findElement(By.id("user_dateofbirth_3i")));
        date.selectByValue(ws.getRow(i).getCell(6).toString());
        
        WebElement radio1 = driver.findElement(By.id("user_licencetype_t")); 
  	  WebElement radio2 = driver.findElement(By.id("user_licencetype_f"));
  	  
  	   radio2.click();
  	   
  	   
  	 Select years= new Select(driver.findElement(By.id("user_licenceperiod")));
        years.selectByValue(ws.getRow(i).getCell(7).toString());
        
        Select occupation= new Select(driver.findElement(By.id("user_occupation_id")));
        occupation.selectByVisibleText(ws.getRow(i).getCell(8).toString());
        
        
        driver.findElement(By.id("user_address_attributes_street")).sendKeys(ws.getRow(i).getCell(9).toString());
        driver.findElement(By.id("user_address_attributes_city")).sendKeys(ws.getRow(i).getCell(10).toString());
        driver.findElement(By.id("user_address_attributes_county")).sendKeys(ws.getRow(i).getCell(11).toString());
        driver.findElement(By.id("user_address_attributes_postcode")).sendKeys(ws.getRow(i).getCell(12).toString());
        
        driver.findElement(By.name("commit")).click();
        
        driver.findElement(By.xpath("//body/div[3]/form[1]/input[1]")).click();

         //closing driver
        
        driver.close();
}



	}

}



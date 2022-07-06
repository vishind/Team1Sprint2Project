package RequestAutomation;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReqQuotation {
public static void main(String [] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.guru99.com/insurance/v1/header.php");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        
        driver.findElement(By.id("newquote")).click();
        
        FileInputStream fis1 = new FileInputStream("D:\\Sprint2Project\\data\\Quotation.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis1);
    	XSSFSheet ws = workbook.getSheetAt(0);

    	int rownum  = ws.getLastRowNum();
    	int colnum = ws.getRow(0).getPhysicalNumberOfCells();
    	System.out.println(colnum);
    	System.out.println(rownum);
    	for(int i = 0; i <= rownum ; i++) {
    	
        driver.findElement(By.id("quotation_breakdowncover")).sendKeys(ws.getRow(i).getCell(0).toString());
        
        WebElement radio1 = driver.findElement(By.id("quotation_windscreenrepair_t"));
  	  	WebElement radio2 = driver.findElement(By.id("quotation_windscreenrepair_f"));
  	   	radio2.click();
        
        driver.findElement(By.id("quotation_incidents")).sendKeys(ws.getRow(i).getCell(1).toString());
        driver.findElement(By.id("quotation_vehicle_attributes_registration")).sendKeys(ws.getRow(i).getCell(2).toString());
        driver.findElement(By.id("quotation_vehicle_attributes_mileage")).sendKeys(ws.getRow(i).getCell(3).toString());
        driver.findElement(By.id("quotation_vehicle_attributes_value")).sendKeys(ws.getRow(i).getCell(4).toString());
        driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation")).sendKeys(ws.getRow(i).getCell(5).toString());
        driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i")).sendKeys(ws.getRow(i).getCell(6).toString());
        driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i")).sendKeys(ws.getRow(i).getCell(7).toString());
        driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i")).sendKeys(ws.getRow(i).getCell(8).toString());
        
        driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[8]/input[1]")).click();
        
        System.out.println("Page title is : " + driver.getTitle());
        WebElement l =driver.findElement(By.id("calculatedpremium"));
        System.out.println("Text content: "+ l.getText());
        
        driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[8]/input[3]")).click();
        
        WebElement m = driver.findElement(By.xpath("/html[1]/body[1]"));
        System.out.println(m.getText());
    	}
    	driver.navigate().back();
	}
}



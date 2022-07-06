package RequestAutomation;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestQuotation {

public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		File src = new File("./TestResources/Request.property");
		FileInputStream fis = new FileInputStream(src);
		Properties prop = new Properties();
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        
        driver.findElement(By.id(prop.getProperty("reqQuotation"))).click();
        FileInputStream fis1 = new FileInputStream("D:\\Sprint2Project\\data\\Quotation.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis1);
    		XSSFSheet ws = workbook.getSheetAt(0);
    		
    		

    		int rownum  = ws.getLastRowNum();
    		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
    		System.out.println(colnum);
    		System.out.println(rownum);
    		for(int i = 0; i <= rownum ; i++) {
        driver.findElement(By.id(prop.getProperty("bdc"))).sendKeys(ws.getRow(i).getCell(0).toString());
        
  	  	WebElement radio2 = driver.findElement(By.id(prop.getProperty("rad")));
  	   	radio2.click();
        
        driver.findElement(By.id(prop.getProperty("incident"))).sendKeys(ws.getRow(i).getCell(1).toString());
        driver.findElement(By.id(prop.getProperty("registration"))).sendKeys(ws.getRow(i).getCell(2).toString());
        driver.findElement(By.id(prop.getProperty("mileage"))).sendKeys(ws.getRow(i).getCell(3).toString());
        driver.findElement(By.id(prop.getProperty("vehicle"))).sendKeys(ws.getRow(i).getCell(4).toString());
        driver.findElement(By.id(prop.getProperty("location"))).sendKeys(ws.getRow(i).getCell(5).toString());
        driver.findElement(By.id(prop.getProperty("year"))).sendKeys(ws.getRow(i).getCell(6).toString());
        driver.findElement(By.id(prop.getProperty("month"))).sendKeys(ws.getRow(i).getCell(7).toString());
        driver.findElement(By.id(prop.getProperty("date"))).sendKeys(ws.getRow(i).getCell(8).toString());
        
        driver.findElement(By.xpath(prop.getProperty("calculate"))).click();
        
        System.out.println("Page title is : " + driver.getTitle());
        WebElement l =driver.findElement(By.id(prop.getProperty("premium")));
        System.out.println("Text content: "+ l.getText());
        
        driver.findElement(By.xpath(prop.getProperty("saveQuot"))).click();
        
        WebElement m = driver.findElement(By.xpath(prop.getProperty("quotNo")));
        System.out.println(m.getText());
	}
}
}



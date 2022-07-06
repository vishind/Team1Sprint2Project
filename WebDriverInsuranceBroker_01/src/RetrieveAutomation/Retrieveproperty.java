package RetrieveAutomation;
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
import org.openqa.selenium.support.ui.WebDriverWait;

public class Retrieveproperty {

public static void main(String[] args) throws IOException {
		WebDriver driver;
		File src = new File("./TestResources/Retrieve.property");
		FileInputStream fis = new FileInputStream(src);
		Properties prop = new Properties();
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromeDriver"));
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		//driver.get("https://demo.guru99.com/insurance/v1/header.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("RequestQuotation"))));
		
		driver.findElement(By.id(prop.getProperty("RequestQuotation"))).click();
		driver.findElement(By.name(prop.getProperty("SaveQuotation"))).click();
		 WebElement m =driver.findElement(By.xpath(prop.getProperty("fetchwords")));
	        System.out.println("Text content: "+ m.getText());
		
		
		
		driver.navigate().back();
		
		driver.findElement(By.id(prop.getProperty("RetriveQuotation"))).click();
		driver.findElement(By.id("retrieve")).click();
		FileInputStream fis1 = new FileInputStream("D:\\Sprint2Project\\data\\book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis1);
    		XSSFSheet ws = workbook.getSheetAt(0);
    		
    		

    		int rownum  = ws.getLastRowNum();
    		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
    		System.out.println(colnum);
    		System.out.println(rownum);
    		for(int i = 0; i <= rownum ; i++) {
		
		driver.findElement(By.xpath(prop.getProperty("Identificationnumber"))).sendKeys(ws.getRow(i).getCell(0).toString());
		driver.findElement(By.id(prop.getProperty("sumitRetrive"))).click();
		
	
    		}
    		driver.navigate().back();	
		
}
}

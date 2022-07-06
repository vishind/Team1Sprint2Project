package PomRequest;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDataDriven {
	String driverPath = "D:\\\\Chromedriver\\\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    ReqQuotationPage objReq;
    QuotationFillupPage objQuot;
    QuotdetailPage objQuotDet;
    
    @BeforeTest
    public void setup() {
	    System.setProperty("webdriver.chrome.driver", driverPath);
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://demo.guru99.com/insurance/v1/header.php");
	    System.out.println(driver.getTitle());
    }
    
    @Test(priority=0)
    public void test_Page_Appear_Correct() throws InterruptedException, IOException{
        
        objReq = new ReqQuotationPage(driver);
        objReq.clickSignIn();
        Assert.assertTrue(objReq.getTitle().matches("[A-Z|a-z|\\W]+"));
    
        objQuot = new QuotationFillupPage(driver);
        FileInputStream fis = new FileInputStream("C:\\Selenium\\DataSource\\Quotation.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet ws = workbook.getSheetAt(0);
	
			int rownum  = ws.getLastRowNum();
			int colnum = ws.getRow(0).getPhysicalNumberOfCells();
			System.out.println(colnum);
			System.out.println(rownum);
			
			XSSFCell BDCover;
			XSSFCell Incident;
			XSSFCell Reg;
			XSSFCell Mileage;
			XSSFCell Value;
			XSSFCell Parking;
			XSSFCell Year;
			XSSFCell Month;
			XSSFCell Date;
		
		for(int i = 0; i <= rownum ; i++) {
			
			BDCover = ws.getRow(i).getCell(0);
			Incident = ws.getRow(i).getCell(1);
			Reg = ws.getRow(i).getCell(2);
			Mileage = ws.getRow(i).getCell(3);
			Value = ws.getRow(i).getCell(4);
			Parking = ws.getRow(i).getCell(5);
			Year = ws.getRow(i).getCell(6);
			Month = ws.getRow(i).getCell(7);
			Date = ws.getRow(i).getCell(8);
		    
			objQuot.quotFill(BDCover.toString(),Incident.toString(), Reg.toString(), Mileage.toString(), Value.toString(), Parking.toString(), Year.toString(), Month.toString(), Date.toString());
		    
		}
		
		objQuotDet = new QuotdetailPage(driver);
		String strUrl = driver.getCurrentUrl();
	    System.out.println("Current Url is:"+ strUrl);
	        
	    if(driver.findElement(By.xpath("//body")).isDisplayed()) {
	        	
	    	System.out.println(driver.findElement(By.xpath("//body")).getText());
	    }

}
}

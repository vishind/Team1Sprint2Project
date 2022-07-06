package PomEdit;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDataDriven {


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
    public void test_Page_Appear_Correct() throws IOException{
    
    
    
   
    objEdit = new EditProfile(driver);
    FileInputStream fis = new FileInputStream("D:\\Sprint2Project\\data\\EditProfileDatatable.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet ws = workbook.getSheetAt(0);

		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		
		XSSFCell Title;
		XSSFCell SurName;
		XSSFCell FirstName;
		XSSFCell Phone;
		XSSFCell Year ;
		XSSFCell Month;
		XSSFCell Date;
		XSSFCell LicencePeriod;
		XSSFCell Occupation ;
		XSSFCell Street ;
		XSSFCell City;
		XSSFCell Country ;
		XSSFCell PostCode ;
		

		for(int i = 0; i <= rownum ; i++) {
		    Title = ws.getRow(i).getCell(0);
		    SurName = ws.getRow(i).getCell(1);
		    FirstName = ws.getRow(i).getCell(2);
		    Phone = ws.getRow(i).getCell(3);
		    Year = ws.getRow(i).getCell(4);
		    Month = ws.getRow(i).getCell(5);
		    Date = ws.getRow(i).getCell(6);
		    LicencePeriod = ws.getRow(i).getCell(7);
		    Occupation = ws.getRow(i).getCell(8);
		    Street = ws.getRow(i).getCell(9);
		    City = ws.getRow(i).getCell(10);
		    Country = ws.getRow(i).getCell(11);
		    PostCode = ws.getRow(i).getCell(12);
		    
		    objEdit.editProfile(Title.toString(),SurName.toString(), FirstName.toString(),Phone.toString(),Year.toString(),Month.toString(),Date.toString(),LicencePeriod.toString(), Occupation.toString(),Street.toString(), City.toString(), Country.toString(), PostCode.toString());
}
    }
}

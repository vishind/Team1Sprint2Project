package PomRegister;

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
	//chrome driver path
	String driverPath = "D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    RegisterAndLogin objReLogin;
    Home objHome;
    Account objAcc;
    

 

    @BeforeTest
    public void setup(){
    System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
        System.out.println(driver.getTitle());
    }
    
    @Test(priority=0)
    public void test_Page_Appear_Correct() throws InterruptedException, IOException{
    
    //Create Object Of Home page
    objHome = new Home(driver);
    
    objHome.clickRegister();
    
    objAcc = new Account(driver);
    
    objReLogin = new RegisterAndLogin(driver);
    
    FileInputStream fis = new FileInputStream("D:\\Sprint2Project\\data\\Book.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet ws = workbook.getSheetAt(0);

		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		
		XSSFCell Title;
		XSSFCell FirstName;
		XSSFCell LastName;
		XSSFCell Phone;
		XSSFCell Year ;
		XSSFCell Month;
		XSSFCell Date;
		XSSFCell Occupation ;
		XSSFCell Street ;
		XSSFCell City;
		XSSFCell Country ;
		XSSFCell PostCode ;
		XSSFCell Email ;
		XSSFCell Password ;
		XSSFCell PasswordConfo;

		
		for(int i = 0; i <= rownum ; i++) {
		    Title = ws.getRow(i).getCell(0);
		    FirstName = ws.getRow(i).getCell(1);
		    LastName = ws.getRow(i).getCell(2);
		    Phone = ws.getRow(i).getCell(3);
		    Year = ws.getRow(i).getCell(4);
		    Month = ws.getRow(i).getCell(5);
		    Date = ws.getRow(i).getCell(6);
		    Occupation = ws.getRow(i).getCell(7);
		    Street = ws.getRow(i).getCell(8);
		    City = ws.getRow(i).getCell(9);
		    Country = ws.getRow(i).getCell(10);
		    PostCode = ws.getRow(i).getCell(11);
		    Email = ws.getRow(i).getCell(12);
		    Password = ws.getRow(i).getCell(13);
		    PasswordConfo = ws.getRow(i).getCell(14);
		    
		    
		    objReLogin.register(Title.toString(),FirstName.toString(), LastName.toString(),Phone.toString(),Year.toString(),Month.toString(),Date.toString(), Occupation.toString(),Street.toString(), City.toString(), Country.toString(), PostCode.toString(), Email.toString(), Password.toString(),PasswordConfo.toString());
		    
		}
		 objReLogin.login("vis@gmail.com","vishal5678");
		 Assert.assertTrue(objAcc.getemail().matches("[A-Z|a-z|\\W]+"));
		    
		    if(driver.findElement(By.xpath("/html/body/div[3]/h4")).isDisplayed())
			 	{
		    	System.out.println("Welcome "+driver.findElement(By.xpath("/html/body/div[3]/h4")).getText());
			 	}
		    	System.out.println("Login Succesfully");
		    driver.close();
		    }
    }



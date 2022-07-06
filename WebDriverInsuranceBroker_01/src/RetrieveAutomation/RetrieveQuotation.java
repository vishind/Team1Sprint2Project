package RetrieveAutomation;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class RetrieveQuotation {

	
	 public static void main(String[] args) throws IOException, InterruptedException 
	 {
		 
	    System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");           
	    WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/insurance/v1/header.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newquote")));
		
		driver.findElement(By.id("newquote")).click();
		driver.findElement(By.name("submit")).click();
		 WebElement m =driver.findElement(By.xpath("/html[1]/body[1]"));
	        System.out.println("Text content: "+ m.getText());
		
		
		
		driver.navigate().back();
		
		//this command is used to click the retrieve button
		driver.findElement(By.id("retrieve")).click();
		FileInputStream fis = new FileInputStream("D:\\Sprint2Project\\data\\book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
    		XSSFSheet ws = workbook.getSheetAt(0);
    		
    		

    		int rownum  = ws.getLastRowNum();
    		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
    		System.out.println(colnum);
    		System.out.println(rownum);
    		for(int i = 0; i <= rownum ; i++) {
		driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[3]/form[1]/input[1]")).sendKeys(ws.getRow(i).getCell(0).toString());
		driver.findElement(By.id("getquote")).click();
		
    		}

    		driver.navigate().back();

}
}

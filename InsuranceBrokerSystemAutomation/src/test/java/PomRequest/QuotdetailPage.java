package PomRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuotdetailPage {
	WebDriver driver;
	By quotDet = By.xpath("/html[1]/body[1]");
		 
	public QuotdetailPage(WebDriver driver) {
			
		this.driver = driver;
	}
	
	public void quotD() {
		
		driver.findElement(quotDet).getText();
	}

}

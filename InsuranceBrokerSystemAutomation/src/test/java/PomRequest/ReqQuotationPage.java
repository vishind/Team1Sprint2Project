package PomRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReqQuotationPage {
	WebDriver driver;
	By reqQuot = By.xpath("/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]");
	By title = By.xpath("//h2[contains(text(),'Request a quotation')]");
	 
	public ReqQuotationPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getTitle() {
        return driver.findElement(title).getText();
    }
	
	public void clickSignIn() {
	    driver.findElement(reqQuot).click();
	}

}

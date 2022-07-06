package PomRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account {
	WebDriver driver;
	By emaadd = By.xpath("/html/body/div[3]/h4");
	 
	public Account(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getemail() {
        return driver.findElement(emaadd).getText();
    }
	
	
}

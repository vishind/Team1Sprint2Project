package PomRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
	WebDriver driver;
	By register = By.linkText("Register");
	 
	public Home(WebDriver driver) {
		
		this.driver = driver;
	}
	
	 public void clickRegister(){
	        driver.findElement(register).click();
	        }

}

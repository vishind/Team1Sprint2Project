package PomRetrieve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RetriveQuotation {

WebDriver driver ;
By Retrievequotation = By.id("retrieve");
By idnumber= By.xpath("//body[1]/div[3]/div[1]/div[3]/form[1]/input[1]");
By Retrieve = By.id("getquote");

public RetriveQuotation(WebDriver driver) {
	this.driver=driver;
}
public void clickRetrievequotation() {
	driver.findElement(Retrievequotation).click();
}
public void setidnumber(String strnumber) {
	driver.findElement(idnumber).sendKeys(strnumber);
	
}
public void clickRetrieve() {
	driver.findElement(Retrieve).click();
}
public void RetriveQuotation(String strnumber) {
	this.clickRetrievequotation();
	this.setidnumber(strnumber);
	this.clickRetrieve();
}
}

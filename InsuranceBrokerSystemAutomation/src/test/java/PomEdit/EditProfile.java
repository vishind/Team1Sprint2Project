package PomEdit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfile {
	WebDriver driver;
	
	By editprofile=By.id("editprofile");
	
	By title=By.id("user_title");
    
    By surname=By.id("user_surname");
    By firstname=By.id("user_firstname");
    By phone=By.id("user_phone");
    By year=By.id("user_dateofbirth_1i");
    By month=By.id("user_dateofbirth_2i");
    By date=By.id("user_dateofbirth_3i");
    
    By licence=By.id("user_licencetype_f");
	  
    By licencePeriod=By.id("user_licenceperiod");
   
    By occupation=By.id("user_occupation_id");
    By street=By.id("user_address_attributes_street");
    By city=By.id("user_address_attributes_city");
    By country=By.id("user_address_attributes_county");
    By pincode=By.id("user_address_attributes_postcode");
    
    By update=By.name("commit");
    
    By logout=By.xpath("//body/div[3]/form[1]/input[1]");
    
   public EditProfile(WebDriver driver) {
	   this.driver=driver;
   }
   public void clickEditProfile() {
	   driver.findElement(editprofile).click();
   }
   
   public void setTitle(String strTitle) {
	   driver.findElement(title).sendKeys(strTitle);
   }
   
   public void setSurname(String strSurname) {
	   driver.findElement(surname).sendKeys(strSurname);
   }
   
   public void setFirstname(String strFirstname) {
	   driver.findElement(firstname).sendKeys(strFirstname);
   }
   
   public void setPhone(String strPhone) {
	   driver.findElement(phone).sendKeys(strPhone);
   }
   
   public void setYear(String strYear) {
	   driver.findElement(year).sendKeys(strYear);
   }
   
   public void setMonth(String strMonth) {
	   driver.findElement(month).sendKeys(strMonth);
   }
   
   public void setDate(String strDate) {
	   driver.findElement(date).sendKeys(strDate);
   }
   
   public void clickLicence() {
	   driver.findElement(licence).click();
   }
   public void setLicenceperiod(String strLicencePeriod) {
	   driver.findElement(licencePeriod).sendKeys(strLicencePeriod);
   }
   public void setOccupation(String strOccupation) {
	   driver.findElement(occupation).sendKeys(strOccupation);
   }
   public void setStreet(String strStreet) {
	   driver.findElement(street).sendKeys(strStreet);
   }
   
   public void setCity(String strCity) {
	   driver.findElement(city).sendKeys(strCity);
   }
   public void setCountry(String strCountry) {
	   driver.findElement(country).sendKeys(strCountry);
   }
   public void setPincode(String strPincode) {
	   driver.findElement(pincode).sendKeys(strPincode);
   }
    
   public void clickUpdate() {
	   driver.findElement(update).click();
   }
   public void clickLogout() {
	   driver.findElement(logout).click();
   }
    
   public void editProfile(String strTitle,String strSurname,String strFirstname,String strPhone,String strYear,String strMonth,String strDate,String strLicencePeriod,String strOccupation,String strStreet,String strCity,String strCountry,String strPincode) {
	   
	   this.clickEditProfile();
	   this.setTitle(strTitle);
	   this.setSurname(strSurname);
	   this.setFirstname(strFirstname);
	   this.setPhone(strPhone);
	   this.setYear(strYear);
	   this.setMonth(strMonth);
	   this.setDate(strDate);
	   this.clickLicence();
	   this.setLicenceperiod(strLicencePeriod);
	   this.setOccupation(strOccupation);
	   this.setStreet(strStreet);
	   this.setCity(strCity);
	   this.setCountry(strCountry);
	   this.setPincode(strPincode);
	   this.clickUpdate();
	   this.clickLogout();
	   
   }
    
   

}


	



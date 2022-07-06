package PomRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterAndLogin {
	
WebDriver driver;

    By Title = By.id("user_title");
    By FirstName = By.id("user_firstname");
    By LastName = By.id("user_surname");
    By Phone = By.id("user_phone");
    By Year = By.xpath("//*[@id=\"user_dateofbirth_1i\"]");
    By Month = By.id("user_dateofbirth_2i");
    By Date = By.id("user_dateofbirth_3i");
    By Radio= By.id("licencetype_t");
    By Occupation = By.id("user_occupation_id");
    By Street = By.id("user_address_attributes_street");
    By City = By.id("user_address_attributes_city");
    By Country = By.id("user_address_attributes_county");
    By PostCode = By.id("user_address_attributes_postcode");
    By Email = By.id("user_user_detail_attributes_email");
    By Password = By.id("user_user_detail_attributes_password");
    By PasswordConfo = By.id("user_user_detail_attributes_password_confirmation");
    By Submitt = By.name("submit");
    By Ema = By.id("email");
    By Passww = By.id("password");
    By Submit = By.name("submit");
    
    

    public RegisterAndLogin(WebDriver driver){
        this.driver = driver;
    }
    
    public void setTitle(String title){
 
    	driver.findElement(Title).sendKeys(title);
    
    }

 
    public void setFirstName(String firstname ){
    driver.findElement(FirstName).sendKeys(firstname);
    }
    
    
    public void setLastname(String lastname ){
        driver.findElement(LastName).sendKeys(lastname);
        }
    
    
    public void setPhone(String phone){
        driver.findElement(Phone).sendKeys(phone);
        }
    
    public void setYear(String year){
        driver.findElement(Year).sendKeys(year);
        }
    public void setMonth(String month)
    {
    	driver.findElement(Month).sendKeys(month);
    }
    public void setDate(String date)
    {
    	driver.findElement(Date).sendKeys(date);
    }
    
    public void ClickRadio() {
    	driver.findElement(Radio).click();
    }
    public void setOccupation(String occu)
    {
    	driver.findElement(Occupation).sendKeys(occu);
    }
    public void setStreet(String street)
    {
    	driver.findElement(Street).sendKeys(street);
    }
    public void setCity(String city)
    {
    	driver.findElement(City).sendKeys(city);
    }
    public void setCountry(String country)
    {
    	driver.findElement(Country).sendKeys(country);
    }
    public void setPostCode(String postcode)
    {
    driver.findElement(PostCode).sendKeys(postcode);	
    }
    public void setEmail(String email)
    {
    driver.findElement(Email).sendKeys(email);	
    }
    public void setPassword(String password)
    {
    driver.findElement(Password).sendKeys(password);	
    }
    
    public void setPasswordConfo(String passwordconfo)
    {
    driver.findElement(PasswordConfo).sendKeys(passwordconfo);	
    }
    
    public void ClickSubmitt()
    {
    	driver.findElement(Submitt).click();
    }
    
    public void setEma(String ema)
    {
    driver.findElement(Ema).sendKeys(ema);	
    }
    public void setPassww(String pass)
    {
    driver.findElement(Passww).sendKeys(pass);	
    }
    
    public void ClickSubmit()
    {
    	driver.findElement(Submit).click();
    }
    
    public void register(String title ,String firstname,String lastname,String phone ,String year, String month,String date,String occu,String street,String city,String country,String postcode, String email,String password,String passwordconfo)
    {
  
        this.setTitle(title);
        this.setFirstName(firstname);
        this.setLastname(lastname);
        this.setPhone(phone);
        this.setYear(year);
        this.setMonth(month);
        this.setDate(date);
        this.ClickRadio();
        this.setOccupation(occu);
        this.setStreet(street);
        this.setCity(city);
        this.setCountry(country);
        this.setPostCode(postcode);
        this.setEmail(email);
        this.setPassword(password);
        this.setPasswordConfo(passwordconfo);
        this.ClickSubmitt();
             
        }
    public void login(String ema, String passww) 
    {
    	this.setEma(ema);
    	this.setPassww(passww);
    	this.ClickSubmit();	
    }
}


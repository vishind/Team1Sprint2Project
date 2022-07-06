package PomRequest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuotationFillupPage {
	WebDriver driver;
	By BDCover=By.id("quotation_breakdowncover");
	By Radio=By.id("quotation_windscreenrepair_f");
	By Incident=By.id("quotation_incidents");
	By Reg=By.id("quotation_vehicle_attributes_registration");
	By Mileage=By.id("quotation_vehicle_attributes_mileage");
	By Value=By.id("quotation_vehicle_attributes_value");
	By Parking=By.id("quotation_vehicle_attributes_parkinglocation");
	By Year=By.id("quotation_vehicle_attributes_policystart_1i");
	By Month=By.id("quotation_vehicle_attributes_policystart_2i");
	By Date=By.id("quotation_vehicle_attributes_policystart_3i");
	By Calc=By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/form[1]/div[8]/input[1]");
	By Submitt=By.name("submit");
	
	public QuotationFillupPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void setCover(String cover) {
    	driver.findElement(BDCover).sendKeys(cover);
    }
	public void ClickRadio() {
	    driver.findElement(Radio).click();
	}
	public void setIncident(String incident) {
    	driver.findElement(Incident).sendKeys(incident);
    }
	public void setReg(String reg) {
    	driver.findElement(Reg).sendKeys(reg);
    }
	public void setMileage(String mileage) {
    	driver.findElement(Mileage).sendKeys(mileage);
    }
	public void setValue(String value) {
    	driver.findElement(Value).sendKeys(value);
    }
	public void setParking(String parking) {
    	driver.findElement(Parking).sendKeys(parking);
    }
	public void setYear(String year) {
    	driver.findElement(Year).sendKeys(year);
    }
	public void setMonth(String month) {
    	driver.findElement(Month).sendKeys(month);
    }
	public void setDate(String date) {
    	driver.findElement(Date).sendKeys(date);
    }
	public void ClickCalc() {
		driver.findElement(Calc).click();
	}
	public void ClickSubmitt() {
    	driver.findElement(Submitt).click();
    }
	
	public void quotFill(String cover, String incident, String reg, String mileage, String value, String parking, String year, String month, String date) {
		
		this.setCover(cover);
		this.setIncident(incident);
		this.setReg(reg);
		this.setMileage(mileage);
		this.setValue(value);
		this.setParking(parking);
		this.setYear(year);
		this.setMonth(month);
		this.setDate(date);
		this.ClickCalc();
		this.ClickSubmitt();
	}

}

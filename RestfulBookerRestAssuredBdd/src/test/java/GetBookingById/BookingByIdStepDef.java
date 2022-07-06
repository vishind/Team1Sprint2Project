package GetBookingById;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BookingByIdStepDef {
	private static Response response;
	@Given("^I have the base URL$")
	public void I_have_the_base_URL() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	}
	@When("^I Request For All Booking By Id$")
	public void I_Request_For_All_Booking_By_Id() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given();
		response = request.pathParam("id","258").get("/booking/{id}");
        
     
        ResponseBody body = response.getBody();
        
        System.out.println("Response Body is: " + body.asString());
        
        System.out.println("Status received => " + response.getStatusLine());
       
        System.out.println("Response=>" + response.prettyPrint());
	}
	@Then("I get All Booking")
	public void i_get_all_booking() {
		 ResponseBody body = response.getBody();
		 System.out.println("Status Code =>"+response.getStatusCode());
		 
	   Assert.assertEquals(200 ,response.getStatusCode());
	}
	

}

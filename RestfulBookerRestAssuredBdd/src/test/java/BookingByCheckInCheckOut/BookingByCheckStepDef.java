package BookingByCheckInCheckOut;



import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BookingByCheckStepDef {
	private static Response response;
	@Given("^I have the base URL$")
	public void I_have_the_base_URL() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	}
	@When("^I Request For All Booking By Check In and Check Out$")
	public void I_Request_For_All_Booking_By_Check_In_and_Check_Out() {
		 RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	     RequestSpecification request = RestAssured.given();
	    response = request.queryParam("checkin","2013-02-23").queryParam("checkout","2014-10-23").get("/booking");
	        
	}
	@Then("I get All Booking Id")
	public void i_get_all_booking_id() {
		ResponseBody body = response.getBody();
        
        System.out.println("Response Body is: " + body.asString());
        
        System.out.println("Status received => " + response.getStatusLine());
        
        System.out.println("Response=>" + response.prettyPrint());
        
        
        Headers allHeaders = response.headers();
        
        for(Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
        
        
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200 ,statusCode);
        
       // String statusLine = response.getStatusLine();
       // Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
        
	   
	}
	
}

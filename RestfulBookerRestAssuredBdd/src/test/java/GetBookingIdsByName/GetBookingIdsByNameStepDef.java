package GetBookingIdsByName;

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

public class GetBookingIdsByNameStepDef {

	private static Response response;
	
	@Given("^I have the base URL$")
	public void I_have_the_base_URL() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	}
	
	@When("^I Request For All Booking By Name$")
	public void I_Request_For_All_Booking_By_Id() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given();
		response = request.pathParam("firstname","Sally").pathParam("lastname","Brown").get("/booking?{firstname}&{lastname}");
		
	}
	
	@Then("I get all Booking IDs")
	public void I_get_all_booking_IDs() {
	   
		Assert.assertEquals(200 ,response.getStatusCode());
		
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
        
        Headers allHeaders = response.headers();
        for(Header header : allHeaders) {
        	System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
        
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/);
        
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "HTTP/1.1 200 OK");
        
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
        Assert.assertEquals(serverType /* actual value */, "Cowboy" /* expected value */);
        String acceptLanguage = response.header("Connection");
        System.out.println("Connection: " + acceptLanguage);
	}
}

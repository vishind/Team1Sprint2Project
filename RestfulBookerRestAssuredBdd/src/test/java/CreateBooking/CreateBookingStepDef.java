package CreateBooking;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateBookingStepDef {

	private static Response response;
	
	 @Given("^I have the base URL$")
	 public void I_have_the_base_URL() {
		 
		 RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	 }
	
	
	@When("^I add  a details for booking$")
	public void I_add_a_details_for_booking() {
		  RequestSpecification request = RestAssured.given();
		    request.baseUri("https://restful-booker.herokuapp.com/booking")
		                       .contentType(ContentType.JSON)
		                       .body("{\n" +
		                             "\"firstname\" : \"Jim\",\n" +
		                             "\"lastname\" : \"Brown\",\n" +
		                             "\"totalprice\" : 111,\n" +
		                             "\"depositpaid\" : true,\n" +
		                             "\"bookingdates\" : {\n" +
		                             "    \"checkin\" : \"2018-01-01\",\n" +
		                             "    \"checkout\" : \"2019-01-01\"\n" +
		                             "},\n" +
		                             "\"additionalneeds\" : \"None\"\n" +
		                             "}")
		               .when().post();
		              
		              
		 
		        response = request.post();
		       ResponseBody body = response.getBody();
	        
	        System.out.println("Response Body is: " + body.asString());
	        System.out.println("Response=>" + response.prettyPrint());
        
	        }
	@Then("^the booking is created successfully$")	
	public void the_booking_is_created_successfully() {
		Assert.assertEquals(200, response.getStatusCode());
		 System.out.println("StatusCode received => " + response.getStatusCode());
		
		  // Print the status and message body of the response received from the server
		    System.out.println("Status received => " + response.getStatusLine());
		   
		 
		     
	}
	
}

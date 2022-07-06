package UpdateBooking;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class UpdateBookingStepDef {
	
	private static Response response;
	@Given("^I have the base URL$")
	 public void I_have_the_base_URL() {
		 
		 RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	 }
	
	
	@When("^I update details for booking$")
	public void I_update_details_for_booking() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		 RequestSpecification request = RestAssured.given()
				 
		    		.auth()
		    		.preemptive()
		            .basic("admin","password123")
		            .header("Content-Type","application/json")
					
		            .header("Cookie","token=abc123");
		   
	         response = request.body("{\n" +
	                "\"firstname\" : \"Jim\",\n" +
	                "\"lastname\" : \"Brown\",\n" +
	                "\"totalprice\" : 111,\n" +
	                "\"depositpaid\" : true,\n" +
	                "\"bookingdates\" : {\n" +
	                "    \"checkin\" : \"2018-01-01\",\n" +
	                "    \"checkout\" : \"2019-01-01\"\n" +
	                "},\n" +
	                "\"additionalneeds\" : \"None\"\n" +
	                "}").pathParam("id","2587").put("/booking/{id}");
	      		
		   ResponseBody body = response.getBody();
		   
			System.out.println("Response Body is: " + body.asString());
			String statusLine = response.getStatusLine();
			System.out.println("Status Line :"+statusLine);
			
			//System.out.println("Status received => " + response.getStatusLine());
		    
	        System.out.println("Response=>" + response.prettyPrint());
	        }
	@Then("^the booking is updated successfully$")	
	public void the_booking_is_updated_successfully() {
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(200, response.getStatusCode());
		 System.out.println("StatusCode received => " + response.getStatusCode());
		
		  // Print the status and message body of the response received from the server
		    System.out.println("Status received => " + response.getStatusLine());
		   
		  
	  
	
		
	}
}

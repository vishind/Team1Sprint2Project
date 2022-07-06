package DeleteBooking;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeleteBookingStepDef {

	private static Response response;
	@Given("^I have the base URL$")
	public void I_have_the_base_URL()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	   
	}
	@When("I delete a user")
	public void i_delete_a_user() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given()
	            .auth()
	            .preemptive()
	            .basic("admin", "password123")
	            .header("Content-Type", "application/json")
	            .header("Cookie","token=abc123");
	   
	 response = request.pathParam("id","16").delete("/booking/{id}");
	    
	}    
	   
	@Then("The user gets deleted")
	public void  The_user_gets_deleted() {
		ResponseBody body = response.getBody();
		   System.out.println("Response Body is: " + body.asString());
		Assert.assertEquals(201, response.getStatusCode());
		 System.out.println("StatusCode received => " + response.getStatusCode());
		
		  // Print the status and message body of the response received from the server
		    System.out.println("Status received => " + response.getStatusLine());
	        
	}
	
}

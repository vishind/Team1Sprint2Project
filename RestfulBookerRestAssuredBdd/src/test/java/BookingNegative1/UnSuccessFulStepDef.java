package BookingNegative1;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UnSuccessFulStepDef {

	private static Response response;
	@Given("^I have the base URL$")
	public void I_have_the_base_URL()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	   
	}
	@When("^Update a user with invalid id$")
	public void Update_a_user_with_invalid_id()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";	
	 RequestSpecification request = RestAssured.given()
			    .auth()
				.preemptive()
		        .basic("admin", "password123")
		        .header("Content-Type", "application/json")
			     .header("Cookie","token=abc123");
		
	     response = request.pathParam("id","biju89").get("/booking/{id}");
	    
	    
	}
	
	@Then("^I get invalid response$")
	public void I_get_invalid_response() {
		
		Assert.assertEquals(404, response.getStatusCode());
	    System.out.println("Status received => " + response.getStatusLine());
	    
	   
	}
}

package PingNegative;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class HealthCheckUnSuccessfulStepDef {



	private static Response response;
	@Given("^I have the base URL$")
	public void I_have_the_base_URL()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given();
	}
	@When("I Create a Healthcheck")
	public void I_Create_a_Healthcheck() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given();
	     response = request.post("/ping");
	
	}
	
	@Then("The Healthcheck is not found")
	public void The_Healthcheck_is_not_found() {
		ResponseBody body = response.getBody();	
		   System.out.println("Response Body is: " + body.asString());
		   System.out.println("Response=>" + response.prettyPrint());
				
		int statusCode = response.getStatusCode();

		Assert.assertEquals(415, response.getStatusCode());
		 System.out.println("StatusCode received => " + response.getStatusCode());
		
		  // Print the status and message body of the response received from the server
		    System.out.println("Status received => " + response.getStatusLine());
		   		    		
	}
		
}

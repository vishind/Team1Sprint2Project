package UpdatefirstName;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class updateFirstNameStepDef {


	private static Response response;
	@Given("^I have the base URL$")
	public void I_have_the_base_URL()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	   
	}
	@When("^Update a user detail$")
	public void Update_a_user_detail()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		 RequestSpecification request = RestAssured.given()
	    .auth()
		.preemptive()
        .basic("admin", "password123")
        .header("Content-Type", "application/json")
	     .header("Cookie","token=abc123");
		
		

response = request.body("{\"firstname\": \"biju\",\"lastname\": \"panno\"}").pathParam("id","678").patch("/booking/{id}");
		

 ResponseBody body = response.getBody();
 
 System.out.println("Response Body is: " + body.asString());
 
 System.out.println("Status received => " + response.getStatusLine());
 System.out.println("Response=>" + response.prettyPrint());

	}

@Then("^The user details get updated$")
public void The_user_details_get_updated() {
	Assert.assertEquals(200, response.getStatusCode());
	 System.out.println("StatusCode received => " + response.getStatusCode());
	 
	    System.out.println("Status received => " + response.getStatusLine());

		
	
}
}
		

	



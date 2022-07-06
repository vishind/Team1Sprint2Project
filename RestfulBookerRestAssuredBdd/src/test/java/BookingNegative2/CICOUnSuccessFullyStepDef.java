package BookingNegative2;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CICOUnSuccessFullyStepDef {

	
	private static Response response;
	
	 @Given("^I have the base URL$")
	 public void I_have_the_base_URL() {
		 
		 RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	 }
	
	
	@When("^I add  checkin and checkout for getting id$")
	public void I_add_checkin_and_checkout_for_getting_id() {
		
		 RequestSpecification request = RestAssured.given();
		    request.baseUri("https://restful-booker.herokuapp.com/booking")
		                       .contentType(ContentType.JSON)
		                       .body("{\n" +
			                             "\"firstname\" : \"0000\",\n" +
			                             "\"lastname\" : \"$&*@\",\n" +
			                             "\"totalprice\" : 111,\n" +
			                             "\"depositpaid\" : true,\n" +
			                             "\"bookingdates\" : {\n" +
			                             "    \"checkin\" : \"mnbvvc\",\n" +
			                             "    \"checkout\" : \"nbgytgf\"\n" +
			                             "},\n" +
			                             "\"additionalneeds\" : \"None\"\n" +
			                             "}")
		               .when().post();
		                response = request.post();
		                ResponseBody body = response.getBody();
		                System.out.println("Response Body is: " + body.asString());   
		      }
		@Then("^I got invalid date$")
	public void I_got_invalid_date() {
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println("StatusCode received => " + response.getStatusCode());
		
		  // Print the status and message body of the response received from the server
		    System.out.println("Status received => " + response.getStatusLine());
		   
	}
}


package BookerNegative;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetBookingIdUnsuccessfully {
	@Test
	public void getBookingId() {
	RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    
    RequestSpecification request = RestAssured.given();
    Response response = request.pathParam("id","biju8765").get("/booking/{id}");
    
    
    ResponseBody body = response.getBody();
    
    System.out.println("Response Body is: " + body.asString());
    
    System.out.println("Status received => " + response.getStatusLine());
    
    System.out.println("Response=>" + response.prettyPrint());
    
   
	}
	

}

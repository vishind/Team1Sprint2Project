package PingNegative;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class HealthCheckUnsuccessful {
	@Test
	public void Healthcheck () {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given();
		Response response = request.post("/ping");
		ResponseBody body = response.getBody();
		
		ResponseBody body1 = response.getBody();
		System.out.println("Response Body is: " + body1.asString());
	    // Print the status and message body of the response received from the server

		
	    System.out.println("Status received => " + response.getStatusLine());
	    // Print the status and message body of the response received from the server
	    
	    System.out.println("Status code received => " + response.getStatusCode());
	       
	   int statusCode = response.getStatusCode();
	    Assert.assertEquals(statusCode /*actual value*/, 415 /*expected value*/, "Created");

	    //Assert Status line
	    String statusLine = response.getStatusLine();
	    Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 415 Unsupported Media Type" /*expected value*/, "Not Found");
	    
	    
	    
	}

}

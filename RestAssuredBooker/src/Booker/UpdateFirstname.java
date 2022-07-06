package Booker;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class UpdateFirstname {

	@Test
	public void UpdateNewUserPartially() {
			
			RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	
		    RequestSpecification request = RestAssured.given()
		    		.auth()
		    		.preemptive()
		            .basic("admin", "password123")
		            .header("Content-Type", "application/json")
				    .header("Cookie","token=abc123");
		    		
		    Response res = request.body("{\"firstname\": \"shri\",\"lastname\": \"panno\"}").pathParam("id","678").patch("/booking/{id}");
	       ResponseBody body = res.getBody();
		    System.out.println("Response Body is: " + body.asString());	
		   
		    String statusLine = res.getStatusLine();
			System.out.println("Status Line :"+statusLine);
			
			Headers allHeaders = res.headers();
	       for(Header header : allHeaders) {
	        	System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
	        }
	        
	       
	        int statusCode = res.getStatusCode();
	        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Successful");

	       
	       
	        String contentType = res.header("Content-Type");
	        System.out.println("Content-Type value: " + contentType);
	        Assert.assertEquals(contentType /*actual value*/, "application/json; charset=utf-8" /*expected value*/);
	      
	        
	      
	        String acceptLanguage = res.header("Content-Encoding");
	        System.out.println("Content-Encoding: " + acceptLanguage);
	        
	           
			
			

			
	}
}




			

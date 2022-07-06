package Booker;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeleteBooking 
{
		@Test
		public void deleteuser() {
			
			RestAssured.baseURI = "https://restful-booker.herokuapp.com";
			RequestSpecification request = RestAssured.given()
		            .auth()
		            .preemptive()
		            .basic("admin", "password123")
		            .header("Content-Type", "application/json")
		            .header("Cookie","token=abc123");
		   
		   Response response = request.pathParam("id","1100").delete("/booking/{id}");
		    
		    
		   ResponseBody body = response.getBody();
		   System.out.println("Response Body is: " + body.asString());
	       String statusLine = response.getStatusLine();
	       Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 201 Created" /*expected value*/, "Correct status code returned");
	       System.out.println("Status received => " + response.getStatusLine());
	       
	       Headers allHeaders = response.headers();
	       for(Header header : allHeaders) {
	        	System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
	        }
	        
	       String contentType = response.header("Content-Type");
	        System.out.println("Content-Type value: " + contentType);
	        Assert.assertEquals(contentType /*actual value*/, "application/json; charset=utf-8" /*expected value*/);
	     		
}	
	}



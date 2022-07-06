package BookerNegative;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetBookingIdsByCheckInAndCheckOutDatesUnsuccessfully {
	@Test
	public void getBookingId() {
		
		 RequestSpecification request = RestAssured.given();
		    request.baseUri("https://restful-booker.herokuapp.com")
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
		                             "}");		              
		    Response response = request.post("/booking");
		    ResponseBody body = response.getBody();
	        System.out.println("Response Body is: " + body.asString());
	        System.out.println("Status received => " + response.getStatusLine());
	    
	       
	    
	}
        
   

}

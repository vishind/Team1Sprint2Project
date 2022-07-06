package Booker;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateBooking {

	@Test
	public void createNewBooking() {
		   RequestSpecification request = RestAssured.given();
	    request.baseUri("https://restful-booker.herokuapp.com/booking")
	                       .contentType(ContentType.JSON)
	                       .body("{\n" +
	                             "\"firstname\" : \"Jim\",\n" +
	                             "\"lastname\" : \"Brown\",\n" +
	                             "\"totalprice\" : 111,\n" +
	                             "\"depositpaid\" : true,\n" +
	                             "\"bookingdates\" : {\n" +
	                             "    \"checkin\" : \"2018-01-01\",\n" +
	                             "    \"checkout\" : \"2019-01-01\"\n" +
	                             "},\n" +
	                             "\"additionalneeds\" : \"None\"\n" +
	                             "}")
	               .when().post()
	               .then().statusCode(200);
	 
	    Response response = request.post();
	      
        
	       
        ResponseBody body = response.getBody();
        
        System.out.println("Response Body is: " + body.asString());
        
        System.out.println("Status received => " + response.getStatusLine());
    
        System.out.println("Response=>" + response.prettyPrint());
        
      
	    
	    
	    
	    
	    
	}

	}

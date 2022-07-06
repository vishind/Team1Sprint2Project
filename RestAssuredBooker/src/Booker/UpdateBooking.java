package Booker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

	
public class UpdateBooking {


@Test
	public void Update() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
	    RequestSpecification request = RestAssured.given()
	    		.auth()
	    		.preemptive()
	            .basic("admin","password123")
	            .header("Content-Type","application/json")
				
	            .header("Cookie","token=abc123");
	   
        Response res = request.body("{\n" +
                "\"firstname\" : \"Jim\",\n" +
                "\"lastname\" : \"Brown\",\n" +
                "\"totalprice\" : 111,\n" +
                "\"depositpaid\" : true,\n" +
                "\"bookingdates\" : {\n" +
                "    \"checkin\" : \"2018-01-01\",\n" +
                "    \"checkout\" : \"2019-01-01\"\n" +
                "},\n" +
                "\"additionalneeds\" : \"None\"\n" +
                "}").pathParam("id","3053").put("/booking/{id}");
      		
	   ResponseBody body = res.getBody();
	   
		System.out.println("Response Body is: " + body.asString());
		String statusLine = res.getStatusLine();
		System.out.println("Status Line :"+statusLine);
		
		
	    
        System.out.println("Response=>" + res.prettyPrint());
        

		
}
}
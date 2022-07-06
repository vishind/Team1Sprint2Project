package FinalBookerMerge;

import java.util.List;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BookerStepDef {
private static Response response;
	
	@Given("^I have the base URL$")
	public void I_have_the_base_URL() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	}
	
	@When("^I fill credentials$")
	public void I_fill_credentials(DataTable dt) {
		
		List<String> list = dt.transpose().asList(String.class);
    	
        String username = dt.cell(0,0);
        String password = dt.cell(0,1);
        
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RequestSpecification request = RestAssured.given()
        	.header("Content-Type", "application/json");
        
        response = request.body("{\"username\":\"" + username +"\", \"password\":\"" + password +"\"}").post("/auth");
		
        System.out.println("username - " + list.get(0));
	    System.out.println("password - " + list.get(1));
	    
	}
	
	@Then("^Token is generated$")
	public void Token_is_generated() {
		
		Assert.assertEquals(200,response.getStatusCode());
		System.out.println("Standard Response => " +response.getStatusCode());
		
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
        
        Headers allHeaders = response.headers();
        for(Header header : allHeaders) {
        	System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
        
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/);
        
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "HTTP/1.1 200 OK");
        
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
        Assert.assertEquals(serverType /* actual value */, "Cowboy" /* expected value */);
        String acceptLanguage = response.header("Connection");
        System.out.println("Connection: " + acceptLanguage);
	}
	
	
	
	@When("^I Request For All Booking By Name$")
	public void I_Request_For_All_Booking_By_Name() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given();
		response = request.pathParam("firstname","Sally").pathParam("lastname","Brown").get("/booking?{firstname}&{lastname}");
		
	}
	
	@Then("I get all Booking IDs")
	public void I_get_all_booking_IDs() {
	   
		Assert.assertEquals(200 ,response.getStatusCode());
		
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
        
        Headers allHeaders = response.headers();
        for(Header header : allHeaders) {
        	System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
        
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/);
        
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "HTTP/1.1 200 OK");
        
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
        Assert.assertEquals(serverType /* actual value */, "Cowboy" /* expected value */);
        String acceptLanguage = response.header("Connection");
        System.out.println("Connection: " + acceptLanguage);
	}

	
	@When("^I Request For All Booking By Check In and Check Out$")
	public void I_Request_For_All_Booking_By_Check_In_and_Check_Out() {
		 RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	     RequestSpecification request = RestAssured.given();
	    response = request.queryParam("checkin","2013-02-23").queryParam("checkout","2014-10-23").get("/booking");
	        
	}
	@Then("I get All Booking Id")
	public void i_get_all_booking_id() {
		ResponseBody body = response.getBody();
        
        System.out.println("Response Body is: " + body.asString());
        
        System.out.println("Status received => " + response.getStatusLine());
        
        System.out.println("Response=>" + response.prettyPrint());
        
        
        Headers allHeaders = response.headers();
        
        for(Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
        
        
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200 ,statusCode);
        
       // String statusLine = response.getStatusLine();
       // Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
        
	   
	}
	@When("^I Request For All Booking By Id$")
	public void I_Request_For_All_Booking_By_Id() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given();
		response = request.pathParam("id","258").get("/booking/{id}");
        
     
        ResponseBody body = response.getBody();
        
        System.out.println("Response Body is: " + body.asString());
        
        System.out.println("Status received => " + response.getStatusLine());
       
        System.out.println("Response=>" + response.prettyPrint());
	}
	@Then("I get All Booking")
	public void i_get_all_booking() {
		 ResponseBody body = response.getBody();
		 System.out.println("Status Code =>"+response.getStatusCode());
		 
	   Assert.assertEquals(200 ,response.getStatusCode());
	}
	@When("^I add  a details for booking$")
	public void I_add_a_details_for_booking() {
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
		               .when().post();
		              
		              
		 
		        response = request.post();
		       ResponseBody body = response.getBody();
	        
	        System.out.println("Response Body is: " + body.asString());
	        System.out.println("Response=>" + response.prettyPrint());
        
	        }
	@Then("^the booking is created successfully$")	
	public void the_booking_is_created_successfully() {
		Assert.assertEquals(200, response.getStatusCode());
		 System.out.println("StatusCode received => " + response.getStatusCode());
		
		  // Print the status and message body of the response received from the server
		    System.out.println("Status received => " + response.getStatusLine());
		   
		 
		     
	}
	@When("^I update details for booking$")
	public void I_update_details_for_booking() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		 RequestSpecification request = RestAssured.given()
				 
		    		.auth()
		    		.preemptive()
		            .basic("admin","password123")
		            .header("Content-Type","application/json")
					
		            .header("Cookie","token=abc123");
		   
	         response = request.body("{\n" +
	                "\"firstname\" : \"Jim\",\n" +
	                "\"lastname\" : \"Brown\",\n" +
	                "\"totalprice\" : 111,\n" +
	                "\"depositpaid\" : true,\n" +
	                "\"bookingdates\" : {\n" +
	                "    \"checkin\" : \"2018-01-01\",\n" +
	                "    \"checkout\" : \"2019-01-01\"\n" +
	                "},\n" +
	                "\"additionalneeds\" : \"None\"\n" +
	                "}").pathParam("id","2587").put("/booking/{id}");
	      		
		   ResponseBody body = response.getBody();
		   
			System.out.println("Response Body is: " + body.asString());
			String statusLine = response.getStatusLine();
			System.out.println("Status Line :"+statusLine);
			
			//System.out.println("Status received => " + response.getStatusLine());
		    
	        System.out.println("Response=>" + response.prettyPrint());
	        }
	@Then("^the booking is updated successfully$")	
	public void the_booking_is_updated_successfully() {
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(200, response.getStatusCode());
		 System.out.println("StatusCode received => " + response.getStatusCode());
		
		  // Print the status and message body of the response received from the server
		    System.out.println("Status received => " + response.getStatusLine());
		  
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
@When("I delete a user")
public void i_delete_a_user() {
	RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	RequestSpecification request = RestAssured.given()
            .auth()
            .preemptive()
            .basic("admin", "password123")
            .header("Content-Type", "application/json")
            .header("Cookie","token=abc123");
   
 response = request.pathParam("id","69").delete("/booking/{id}");
    
}    
   
@Then("The user gets deleted")
public void  The_user_gets_deleted() {
	ResponseBody body = response.getBody();
	   System.out.println("Response Body is: " + body.asString());
	Assert.assertEquals(201, response.getStatusCode());
	 System.out.println("StatusCode received => " + response.getStatusCode());
	
	  // Print the status and message body of the response received from the server
	    System.out.println("Status received => " + response.getStatusLine());
        
}


@When("I Create a Healthcheck")
public void I_Create_a_Healthcheck() {
	RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	RequestSpecification request = RestAssured.given();
     response = request.get("/ping");

}    		

@Then("The Healthcheck is Created")
public void  The_Healthcheck_is_Created() {
	ResponseBody body = response.getBody();	
	   System.out.println("Response Body is: " + body.asString());
	   System.out.println("Response=>" + response.prettyPrint());
		
	int statusCode = response.getStatusCode();
	Assert.assertEquals(201, statusCode);
	 System.out.println("StatusCode received => " + response.getStatusCode());
	
	  // Print the status and message body of the response received from the server
	    System.out.println("Status received => " + response.getStatusLine());
}


}

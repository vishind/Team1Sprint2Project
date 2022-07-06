package DataUpdateFirstName;

import java.util.List;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class DataUpdateFirstNameStepDef {

private static Response response;
	
	@Given("^I have the base URL$")
	public void I_have_the_base_URL() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
	}
	
	@When("^Update a user detail$")
	public void Update_a_user_detail(DataTable dt) {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		 RequestSpecification request = RestAssured.given()
	    .auth()
		.preemptive()
       .basic("admin", "password123")
       .header("Content-Type", "application/json")
	     .header("Cookie","token=abc123");
		
		
		
	    		
	    	List<String> list = dt.transpose().asList(String.class);
	    	
	       	  String firstname = dt.cell(0,0);
	          String lastname = dt.cell(0,1);
	         
	        
	       
	          response = request.body("{\"firstname\":\"" + firstname +"\", \"lastname\":\"" + lastname +"\"}").pathParam("id","678").patch("/booking/{id}");
	       
	        
	       
	            System.out.println("Response=>" + response.prettyPrint());
	            System.out.println("firstname - " + list.get(0));
			       
	            System.out.println("lastname - " + list.get(1));
		        
		       
	        
	    }
	
	@Then("^The user details get updated$")
	public void The_user_details_get_updated() {
		
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(200, response.getStatusCode());
		 System.out.println("StatusCode received => " + response.getStatusCode());
		
		  // Print the status and message body of the response received from the server
		    System.out.println("Status received => " + response.getStatusLine());
		   
		  
	}
}

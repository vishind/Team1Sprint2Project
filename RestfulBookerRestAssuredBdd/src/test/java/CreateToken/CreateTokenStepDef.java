package CreateToken;

import java.util.List;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateTokenStepDef {


	private static Response response;
	
	@Given("^I have the base URL$")
	public void I_have_the_base_URL() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given();
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
}

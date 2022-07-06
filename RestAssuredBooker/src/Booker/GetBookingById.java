package Booker;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetBookingById {
	@Test
	public void getUserById() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        
        RequestSpecification request = RestAssured.given();
        Response response = request.pathParam("id","258").get("/booking/{id}");
        
     
        ResponseBody body = response.getBody();
        
        System.out.println("Response Body is: " + body.asString());
        
        System.out.println("Status received => " + response.getStatusLine());
       
        System.out.println("Response=>" + response.prettyPrint());
        
       
        Headers allHeaders = response.headers();
       
        for(Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
        
        
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Successful");
        
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
        
        
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);
        
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
        Assert.assertEquals(serverType /* actual value */, "Cowboy" /* expected value */);
        
       long resTime =  response.getTime();
       System.out.println("Response Time : "+resTime);
        
       
	}
}
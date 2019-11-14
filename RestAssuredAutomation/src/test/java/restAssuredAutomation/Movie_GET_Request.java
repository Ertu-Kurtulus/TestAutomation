package restAssuredAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Movie_GET_Request {

	
	@Test(priority = 1)
	void getCheckServerStatus() 
	{
		
		System.out.println("Server Status Testing");
		
		//Base URI
		RestAssured.baseURI="http://www.omdbapi.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/?apikey=204af6a1&s=Harry Potter");
		
		
		
		//Print Response on console window
		
		String ResponseBody=response.getBody().asString();
		System.out.println("Response body is : " + ResponseBody);
		
		//Status Code Verification
		int statusCode=response.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode , 200);

		//Status Line Verification
		String statusLine=response.getStatusLine();
		System.out.println("Status line is : " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		

		
		
		
	}
}

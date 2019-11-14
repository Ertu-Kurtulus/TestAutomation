package restAssuredAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Movie_GET_MovieDetailsWithID {

	@Test(priority = 3)
	public void GetMovieDetailsWithID()
	{
	System.out.println("Searching with ID and Testing Results");
		
	//Base URI
	RestAssured.baseURI="http://www.omdbapi.com";
	
	//Request Object
	RequestSpecification httpRequest = RestAssured.given();
	
	//Response Object
	Response response = httpRequest.request(Method.GET,"/?apikey=204af6a1&i=tt0241527");
	
	//Print Response on console window
	
	String ResponseBody=response.getBody().asString();
	System.out.println("Response body is : " + ResponseBody);
	
	//JsonPath Object
	JsonPath jsonpath = response.jsonPath();
	
	System.out.println("Movie title is : " + jsonpath.get("Title"));
	System.out.println("Movie year is :" + jsonpath.get("Year"));
	System.out.println("Movie released date is :" + jsonpath.get("Released"));
	
	Assert.assertEquals(jsonpath.get("Title"), "Harry Potter and the Sorcerer's Stone");
	Assert.assertEquals(jsonpath.get("Year"), "2001");
	Assert.assertEquals(jsonpath.get("Released"), "16 Nov 2001");

	
	
	}
}

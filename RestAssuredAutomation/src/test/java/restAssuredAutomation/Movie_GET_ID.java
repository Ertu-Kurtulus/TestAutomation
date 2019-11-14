package restAssuredAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Movie_GET_ID {

		@Test(priority = 2)
		public void GetMovieID()
		{
			System.out.println("Getting Movie ID and Testing");
			
			//Base URI
			RestAssured.baseURI="http://www.omdbapi.com";
			
			//Request Object
			RequestSpecification httpRequest = RestAssured.given();
			
			//Response Object
			Response response = httpRequest.request(Method.GET,"/?apikey=204af6a1&s=Harry Potter");
			
			//Print Response on console window
			
			String ResponseBody=response.getBody().asString();
			System.out.println("Response body is : " + ResponseBody);
			
			JsonPath jsonpath = response.jsonPath();
			
			System.out.println("Movie title is : " + jsonpath.get("Search.Title[1]"));
			System.out.println("Movie ID is :" + jsonpath.get("Search.imdbID[1]"));
			
			
			//Movie name and id validation
			Assert.assertEquals(jsonpath.get("Search.Title[1]"), "Harry Potter and the Sorcerer's Stone");

			Assert.assertEquals(jsonpath.get("Search.imdbID[1]") , "tt0241527");

			
			


}
		}

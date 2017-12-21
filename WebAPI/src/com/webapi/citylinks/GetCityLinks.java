package com.webapi.citylinks;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;






	@Test
public class GetCityLinks {
		
		
			
		public void GetAllCityLinksByMetroName()
		{
			// Specify the base URL to the RESTful web service
			RestAssured.baseURI = "https://helium.forrent.com/apis/web";
			//RestAssured.basePath = "/all-city-links/";
			
			// Get the RequestSpecification of the request that you want to sent
			// to the server. The server is specified by the BaseURI that we have
			// specified in the above step.
			RequestSpecification httpRequest = RestAssured.given();
			
			// Make a GET request call directly by using RequestSpecification.get() method.
			// Make sure you specify the resource name.
			Response response = httpRequest.get("/all-city-links/byMetro?metroName=Philadelphia&state=PA");
			
	 
			// Get the status code from the Response. In case of 
			// a successful interaction with the web service, we
			// should get a status code of 200.
			
			// Response.asString method will directly return the content of the body
			// as String.
			System.out.println("Response Body is =>  " + response.asString());
			int statusCode = response.getStatusCode();
	 
			// Get the status line from the Response and store it in a variable called statusLine
			String StatusLine = response.getStatusLine();
			Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
			
			// Reader header of a give name. In this line we will get
			// Header named Content-Type
			String contentType = response.header("Content-Type");
			Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);
			
			// Reader header of a give name. In this line we will get
			// Header named Server
			String serverType =  response.header("Server");
			Assert.assertEquals(serverType /* actual value */, "nginx/1.12.2" /* expected value */);
			
			
			// Read header of a give name. In this line we will get
			// Header named Content-Encoding
			//String contentEncoding = response.header("Content-Encoding");
			//Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);
			
			// Retrieve the body of the Response
			ResponseBody body = response.getBody();
	
			
			// By using the ResponseBody.asString() method, we can convert the  body
			// into the string representation.
			System.out.println("Response Body is: " + body.asString());
			
			// First get the JsonPath object instance from the Response interface
			JsonPath jsonPathEvaluator = response.jsonPath(); 
			
			// Let us print the name variable to see what we got
			System.out.println("name received from Response " + jsonPathEvaluator.get("name"));
			
			// Let us print the findUri variable to see what we got
			System.out.println("findUri received from Response " + jsonPathEvaluator.get("findUri"));
			
			// Let us print the hasPaidProperties variable to see what we got
			System.out.println("hasPaidProperties received from Response " + jsonPathEvaluator.get("hasPaidProperties"));
			
		
		}	
			
}
	



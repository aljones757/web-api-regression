package com.webapi.citylinks;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static com.jayway.restassured.RestAssured.given;





public class ValidateResponse {
	@Test(dataProvider ="cityLocations")
	public void AllCityLinksResponseTest(final String metro, final String state) {
		//System.out.println("metro '" + state );
		
		final String body = 
			
		// Specify the base URL to the RESTful web service
					RestAssured.baseURI = "https://helium.forrent.com/apis/web";
					//RestAssured.basePath = "/all-city-links/";
					
					// Get the RequestSpecification of the request that you want to sent
					// to the server. The server is specified by the BaseURI that we have
					// specified in the above step.
					RequestSpecification httpRequest = RestAssured.given();
					
					// Make a GET request call directly by using RequestSpecification.get() method.
					// Make sure you specify the resource name.
					Response response = httpRequest.get("/all-city-links/byMetro?metroName={metro}&{state}");
	}

	@DataProvider(name = "cityLinks")
	public String[][] createCitylinkTestData() {
		return new String[][]{
			{"Philadelphia", "PA"}
			, {"Norfolk", "VA"}
		}
	}
}

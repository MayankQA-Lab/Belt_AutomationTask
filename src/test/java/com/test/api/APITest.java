package com.test.api;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.pages.LoginPage;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITest {
	Response httpResponse;
	RequestSpecification httpRequest;
	String statusLine="HTTP/1.1 200 OK";
	String contentType="application/json";
	
	
	@BeforeMethod
	public void setup() throws IOException {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";	
		httpRequest = RestAssured.given();	
	}

	@Test(priority = 0,description = "Verify GET api response for valid Status")
	public void TC_01_GetListOfPetsWithValidStatus() {		
		httpResponse = httpRequest.request(Method.GET, "pet/findByStatus?status=available");
		String responseBody = httpResponse.getBody().asString();
		List<String> resIDs = httpResponse.jsonPath().get("id");
		Assert.assertTrue(httpResponse.getTime() < 10000);
		Assert.assertEquals(httpResponse.getStatusCode(), 200);
		Assert.assertEquals(httpResponse.getStatusLine().trim(), statusLine.trim());
		Assert.assertEquals(httpResponse.getContentType().trim(),contentType.trim());
		Assert.assertTrue(resIDs.size() > 0);
	}

	@Test(priority = 1,description =  "Verify GET api response for invalid Status")
	public void TC_02_GetListOfPetsWithInvalidStatus() {		
	    httpResponse = httpRequest.request(Method.GET, "pet/findByStatus?status=invalid");
	    String responseBody = httpResponse.getBody().asString();
		List<String> resIDs = httpResponse.jsonPath().get("id");
		Assert.assertTrue(httpResponse.getTime() < 10000);
		Assert.assertEquals(httpResponse.getStatusCode(), 200);
		Assert.assertEquals(httpResponse.getStatusLine().trim(), statusLine.trim());
		Assert.assertEquals(httpResponse.getContentType().trim(),contentType.trim());
		Assert.assertTrue(resIDs.size()== 0);
	}
}

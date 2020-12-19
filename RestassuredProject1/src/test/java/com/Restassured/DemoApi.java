package com.Restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

public class DemoApi {
	
	
	//@Test
	public void get()
	{
		Response re=
				given()
					.when()
						.get("https://reqres.in/api/users?page=2")
						  .then()
						  	.statusCode(200)
						  		.extract().response();
		String responsebody= re.asString();
		System.out.println("response body is"+ responsebody);
		int statuscode=re.getStatusCode();
		System.out.println("staus code is"+ statuscode);		  	
		Assert.assertEquals(statuscode, 200);
		String statusline=re.getStatusLine();
		System.out.println("stausline is"+ statusline);
		Assert.assertEquals("HTTP/1.1 200 OK", "HTTP/1.1 200 OK");
	}
	
	@Test
	public void post()
	{
		
					HashMap data = new HashMap();
					
					data.put("email", "mahajan1020@gmail.com");
					data.put("password", "sagar");
					
					//Response res=
							given()
								.contentType("applicati/json")
									.body(data)
									.when()
										.post("https://reqres.in/api/register")
										.then()
										.statusCode(201)
										.log().body();
										//.extract().response();
				
					
					
						  
		
		
		
	}
	

}

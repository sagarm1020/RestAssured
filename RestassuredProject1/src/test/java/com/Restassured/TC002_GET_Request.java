package com.Restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

public class TC002_GET_Request {
	
	
	//@Test
	public void getrequest()
	{
		Response res=
		given()
		  .when()
		    .get("https://reqres.in/api/users?page=2")
				
				.then()
					.statusCode(200)
							.extract().response();
		String responsebody=res.asString();
		System.out.println(responsebody);
		int statuscode=res.statusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
		
	}
	
	@Test
	public void postrequest() {
		
		HashMap data =new HashMap();
		
		data.put("email", "mahajan1020@gmail.com");
		data.put("password", "sagar");
		
	Response respon=
				given()
					.contentType("application/json")
					.body(data)
						.when()
							.post("https://reqres.in/api/register")
								.then()
									.log().body()
									.extract().response();
				
					
		
		
		
		
	}

}

package com.Restassured;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;

public class TC004_Restassured {
	
	
	@Test
	public void getrequest()
	{
		Response res=
				given()
				.when()
					.get("https://reqres.in/api/users/2")
						.then()
						 .statusCode(200)
						 .extract().response();
	int statuscode=	res.statusCode();
	System.out.println("Staus code is:"+statuscode);
	Assert.assertEquals(statuscode, 200);
	String statusline=res.statusLine();
	System.out.println("Stausline is:"+statusline);
		
		
	}
	
	
	
	

}

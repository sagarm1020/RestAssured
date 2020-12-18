package com.Restassured;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;

public class TC003_GET_Request {
	
	@Test
	public void getrequest()
	{
		Response res=
		given()
			.when()
				.get("https://reqres.in/api/users?page=2")
					.then()
						.statusCode(200)
							.extract().response();
						int statuscode=res.statusCode();
						System.out.println("status code is:"+ statuscode);
						Assert.assertEquals(statuscode, 200);
						String statuline =res.statusLine();
						System.out.println("Statusline is:" +statuline);
						String responsebody=res.asString();
						System.out.println("Body is:"+ responsebody );
	
		
	}

}

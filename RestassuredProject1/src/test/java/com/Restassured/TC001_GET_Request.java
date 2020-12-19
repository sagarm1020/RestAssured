package com.Restassured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class TC001_GET_Request {

	//@Test 
	public void getrequest() {
		
		
		Response res=
		given()
		
			.when()
			
				.get("https://reqres.in/api/users/2")
				
					.then()
					
						.statusCode(200)
						.extract().response();
		String jsonformat= res.asString();
		System.out.println(jsonformat);
		 int satuscode= res.getStatusCode();
		 System.out.println(satuscode);
		 Assert.assertEquals(satuscode, 200);
		 String statusline=res.getStatusLine();
		 System.out.println(statusline);
		 Assert.assertEquals(statusline.contains("HTTP/1.1 200 OK"), true);
	
	}
	
	//@Test
	public void createdata()
	{
		HashMap data = new HashMap();
		
		data.put("name", "sagar");
		data.put("job", "latur");
		data.put("id", "100");
		
		Response respons=
			given()
				.contentType("application/json")
				.body(data)
				
				.when()
					.post("https://reqres.in/api/users")
					
						.then()
						.statusCode(201)
						.log().body()
						.extract().response();
			String statusline= respons.getStatusLine();
			
		
	}
	
	
			
	}
	
	


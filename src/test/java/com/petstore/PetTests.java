package com.petstore;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.petstore.payloads.PetPayload;
import com.petstore.utility.Constants;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PetTests {
	String response;
	
	@Test(priority=1)
	public void  addNewPet() {
		 response =given().log().all().header("Content-Type","application/json")
				.body(PetPayload.pets())
				.when().post(Constants.PET_ENDPOINT)
				.then().log().all().assertThat().statusCode(200).
				extract().response().asString();	
		System.out.println(response);        
    }
	
	@Test(priority=2)
	public void updatePet() {
		String response = given().log().all().header("Content-Type","application/json")
                .body(PetPayload.pets())
                .put(Constants.PET_ENDPOINT)
            	.then().log().all().assertThat().statusCode(200).
				extract().response().asString();
		System.out.println(response);      
    }

	@Test(priority=3)
	public void deletePet() {
//		JsonPath js = new JsonPath(response); // for Parsing json
//		String id = js.get("id");
//		System.out.println(id);
		String response = given().log().all().header("Content-Type","application/json")
                .delete(Constants.PET_ENDPOINT +"/3")
            	.then().log().all().assertThat().statusCode(200).
				extract().response().asString();
		System.out.println(response);    
    }
}

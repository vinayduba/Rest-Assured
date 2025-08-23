package com.vinay.qa.Rest_Assured_Framework;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class RAPostAPITest {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.3834911111,\r\n"
				+ "        \"lng\": 33.427361\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 5551,\r\n"
				+ "    \"name\": \"Frontline house\",\r\n"
				+ "    \"phone_number\": \"(+91) 983 893 3940\",\r\n"
				+ "    \"address\": \"29, side layout, cohen 10\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"Fruit Shop\",\r\n"
				+ "        \"shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"https://rahulshettyacademy.com\",\r\n"
				+ "    \"language\": \"French-IN\"\r\n"
				+ "}")
		.when().post("maps/api/place/add/json/")
		.then().log().all().assertThat().statusCode(200);
	}

}

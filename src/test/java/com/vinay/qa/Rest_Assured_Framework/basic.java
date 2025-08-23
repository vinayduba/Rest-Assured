package com.vinay.qa.Rest_Assured_Framework;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class basic {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383492,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 52,\r\n"
				+ "    \"name\": \"Frontline house\",\r\n"
				+ "    \"phone_number\": \"(+91) 983 893 3942\",\r\n"
				+ "    \"address\": \"29, side layout, cohen 12\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"Fruit Shop 2\",\r\n"
				+ "        \"shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"https://rahulshettyacademy.com\",\r\n"
				+ "    \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "")
		.when().post("maps/api/place/add/json/")
		.then().log().all().assertThat().statusCode(200);
	}

}

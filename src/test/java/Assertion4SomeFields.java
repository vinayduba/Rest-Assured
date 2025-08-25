import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import ReqPayLoad.ReqPay;


public class Assertion4SomeFields {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
			   .body(ReqPay.payld())
		.when().post("maps/api/place/add/json/")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		System.out.println();
		String place_id=js.getString("place_id");
		System.out.println(place_id);
		

	}

}

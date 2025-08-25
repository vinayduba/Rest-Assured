import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import ReqPayLoad.ReqPay;


public class Assertion4SomeFields {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
			   .body(ReqPay.payld())
		.when().post("maps/api/place/add/json/")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)");
		

	}

}

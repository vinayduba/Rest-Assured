import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.ex;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ReponseExtractionPractice1 {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(ex.pl())
		.when().post("maps/api/place/add/json/")
		.then().assertThat().statusCode(200)
		.extract().response().asString();

		
		System.out.println(response);
		System.out.println();
		JsonPath js= new JsonPath(response);
		String place_id=js.getString("place_id");
		System.out.println(place_id);
		
		
	}

}

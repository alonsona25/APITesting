package ToolsQA.GoogleAPITests;

import java.util.Scanner;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class App {
	@Test
	public void Test() {

		RestAssured.baseURI = "https://maps.googleapis.com/";

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your google API key:");
		String apiKey = scanner.next();

		given().
		param("location", "-33.8670522,151.1957362").
		param("radius", "500").
		param("key", apiKey).
				// request headers
				// parameters
				// request cookies
				// body
		
				when().get("maps/api/place/nearbysearch/json").
				then().assertThat().statusCode(200).and().
				contentType(ContentType.JSON).and().
				body("results[0].name", equalTo("Sydney")).and().
				header("server", "pablo");
		// when()
		// get(resource)
		// post(resource)
		// put(resource)

		// then()
		// assertions to make sure we are getting the correct response

		// extract()
		scanner.close();
	}
}

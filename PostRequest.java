package basicValidation;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequest {

	public static void main(String[] args) {
//		https://reqres.in/api/users

//		Initialize the baseURI variable from the RestAssured class
		RestAssured.baseURI = "https://reqres.in";

		Response response = given().log().all().pathParam("path1", "users").header("Content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"Micheal\",\r\n" + "    \"job\": \"Data Base Admin\"\r\n" + "}").when()
				.post("api/{path1}").then().log().all().extract().response();

//		how to print the response body
		System.out.println("Response body : " + response.asString());
		System.out.println("Response body : " + response.asPrettyString());

//		In order to validate the json payload, parse the response object into JsonPath class object
		JsonPath jp = new JsonPath(response.asString());
		System.out.println("User name in the response body : " + jp.getString("name"));
		System.out.println("User job in the response body : " + jp.getString("job"));
		System.out.println("User id in the response body : " + jp.getString("id"));
		System.out.println("User createdAt in the response body : " + jp.getString("createdAt"));

		Assert.assertEquals(jp.getString("name"), "Micheal");
	}

}
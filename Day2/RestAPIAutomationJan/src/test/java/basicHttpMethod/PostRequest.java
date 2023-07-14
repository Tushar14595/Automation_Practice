package basicHttpMethod;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class PostRequest {

	public static void main(String[] args) {
//		https://reqres.in/api/users

//		Initialize the baseURI variable from the RestAssured class
		RestAssured.baseURI = "https://reqres.in";

		given().log().all().pathParam("path1", "users").header("Content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"Micheal\",\r\n" + "    \"job\": \"Data Base Admin\"\r\n" + "}").when()
				.post("api/{path1}").then().log().all().assertThat().statusCode(201);
	}

}

//	RestAssured offer BDD (Behavioral Driven Development) style for writing automation test script for REST API testing

//	given() --> pre-condition {path parameters, query parameter, request body, request header, authorizations}
//	when()  --> user action
//	then()  --> validation
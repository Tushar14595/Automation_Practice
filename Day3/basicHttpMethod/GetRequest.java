package basicHttpMethod;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class GetRequest {

	public static void main(String[] args) {
//		https://reqres.in/api/users/10

		RestAssured.baseURI = "https://reqres.in";

		given().log().all().pathParam("path1", "users").pathParam("path2", 10).when().get("api/{path1}/{path2}").then()
				.log().all().assertThat().statusCode(200);
	}

}

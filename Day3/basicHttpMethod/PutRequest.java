package basicHttpMethod;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class PutRequest {

	public static void main(String[] args) {
//		https://reqres.in/api/users/4

		RestAssured.baseURI = "https://reqres.in";

		given().log().all().pathParam("path1", "users").pathParam("path2", 4).header("Content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"Abhishek\",\r\n" + "    \"job\": \"Product Manager\"\r\n" + "}").when()
				.put("api/{path1}/{path2}").then().log().all().assertThat().statusCode(200);
	}

}

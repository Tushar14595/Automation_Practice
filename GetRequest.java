package basicValidation;

import static io.restassured.RestAssured.given;

import java.util.Iterator;
import java.util.List;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetRequest {

	public static void main(String[] args) {
//		https://reqres.in/api/users/10

		RestAssured.baseURI = "https://reqres.in";

		Response response = given().log().all().pathParam("path1", "users").pathParam("path2", 10).when()
				.get("api/{path1}/{path2}").then().log().all().extract().response();

//		response() --> returns The entire response object including headers, cookies and body etc.

//		how to validate the status code
		int statusCode = response.getStatusCode(); // returns the status code of the response
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);

//		how to validate the status code line
		String statusLine = response.getStatusLine(); // return the status line of the response
		System.out.println("Status line : " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

//		how to validate the response time
		long responeTime = response.getTime(); // returns the response time in milliseconds
		System.out.println("Response time is : " + responeTime);
		Assert.assertTrue(responeTime < 2000);

//		how to validate the response headers
		String serverHeader = response.getHeader("Server"); // return the header value or null if value was not found
		System.out.println("Server header is : " + serverHeader);
		Assert.assertEquals(serverHeader, "cloudflare");

//		how to print all the response headers
		Headers headers = response.getHeaders();
		List<Header> listOfHeaders = headers.asList();

		System.out.println("*************************************");
		for (int i = 0; i < listOfHeaders.size(); i++) {
//			System.out.println(listOfHeaders.get(i).toString());
//			System.out.println(listOfHeaders.get(i).getName());
//			System.out.println(listOfHeaders.get(i).getValue());

			Header header = listOfHeaders.get(i);
			System.out.println(header.getName() + " :> " + header.getValue());
		}
		System.out.println("*************************************");

		System.out.println("#####################################");
		for (Header header : listOfHeaders) {
			System.out.println(header.getName() + " :- " + header.getValue());
		}
		System.out.println("#####################################");

		Iterator<Header> itr = listOfHeaders.iterator();

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		while (itr.hasNext()) {
			Header header = itr.next();
			System.out.println(header.getName() + " <> " + header.getValue());
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

}

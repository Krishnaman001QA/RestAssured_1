package StepDefination;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import pojo.AddPlace_Serialization;
import pojo.location_Serialization;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepdefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resp;
	Response response;
	String place_id;
	JsonPath j1;
	static String pid;
	TestDataBuild data = new TestDataBuild();

	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		// resp = new
		// ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		res = given().log().all().spec(requestSpecification()).body(data.addPlacepayLoad(name, language, address));

	}

	@When("User Calls {string} with {string} http request")
	public void user_calls_with_http_request(String resources, String method) {
		// Write code here that turns the phrase above into concrete actions

		APIResources resAPI = APIResources.valueOf(resources);
System.out.println(resAPI);
		resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST"))
			response = res.when().post(resAPI.Getresource());
		// .then().spec(resp).extract().response();
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().post(resAPI.Getresource());

	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String Key, String Value) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(getJsonPath(response, Key), Value);

	}

	@Then("verify place_id created map to {string} using {string}")
	public void verify_place_id_created_map_to_using(String name, String resources) throws IOException {
		// Write code here that turns the phrase above into concrete actions

//		String pid = j1.getString("place_id");
//		requestspec

		 pid = getJsonPath(response, "place_id");
		res = given().log().all().spec(requestSpecification()).queryParam("place_id", pid);
		user_calls_with_http_request(resources, "GET");
		String name1 = getJsonPath(response, "name");
		
		assertEquals(name1, name);

	}
	
	@Given("Delete payload")
	public void delete_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		res = given().log().all().spec(requestSpecification()).body(data.deletePayload(pid));
		
	}

}

package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {

		if (req == null) {
			PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
			// RestAssured.baseURI = "https://rahulshettyacademy.com";

			req = new RequestSpecBuilder().setBaseUri(getGlobalvalues("baseurl")).addQueryParam("key", "qaclick123")

					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))

					.setContentType(ContentType.JSON).build();

			return req;
		}
		return req;

	}

	public static String getGlobalvalues(String Key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Fleek\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(Key);

	}

	/*
	 * for logging ()Implementing logging feature in Frame work -----Video-81 only
	 * in RequestSpecBuilder we can use this logging feature
	 * 
	 * .addFilter(RequestLoggingFilter.logRequestTo(log))
	 * .addFilter(ResponseLoggingFilter.logResponseTo(log))
	 * 
	 * then create object
	 * 
	 * PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	 * 
	 * 
	 * 
	 */

	public String getJsonPath(Response response, String Key)

	{
		String jk = response.asString();
		JsonPath j1 = new JsonPath(jk);
		
		return j1.get(Key).toString();

	}
}

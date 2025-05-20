package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import io.restassured.response.Response;
import utils.APIUtils;

public class UserAPITest {
	@BeforeClass // run before all the test methods have run
	public void beforeTests() {
		System.out.println("Test Execution started");
	}

	@Test(dataProvider = "userData", dataProviderClass = data.DataProviderClass.class) // marks thiss method as a text
																						// and connects it to the data
																						// provider, here dataProvider =
																						// "userData": Refers to the
																						// provider name in your
																						// DataProviderClass.
	public void createUserTest() {// method take 3 parameters by taking data from the data provider
		String name = "swetha";
		String email = "swethanallani310@gamil.com";
		String phone = "2384596078";
		String body = String.format("{\"name\": \"%s\", \"email\": \"%s\", \"phone\": \"%s\"}", name, email, phone);// %s
																													// placeholders
																													// with
																													// actual
																													// results
		Response response = APIUtils.requestSetup()// Response-stores result returned from API,
				.body(body) // adds the preapered json as a request body
				.when().post("/users").then().log().all() // logs the entire response like ststus headers body to the
															// console
				.statusCode(201) // staranded for successful POST
				.extract().response();
		assertEquals(response.jsonPath().get("name"), name);// extracts the name from the json response, basically it
															// check the expected vs actual result

	}

	@AfterClass
	public void aftertests() {
		System.out.println("Test Execution Completed"); // runs after all the test method have run

	}

}

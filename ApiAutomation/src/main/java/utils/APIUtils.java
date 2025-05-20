package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class APIUtils { // it contains resuable code for setting up api requests
	public static Properties config = new Properties();// we used static ,so we can use APIUtils.config
														// directly,properties -object type,Variable name,
	/* Prepares a storage to hold config values from the file. */
	static {// Static block. Runs once when the class is first loaded
		try { // a block that tries code that might cause an error
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");// opens config.poperties
																								// for reading
			config.load(fis);// read all properities likeb base .url iinto the config object
		} catch (IOException e) {// catch - catches any error from the try block, IoEx- type of error to catch
									// (input/output), e- variable name for the caught error

			e.printStackTrace();
// print the error details to console

		}
	}

	public static RequestSpecification requestSetup() {// returns a request specification object.
		return RestAssured.given() // start building a new reuest
				.baseUri(config.getProperty("base.url"))// result .baseUri("https://reqres.in/api"),This fetches the
														// value of the key base.url from the config.properties file.

				.header("Content-Type", "application/json"); // here we are saying requet body in the json object by
																// adding header content type with value application
																// /json .

	}
}

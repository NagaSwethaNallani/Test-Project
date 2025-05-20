package data;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;

public class DataProviderClass { // declares a public class named dataprovided calss
	@DataProvider(name = "userData") // give  a name to this data provider
	public Object[][] 
			getUserData() { // i used here 2d array becausee testng excepts data as rows and  columns , getuser data is name odf the method 
	Faker faker = new Faker(); // to generate fake data
	return new Object[][] {
        {faker.name().firstName(), faker.internet().emailAddress(), faker.phoneNumber().cellPhone()}

		
	};// object is created and passed to return so the statement end with ;
	}

}

package parameters.testing;

import org.testng.annotations.DataProvider;

public class DataproviderClass {
	@DataProvider(name = "SearchProvider")
	public static Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Guru99", "India" }, { "Amit", "UK" }, { "Ajay", "USA" } };
	}
}

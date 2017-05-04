package testData;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	/*
	 * data provider here name is optional... if it is mentioned then
	 * dataProvider name will be changed to the mentioned name
	 */
	@DataProvider(name = "SearchProvider")

	public static Object[][] getDataFromDataprovider() {
		/*
		 * this dataProvider is [3][1] , the test method where dataProvider is
		 * used will run 3 times for 3 search keys and second array indicates
		 * parameters i e 1 parameter
		 */

		return new Object[][] { { "flower" }, { "India" }, { "USA" } };
	}
}

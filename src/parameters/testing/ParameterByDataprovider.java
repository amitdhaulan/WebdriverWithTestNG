package parameters.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class ParameterByDataprovider {
	WebDriver driver;

	/**
	 * Test case to verify google search box
	 * 
	 * @param author
	 * @param searchKey
	 * @throws InterruptedException
	 */

	@Test(dataProvider = "SearchProvider")
	public void testMethod(String author, String searchKey) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		// search value in google searchbox
		searchText.sendKeys(searchKey);
		System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
		Thread.sleep(3000);
		String testValue = searchText.getAttribute("value");
		System.out.println(testValue + "::::" + searchKey);
		searchText.clear();
		// Verify if the value in google search box is correct
		Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
	}
	

	/**
	 * @return Object[][] where first column contains 'author' and second column
	 *         contains 'searchKey'
	 */

	@DataProvider(name = "SearchProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Guru99", "India" }, { "Amit", "UK" }, { "Ajay", "USA" } };

	}

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}

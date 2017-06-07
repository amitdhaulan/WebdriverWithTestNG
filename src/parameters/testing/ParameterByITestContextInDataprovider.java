package parameters.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(suiteName = "testsuite")
public class ParameterByITestContextInDataprovider {
	static WebDriver driver;

	@Test(dataProvider = "SearchProvider", groups = "A")
	public void testMethodA(String author, String searchKey) throws InterruptedException {
		{
			// search google textbox
			WebElement searchText = driver.findElement(By.name("q"));
			// search a value on it
			searchText.sendKeys(searchKey);
			System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
			Thread.sleep(3000);
			String testValue = searchText.getAttribute("value");
			System.out.println(testValue + "::::" + searchKey);
			searchText.clear();
			// verify correct value in searchbox
			Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
		}
	}

	@Test(dataProvider = "SearchProvider", groups = "B")
	public void testMethodB(String searchKey) throws InterruptedException {
		{
			// find google search box
			WebElement searchText = driver.findElement(By.name("q"));
			// search a value on it
			searchText.sendKeys(searchKey);
			System.out.println("Welcome ->Unknown user Your search key is->" + searchKey);
			Thread.sleep(3000);
			String testValue = searchText.getAttribute("value");
			System.out.println(testValue + "::::" + searchKey);
			searchText.clear();
			// verify correct value in searchbox
			Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
		}
	}

	/**
	 * Here the DataProvider will provide Object array on the basis on
	 * ITestContext
	 *
	 * @param c
	 * @return
	 */
	@DataProvider(name = "SearchProvider")
	public Object[][] getDataFromDataprovider(ITestContext c) {
		Object[][] groupArray = null;
		for (String group : c.getIncludedGroups()) {
			if ("A".equals(group)) {
				groupArray = new Object[][] { { "Guru99", "India" }, { "Amit", "UK" }, { "Ajay", "USA" } };
				break;
			} else {
				groupArray = new Object[][] { { "Canada" }, { "Russia" }, { "Japan" } };
			}
			break;
		}
		return groupArray;
	}

	@BeforeTest(groups={"A","B"})
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
	}

	@AfterTest(groups={"A","B"})
	public static void afterTest() {
		driver.close();
	}
}

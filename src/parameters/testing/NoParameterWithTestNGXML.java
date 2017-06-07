package parameters.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NoParameterWithTestNGXML {
	WebDriver driver;
	String author = "guru99";
	String searchKey = "india";


	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
	}
	@Test
	public void testNoParameter() throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		// Searching text in google text box
		searchText.sendKeys(searchKey);

		System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
		System.out.println("Thread will sleep now");

		Thread.sleep(3000);
		System.out.println("Value in Google Search Box = " + searchText.getAttribute("value")
				+ " ::: Value given by input = " + searchKey);
		// verifying the value in google search box
		AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
	}
}

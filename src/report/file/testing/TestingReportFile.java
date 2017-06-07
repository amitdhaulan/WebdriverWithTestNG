package report.file.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class TestingReportFile {
	public String baseUrl = "http://newtours.demoaut.com/";
	String driverPath = "C:\\geckodriver.exe";
	public WebDriver driver;
	public WebElement element;
	public String expected = null;
	public String actual = null;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(baseUrl);
	}

	@BeforeMethod
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 0)
	public void register() {
		element = (new WebDriverWait(driver, 15))
				.until(ExpectedConditions.presenceOfElementLocated(By.linkText("REGISTER")));
		element.click();
		expected = "Register: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 1)
	public void support() {
		element = (new WebDriverWait(driver, 15))
				.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SUPPORT")));
		element.click();
		expected = "Under Construction: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void goBackToHomepage() {
		element = (new WebDriverWait(driver, 15))
				.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
		element.click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}

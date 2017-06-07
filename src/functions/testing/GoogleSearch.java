package functions.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearch {
	WebElement element;
	private WebDriver driver;
	// private WebElement element;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.close();
	}

	
	// Search using keyword through Google search
	@Test(enabled = true)
	public void googleSearch() throws Exception {
		// Open Home Page
		driver.get("http://www.google.com");
		// Enter text in search box
		element = driver.findElement(By.name("q"));
		element.sendKeys("selenium");
		Thread.sleep(1000);
		// Click Search button
		element = driver.findElement(By.name("btnG"));
		element.click();
		Thread.sleep(10000);
	}

	// @Test
	// public void test() throws InterruptedException {
	// driver.get("http://toolsqa.wpengine.com/automation-practice-form");
	//
	// Select oSelect = new Select(driver.findElement(By.id("continents")));
	// oSelect.selectByVisibleText("Europe");
	// // Using sleep command so that changes can be noticed
	// Thread.sleep(2000);
	//
	// oSelect.selectByIndex(2);
	// Thread.sleep(2000);
	//
	// List<WebElement> oSize = oSelect.getOptions();
	// int iListSize = oSize.size();
	// for (int i = 0; i < iListSize; i++) {
	// String sValue = oSelect.getOptions().get(i).getText();
	// System.out.println(sValue);
	// if (sValue.equals("Antartica")) {
	// oSelect.selectByIndex(i);
	// break;
	// }
	// }
	// }
}
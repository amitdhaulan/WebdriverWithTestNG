package demo.script.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Gmail_Login {
	private String pwd = "<>";
	private String id = "amitkumar025";
	LoginPage_POM pom;

	@BeforeTest
	public void setUp() {
		// Test case started
		pom = new LoginPage_POM();
	}

	@AfterTest
	public void tearDown() {
		// Test Case finished
		pom.tearDown();
	}

	@Test
	public void gmail_login() {
		// get and set email id
		pom.setUserName("username");
		LoginPage_POM.element = pom.getUserName();
		LoginPage_POM.element.sendKeys(id);
		System.out.println("User Name");

		// get and click next button
		pom.setNextbutton("nextbutton");
		By by = pom.getNextbutton();
		by.findElement(LoginPage_POM.element).click();
		System.out.println("Next button");

		// wait for password to be present on UI
		LoginPage_POM.element = (new WebDriverWait(LoginPage_POM.driver, 40))
				.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
		LoginPage_POM.element.sendKeys(pwd);
		System.out.println("password");

		// get and click next button
		pom.setNextbutton("nextbutton");
		by = pom.getNextbutton();
		by.findElement(LoginPage_POM.element).click();
		System.out.println("Next button");

		// Assertion to verify page title
		Assert.assertEquals(LoginPage_POM.driver.getTitle(), "Gmail");

		// Login_Page_POM.element = (new WebDriverWait(Login_Page_POM.driver,
		// 40))
		// .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='T-I
		// J-J5-Ji T-I-KE L3']")));
		// Login_Page_POM.element.click();
		//
		// // get and set "to email id"
		// Login_Page_POM.element =
		// Login_Page_POM.driver.findElement(By.xpath("//textarea[@aria-label='To']"));
		// Login_Page_POM.element.sendKeys("amitrenu254@gmail.com");
		//
		// // get and set subject
		// Login_Page_POM.element =
		// Login_Page_POM.driver.findElement(By.xpath("//input[@name='subjectbox']"));
		// Login_Page_POM.element.sendKeys("enter subject");
		//
		// // get and set mail body
		// WebElement frame1 =
		// Login_Page_POM.driver.findElement(By.xpath("//div[@class='Am Al
		// editable LW-av']"));
		// Login_Page_POM.driver.switchTo().frame(frame1);
		// WebElement editable =
		// Login_Page_POM.driver.switchTo().activeElement();
		// String mailBody = "Hi," + '\n' + "I'm Ripon from Dhaka, Bangladesh.";
		// editable.sendKeys(mailBody);
		// Login_Page_POM.driver.switchTo().defaultContent();

	}
}

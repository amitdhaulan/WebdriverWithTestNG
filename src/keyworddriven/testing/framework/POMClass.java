package keyworddriven.testing.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class POMClass {
	public static WebElement element;

	public static void navigate(String str) {
		KeywordDriventestClass.driver.get(str);
	}

	public static void click_MyAccount(String str) {
		element = KeywordDriventestClass.driver.findElement(By.xpath(str));
		element.click();
	}

	public static void input_Username(String str) {
		element = (new WebDriverWait(KeywordDriventestClass.driver, 15))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("log")));
		element.sendKeys(str);
	}

	public static void input_Password(String str) {
		element = (new WebDriverWait(KeywordDriventestClass.driver, 15))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("pwd")));
		element.sendKeys(str);
	}

	public static void click_Login(String str) {
		element = KeywordDriventestClass.driver.findElement(By.id(str));
		element.click();
	}

	public static void waitFor(String str) throws Exception {
		element = (new WebDriverWait(KeywordDriventestClass.driver, 15))
				.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Logout")));
	}

	public static void click_Logout() {
		element.click();
		Assert.assertEquals(KeywordDriventestClass.driver.getTitle(), "Your Account | ONLINE STORE");
	}
}

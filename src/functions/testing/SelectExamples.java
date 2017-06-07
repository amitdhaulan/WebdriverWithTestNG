package functions.testing;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//Not operational
public class SelectExamples {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("C:\\Users\\DEV\\Desktop\\html-and-css-code-samples\\Final Code\\chapter-07\\dropdown-select.html");
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void selectSamples() throws InterruptedException {

		WebElement element = driver.findElement(By.name("Mobdevices"));
		Select se = new Select(element);

		se.selectByVisibleText("Nokia");
		se.selectByVisibleText("HTC");

		// To get all the options present in the dropdown
		List<WebElement> allOptions = se.getOptions();
		for (WebElement webElement : allOptions) {
			System.out.println(webElement.getText());
		}

		// To get all the options that are selected in the dropdown.
		List<WebElement> allSelectedOptions = se.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			System.out.println("You have selected::" + webElement.getText());
		}

		// To get the first selected option in the dropdown
		WebElement firstOption = se.getFirstSelectedOption();
		System.out.println("The First selected option is::" + firstOption.getText());

		if (se.isMultiple()) {
			System.out.println("Select tag allows multiple selection");
		}
	}

}

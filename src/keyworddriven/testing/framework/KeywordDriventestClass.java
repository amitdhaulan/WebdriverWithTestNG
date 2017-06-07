package keyworddriven.testing.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class KeywordDriventestClass {
	public static WebDriver driver;
	public String navigate;
	public String clickMyAccount;
	public String inputUsername;
	public String inputPassword;
	public String clickLogin;
	public String waitFor;
	public String clickLogout;

	@Test(dataProvider = "DataProvider")
	public void test(String key, String value) throws Exception {
		if (key.equals(navigate)) {
			POMClass.navigate(value);
		} else if (key.equals(clickMyAccount)) {
			POMClass.click_MyAccount(value);
		} else if (key.equals(inputUsername)) {
			POMClass.input_Username(value);
		} else if (key.equals(inputPassword)) {
			POMClass.input_Password(value);
		} else if (key.equals(clickLogin)) {
			POMClass.click_Login(value);
		} else if (key.equals(waitFor)) {
			POMClass.waitFor(value);
		} else {
			POMClass.click_Logout();
		}

	}

	@BeforeTest
	public void beforeTest() throws Exception {
		String sPath = "D:\\amit\\Java_programs\\WebdriverWithTestNG\\src\\dataEngine\\DataEngine.xlsx";

		ExcelUtils.setExcelFile(sPath, "Test Steps");

		for (int iRow = 1; iRow <= 9; iRow++) {
			String sActionKeyword = ExcelUtils.getCellData(iRow, 3);
			if (sActionKeyword.equals("navigate")) {
				navigate = sActionKeyword;
			} else if (sActionKeyword.equals("click_MyAccount")) {
				clickMyAccount = sActionKeyword;
			} else if (sActionKeyword.equals("input_Username")) {
				inputUsername = sActionKeyword;
			} else if (sActionKeyword.equals("input_Password")) {
				inputPassword = sActionKeyword;
			} else if (sActionKeyword.equals("click_Login")) {
				clickLogin = sActionKeyword;
			} else if (sActionKeyword.equals("waitFor")) {
				waitFor = sActionKeyword;
			} else if (sActionKeyword.equals("click_Logout")) {
				clickLogout = sActionKeyword;
			}
		}

		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@DataProvider(name = "DataProvider")
	public static Object[][] dataprovider() {
		return new Object[][] { { "navigate", "http://www.store.demoqa.com" },
				{ "click_MyAccount", ".//*[@id='account']/a" }, { "input_Username", "kashyap1" },
				{ "input_Password", "kashyap1" }, { "click_Login", "login" }, { "WaitFor", "" } };
	}
}

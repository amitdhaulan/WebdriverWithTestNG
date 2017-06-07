package demo.script.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage_POM {
	public static WebElement element;
	public static WebDriver driver;
	WebElement emailId, password, login_button;
	By nextbutton;

	LoginPage_POM() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		LoginPage_POM.driver.get(
				"https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		LoginPage_POM.driver.manage().window().maximize();
	}

	public void tearDown() {
		driver.close();
	}
	
	public By getNextbutton() {
		return nextbutton;
	}

	public void setNextbutton(String nextbutton) {
		this.nextbutton = By.xpath("//span[.='Next']");
	}

	public WebElement getUserName() {
		return emailId;
	}

	public void setUserName(String userName) {
		this.emailId = element = driver.findElement(By.id("identifierId"));
		;
	}
}

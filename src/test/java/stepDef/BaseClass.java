package stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {
	public static WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome,driver", "chromedriver");
	}

	@After
	public void teardown() {
		driver.quit();
	}
}
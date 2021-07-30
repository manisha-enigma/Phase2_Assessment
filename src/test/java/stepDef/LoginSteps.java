package stepDef;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver = BaseClass.driver;

	@Given("^User has launched the Swaglab application$")
	public void user_has_launched_the_swaglab_application() throws Throwable {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@When("^User enters username \"([^\"]*)\"$")
	public void user_enters_username_something(String username) throws Throwable {

		WebElement UserName = driver.findElement(By.xpath("//*[@id = 'user-name']"));
		UserName.sendKeys(username);
	}

	@And("^User enters password \"([^\"]*)\"$")
	public void user_enters_password_something(String password) throws Throwable {
		WebElement Password = driver.findElement(By.xpath("//*[@id = 'password']"));
		Password.sendKeys(password);
	}

	@And("^Click on the Login Button$")
	public void click_on_the_login_button() throws Throwable {
		WebElement Login = driver.findElement(By.name("login-button"));
		Login.click();
		Thread.sleep(1000);
	}

	@Then("^User is able to see the Home page$")
	public void user_is_able_to_see_the_home_page() throws Throwable {
		WebElement ProductPageTitle = driver.findElement(By.xpath("//*[@class='title']"));
		String ActText = ProductPageTitle.getText();
		String ExpText = "PRODUCTS";
		Assert.assertEquals(ExpText, ActText);
	}

	@Then("^User is able to see the error message \"([^\"]*)\"$")
	public void user_is_able_to_see_the_error_message_something(String Experror) throws Throwable {
		WebElement ErrorMsg = driver.findElement(By.xpath("//*[@data-test='error']"));
		String ActError = ErrorMsg.getText();
		Assert.assertEquals(ActError, Experror);
	}

}
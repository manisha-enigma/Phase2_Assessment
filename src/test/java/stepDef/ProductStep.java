package stepDef;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStep {
	WebDriver driver = BaseClass.driver;

	@Given("^User has opened Swaglab application$")
	public void user_has_launched_the_swaglab_application() throws Throwable {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@When("^User enters the username \"([^\"]*)\"$")
	public void user_enters_username_something(String standard_user) throws Throwable {
		WebElement UserName = driver.findElement(By.xpath("//*[@id = 'user-name']"));
		UserName.sendKeys(standard_user);
	}

	@And("^User enters the password \"([^\"]*)\"$")
	public void user_enters_password_something(String secret_sauce) throws Throwable {
		WebElement Password = driver.findElement(By.xpath("//*[@id = 'password']"));
		Password.sendKeys(secret_sauce);
	}

	@And("^Click on Login Button$")
	public void click_on_the_login_button() throws Throwable {
		WebElement Login = driver.findElement(By.name("login-button"));
		Login.click();
	}

	@Given("^User should landed on home page$")
	public void user_should_landed_on_home_page() throws Throwable {
		WebElement ProductPageTitle = driver.findElement(By.xpath("//*[@class='title']"));
		String ActText = ProductPageTitle.getText();
		String ExpText = "PRODUCTS";
		Assert.assertEquals(ExpText, ActText);

	}

	@Then("^User should be able to see the product in cart$")
	public void user_should_be_able_to_see_the_product_in_cart() throws Throwable {
		WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		cart.click();
		System.out.println("Redirected to my cart page");

	}

	@And("^User selects product and click on the add to cart button \"([^\"]*)\"$")
	public void user_selects_product_and_click_on_the_add_to_cart_button_something(String product) throws Throwable {
		WebElement btnaddtocart = driver.findElement(By.xpath("//*[text()=\'" + product + "\']//following::button[1]"));
		btnaddtocart.sendKeys(product);
		System.out.println("Item added to cart");
	}

	@And("^User add multiple products to the cart$")
	public void user_add_multiple_products_to_the_cart(DataTable Table) throws Throwable {
		String Product1 = Table.cell(0, 0);
		String Product2 = Table.cell(1, 0);
		String Product3 = Table.cell(2, 0);
		String Product4 = Table.cell(3, 0);

		WebElement AddProduct1 = driver.findElement(By.xpath("//*[text()=\'" + Product1 + "\']//following::button[1]"));
		AddProduct1.click();

		WebElement AddProduct2 = driver.findElement(By.xpath("//*[text()=\'" + Product2 + "\']//following::button[1]"));
		AddProduct2.click();

		WebElement AddProduct3 = driver.findElement(By.xpath("//*[text()=\'" + Product3 + "\']//following::button[1]"));
		AddProduct3.click();

		WebElement AddProduct4 = driver.findElement(By.xpath("//*[text()=\'" + Product4 + "\']//following::button[1]"));
		AddProduct4.click();
		System.out.println("Products added to cart");
	}

}
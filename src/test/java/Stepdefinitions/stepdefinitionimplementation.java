package Stepdefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Sigmoid.SeleniumFramework.BasicsSelenium1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinitionimplementation extends BasicsSelenium1  {
	WebDriver driver = new ChromeDriver ();
	WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
	@Given("I landed on online app page")
	
	public void I_landed_on_online_app_page()
	{
	
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	@Given("^I want login with the user name (.+) and password(.+$)")
	public void loggedin_username_and_password(String username, String password) {
		driver.findElement(By.id("userEmail")).sendKeys(username);
		driver.findElement(By.id("userPassword")).sendKeys(password);;
	}
	
	@When("^I_add the (.+) to cart$")
	public void I_add_the_productname_to_cart(String productname) {
		List<WebElement> addedProducts= driver.findElements(By.cssSelector("div[class= 'cartSection'] h3"));
		addedProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));
		
	}
		
	@When("^checkout (.+) and submit$")
	public void checkout_productname_and_submit() {
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),("India")).build().perform();
		ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector("div section button:last-of-type")).click();

		driver.findElement(By.cssSelector(".actions [class*='ng-star-inserted']")).click();
		ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".overlay-container div")));
	}

	@Then("{string} message should display")
	public void check_message_should_display() {
		System.out.println(driver.findElement(By.className("hero-primary")).getText());
		
		
	}


}

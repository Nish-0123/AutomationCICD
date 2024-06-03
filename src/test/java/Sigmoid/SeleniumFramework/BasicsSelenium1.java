package Sigmoid.SeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicsSelenium1 {

	public static void main(String[] args) throws InterruptedException {
		String Selecteditem ="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("John1@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("John@1234");
		driver.findElement(By.name("login")).click();
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".offset-sm-1"))));
		List<WebElement> items= driver.findElements(By.cssSelector(".offset-sm-1"));
		WebElement product = items.stream().filter(item->item.findElement(By.cssSelector("b")).getText().equals(Selecteditem)).findFirst().orElse(null);
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#toast-container"))));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> addedProducts= driver.findElements(By.cssSelector("div[class= 'cartSection'] h3"));
		Boolean check= addedProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(Selecteditem));
		Assert.assertTrue(check);
		driver.findElement(By.cssSelector(".totalRow button")).click();
//		 driver.findElement(By.cssSelector(".form-group input")).sendKeys("Ind");
		 Thread.sleep(3000);
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),("India")).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".ta-results"))));
		driver.findElement(By.cssSelector("div section button:last-of-type")).click();

		driver.findElement(By.cssSelector(".actions [class*='ng-star-inserted']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".overlay-container div"))));

		System.out.println(driver.findElement(By.className("hero-primary")).getText());
		String id= driver.findElement(By.cssSelector("label[class='ng-star-inserted']")).getText();
		Assert.assertTrue(true, " | 664c8f0ea86f8f74dceab6f9 | ");
		

		
		
			
		
		
		
		
		
		

	}

}

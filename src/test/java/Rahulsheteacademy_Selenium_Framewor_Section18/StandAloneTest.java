package Rahulsheteacademy_Selenium_Framewor_Section18;

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

import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.LoginPage;

public class StandAloneTest {

	public static void main(String[] args) {
		  WebDriver driver = new ChromeDriver();
		    
		    //waiting for 3 seconds to load the page
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		    
		    driver.get("https://rahulshettyacademy.com/client");
		    
		    //creating an object of another test
		  // LoginPage LoginPage = new LoginPage(driver);
		   	    
			//entering email using id locator
			driver.findElement(By.id("userEmail")).sendKeys("pigu2587@gmaail.com");
			
			//entering password using id locator
			driver.findElement(By.id("userPassword")).sendKeys("Pr@jyot02");
			
			//clicking on the element using id locator
			driver.findElement(By.id("login")).click();
			
			driver.manage().window().maximize();
			
			//We want to wait till products are  shown
			//instead of using thread.sleep we are wait using explicit waits
			//applying wait globally
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")));
			
			//storing the name of product in a STRING
			String product_name = "ZARA COAT 3";
			
			
			//Below command will store all the names of products in items and then we will compare the list with the string
			List <WebElement> items = driver.findElements(By.cssSelector("div.mb-3"));
			
			//Prod will store the value which is required for the user
			//converting items to stream and filtering it to get its name by using gettext
			//comparing the extracted text to string using equals 
			//find first will return the name which it found at the very first
			//or else null means the name is not present
			WebElement prod = items.stream().filter(i->i.findElement(By.cssSelector("b")).getText().equals(product_name)).findFirst().orElse(null);
			
			//Below command will do add to card after identifying the element
			prod.findElement(By.cssSelector("div.card-body button:last-of-type")).click();
			
			//We want to wait till add to cart(toast message) is shown
			//instead of using thread.sleep we are wait using explicit waits
			WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
			
			//we have to wait till the toast disappears
			//so we use ng-animating 
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
			
			//click on add to cart
			driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
			
			//we must try and get the unique ways to identify the products
			//grabbing all the names from the cart section by using a locator which is common to identify the names
				List <WebElement> cart = driver.findElements(By.cssSelector("div.cart h3"));
				
				
			//iterating through all the names using stream and checking if the cart contains the name which we want
			//anymatch will check if product name text it retrieves is eqaul to product name
			//boolean will return true
			Boolean match =	cart.stream().anyMatch(c->c.getText().equalsIgnoreCase(product_name));
			
			//putting an assertion means assert.true(true) test case will pass
			Assert.assertTrue(match);
			
			//Checkout button
			//Syntax of CSS--> parent.class space childtagname
			driver.findElement(By.cssSelector("li.totalRow button")).click();
			
			
			//There is a class called Java for advance selenium interactions
			
			//Using the actions class it is easier to do sendkeys
			Actions a = new Actions(driver);
			
			//inorder to make action class work always use build and perform
			//sending the data as india using actions class 
			//just another method to send data using action class instead of using sendkeys
			a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "India").build().perform();
			
			//explicit wait is declared since its taking some time
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.ta-results")));
			
			//selecting the country name that we want
			//css-> tagname.classname:nth-of-type()
			driver.findElement(By.cssSelector("button.ta-item:nth-of-type(2)")).click();
			
			//clicking on the place order button
			driver.findElement(By.cssSelector("a[class*= btn]")).click();
			
			//copying the thank u message
			String message = driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();
			
			//assertion to check expected is equal to actual message
			Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			
	}

}

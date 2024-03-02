package Rahulsheteacademy_Selenium_Framewor_Section19.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.Checkoutpage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.DashboardPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.Goto_CartPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.LoginPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.confirmation;
import Rahulsheteacademy_Selenium_Framewor_Section20.Testcomponents.Basetest;

public class SubmitOrders extends Basetest {

	public static void main(String[] args) throws InterruptedException {
		  WebDriver driver = new ChromeDriver();
		    
		    //waiting for 3 seconds to load the page
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		    
		    //creating an object of another test
			   LoginPage LoginPage = new LoginPage(driver);
		    
		  //getting the URL by calling the method
			   LoginPage.goTo();
		    	   
		   //calling the method inorder to send the data
			   DashboardPage dashboard = LoginPage.loginApplication("pigu2587@gmaail.com","Pr@jyot02");
		    
			//maximizing the screen
			driver.manage().window().maximize();
			

			
			//storing the name of product in a STRING
			String product_name = "ZARA COAT 3";
			
			
			//calling the method getproductlist from dashboard page and storing all list of items in items Webelemenet
			List<WebElement> items = dashboard.getProductlist();
			
			////Below command will do add to card after identifying the element
			dashboard.addproducttocart(product_name);
			
			
			//clicking on add to cart
			Goto_CartPage cart = dashboard.gotocart();
			
			
			//checking if the item is present in add to cart section
			boolean match = cart.matchvalue(product_name);
			
		    //validations cannot go in page object file
			//putting an assertion means assert.true(true) test case will pass
			Assert.assertTrue(match);
			
			
			//Checkout button
			Checkoutpage checkout = cart.gotocheckout();
			
			
			//selecting country india
			checkout.selectcountry("india");
			
			//clicking on place order
			confirmation confirmation =	checkout.submitorder();
			
			
			//calling the method and stoing it in a vale
			String confirmmessage = confirmation.verifyconfirmation();
			
					
			//assertion to check expected is equal to actual message
			Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			
			
			
	}

}

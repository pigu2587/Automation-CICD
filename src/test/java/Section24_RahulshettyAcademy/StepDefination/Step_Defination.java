package Section24_RahulshettyAcademy.StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.Checkoutpage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.DashboardPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.Goto_CartPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.LoginPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.confirmation;
import Rahulsheteacademy_Selenium_Framewor_Section20.Testcomponents.Basetest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_Defination extends Basetest {
	
	
	public DashboardPage   dashboard;
	public confirmation confirmation;
	public LoginPage landingpage;
	@Given ("I landed on Ecommerce Page")
	
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		loginpage = launchapplication();
	}

	@ Given ("^Logged in with Username (.+) and Paswword (.+)$")
	
	public void username_and_password(String username, String password)
	{
		   dashboard = LoginPage.loginApplication(username,password);
	}
	
	@When("^I add product (.+) from Cart$")	
	public void add_product_to_cart(String product_name) throws InterruptedException
	{
		//calling the method getproductlist from dashboard page and storing all list of items in items Webelemenet
		List<WebElement> items = dashboard.getProductlist();
		
		////Below command will do add to card after identifying the element
		dashboard.addproducttocart(product_name);
	}
	
	@When("^ Checkout (.+) and submit the order$")
	public void checkout(String product_name) 
	{
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
		 confirmation =	checkout.submitorder();
		
	}
	
	
	@Then ("{string} message is displayed on ConfirmationPage")
	 public void message_displayed(String string)
	 {
		//calling the method and stoing it in a vale
		String confirmmessage = confirmation.verifyconfirmation();
		
				
		//assertion to check expected is equal to actual message
		Assert.assertTrue(confirmmessage.equalsIgnoreCase(string));

	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

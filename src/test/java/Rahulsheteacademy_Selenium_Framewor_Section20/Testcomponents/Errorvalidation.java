package Rahulsheteacademy_Selenium_Framewor_Section20.Testcomponents;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.DashboardPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.Goto_CartPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.LoginPage;

public class Errorvalidation extends Basetest{

	
		 //running using test method
		     @Test(groups= {"Errorhandling"},retryAnalyzer=(Class<extends IRetryAnalyzer>) Retry.class)
		     public void Loginerrorvalidastion() throws IOException, InterruptedException {
		   
		    		//storing the name of product in a STRING
					String product_name = "ZARA COAT 3";
		   
				
					   				    	   
				   //calling the method inorder to send the data
					LoginPage.loginApplication("pigu2587@gmaail.com","Pr@jyot02");
					
		
				
					
					//
					Assert.assertEquals("Incorrect email orpassword", LoginPage.getErrorMessage());
		     }
		     
		     @Test
		     public void Producterrorvalidation() throws IOException, InterruptedException {
		   
		    		//storing the name of product in a STRING
					String product_name = "ZARA COAT 3";
		   
				
					   				    	   
				   //calling the method inorder to send the data
					   DashboardPage dashboard = LoginPage.loginApplication("rahulshetteacademy@gmaail.com","Pr@jyot02");
					
					
					//calling the method getproductlist from dashboard page and storing all list of items in items Webelemenet
					List<WebElement> items = dashboard.getProductlist();
					
					////Below command will do add to card after identifying the element
					dashboard.addproducttocart(product_name);
					
					
					//clicking on add to cart
					Goto_CartPage cart = dashboard.gotocart();
					
					
					//checking if the item is present in add to cart section
					boolean match = cart.matchvalue("ZARA COAT 33");
					
				    //validations cannot go in page object file
					//putting an assertion means assert.true(true) test case will pass
					Assert.assertFalse(match);
					
	
					
					
					
				
			
			

		     }

}

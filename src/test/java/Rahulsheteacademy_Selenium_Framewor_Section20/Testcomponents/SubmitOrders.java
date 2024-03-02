package Rahulsheteacademy_Selenium_Framewor_Section20.Testcomponents;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.Checkoutpage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.DashboardPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.Goto_CartPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.LoginPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.OrderPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.confirmation;

public class SubmitOrders extends Basetest{

	//storing the name of product in a STRING
	String product_name = "ZARA COAT 3";
	
		 //running using test method
	     //Declaring the data provider
		     @Test(dataProvider="getData")
		     public void submitorders(String Email, String Password, String productname) throws IOException, InterruptedException {
		   
		    	
		   
				
					   				    	   
				   //calling the method inorder to send the data
					   DashboardPage dashboard = LoginPage.loginApplication(Email,Password);
					
					
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
		     //To verify ZARA coat 3 is displayed in Orders page
		     
		    @Test(dependsOnMethods={"submitorders"} ) 
		     public void OrderHistory() {
		    	 
				   DashboardPage dashboard = LoginPage.loginApplication("pigu2587@gmaail.com","Pr@jyot02");
				   
				   //
				  OrderPage orderspage =  dashboard.gotoOrderspage();
				  
				  //
				Assert.assertTrue(orderspage.VerifyOrderDisplay(product_name));
				  	 
		    	 
		     }
		    
	//Starting with section 21	    
		    @DataProvider
		    public Object[][] getData() {
		    	
		    	//creating two dimensional array
		    	//object can be int, string,char but we dont kow wat it is so declaring it as Object
		    	//passing the details in curly brackets
		    	//putting the product name as well
		    	return new Object[][] {{"pigu2587@gmaail.com","Pr@jyot02","ZARA COAT 3"},{"Abc@gmail.com","dontdisturb","ADIDAS ORIGINAL"}};
		    	
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    

}

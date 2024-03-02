package Rahulsheteacademy_Selenium_Framewor_Section20.Testcomponents;

import java.io.IOException;
import java.util.HashMap;
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

public class Purchase extends Basetest{

	//storing the name of product in a STRING
	String product_name = "ZARA COAT 3";
	
		 //running using test method
	     //Declaring the data provider
		     @Test(dataProvider="getData")
		     public void submitorders(HashMap<String,String> input) throws IOException, InterruptedException {
		   
		    	
		   
				
					   				    	   
				   //calling the method inorder to send the data
					   DashboardPage dashboard = LoginPage.loginApplication(input.get("Email"),input.get("Password"));
					
					
					//calling the method getproductlist from dashboard page and storing all list of items in items Webelemenet
					List<WebElement> items = dashboard.getProductlist();
					
					////Below command will do add to card after identifying the element
					dashboard.addproducttocart(input.get("productname"));
					
					
					//clicking on add to cart
					Goto_CartPage cart = dashboard.gotocart();
					
					
					//checking if the item is present in add to cart section
					boolean match = cart.matchvalue(input.get("productname"));
					
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
		    	
		    	
		    	//creating object hashmap
		    	//value can be anything so placing object, object
		    	HashMap <Object, Object> map = new HashMap<Object, Object>();
		    	
		    	map.put("Email","pigu2587@gmaail.com");
		    	map.put("Password", "Pr@jyot02");
		    	map.put("productname","ZARA COAT 3");
		    	
	HashMap <Object, Object> map1 = new HashMap<Object, Object>();
		    	
		    	map1.put("Email","abc.com");
		    	map1.put("Password", "pass");
		    	map1.put("productname","ADIDAS ORIGINAL");
		    	
		    	
		    	
		    	
		    	//creating two dimensional array
		    	//object can be int, string,char but we dont kow wat it is so declaring it as Object
		    	//passing the details in curly brackets
		    	//putting the product name as well
		    	return new Object[][] {{map},{map1}};
		    	
		    }
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    

}

package Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulsheteacademy_Selenium_Framewor_Section19.Abstrsctcomponents.Abstractcomponents;

public class OrderPage extends Abstractcomponents {
	 //This is the Goto_CartPage page after logging in

	//in order to define the driver we need to create a constructor
	WebDriver driver;
	
	//creating a constructor which will execute at the beginning in order to assign the driver 
	//check line no. 19 on the section 5 test
	public OrderPage(WebDriver driver)
	{
		//sending the the driver to parent
		super(driver);
		
		//initialization
		this.driver = driver;
		
		//defining driver using page factory and 'initelements' method in order to use it in findby method
		PageFactory.initElements(driver, this);
		
		
	}
	
	//we must try and get the unique ways to identify the products
	//grabbing all the names from the cart section by using a locator which is common to identify the names
	@FindBy(css="tr td:nth child(3)")
	List <WebElement> productname;
	
	//iterating through all the names using stream and checking if the cart contains the name which we want
	//anymatch will check if product name text it retrieves is eqaul to product name
	//boolean will return true
	public Boolean VerifyOrderDisplay(String product_name) {
		Boolean match =	productname.stream().anyMatch(c->c.getText().equalsIgnoreCase(product_name));
		return match;
		}
	
	
	
}

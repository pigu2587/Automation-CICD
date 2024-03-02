package Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rahulsheteacademy_Selenium_Framewor_Section19.Abstrsctcomponents.Abstractcomponents;

public class Checkoutpage extends Abstractcomponents {
	
	 //This is the Checkout page after logging in

		//in order to define the driver we need to create a constructor
		WebDriver driver;
		
		//creating a constructor which will execute at the beginning in order to assign the driver 
		//check line no. 19 on the section 5 test
		public Checkoutpage(WebDriver driver)
		{
			//sending the the driver to parent
			super(driver);
			
			//initialization
			this.driver = driver;
			
			//defining driver using page factory and 'initelements' method in order to use it in findby method
			PageFactory.initElements(driver, this);
			
			
		}
	    
		
		//In  order to type the the country name following locator is used
		@FindBy(css="input[placeholder='Select Country']")
		WebElement Country;
		
		//selecting the country by clicking on it
		@FindBy(css = ("button.ta-item:nth-of-type(2)"))
		WebElement Countryname;
		
		//to click on the button
		@FindBy(css=("a[class*= btn]"))
		WebElement PlaceOrder;
		
        By results = By.cssSelector("section.ta-results"); 

		public void selectcountry(String countryname) {
			//Using the actions class it is easier to do sendkeys
			Actions a = new Actions(driver);
			
			//inorder to make action class work always use build and perform
			//sending the data as india using actions class 
			//just another method to send data using action class instead of using sendkeys
			a.sendKeys(Country,countryname).build().perform();
			
			//explicit wait is declared since its taking some time
			waitforelementtoappear(By.cssSelector("section.ta-results"));
			
			//selecting the country name that we want
			//css-> tagname.classname:nth-of-type()
			Countryname.click();
			
		
		
		}
		
		public confirmation submitorder() {
			PlaceOrder.click();
			return new confirmation(driver);
		}

}

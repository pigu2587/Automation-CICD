package Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulsheteacademy_Selenium_Framewor_Section19.Abstrsctcomponents.Abstractcomponents;

public class confirmation extends Abstractcomponents {
	//This is the Confirmation page after logging in

		//in order to define the driver we need to create a constructor
		WebDriver driver;
		
		//creating a constructor which will execute at the beginning in order to assign the driver 
		//check line no. 19 on the section 5 test
		public confirmation(WebDriver driver)
		{
			//sending the the driver to parent
			super(driver);
			
			//initialization
			this.driver = driver;
			
			//defining driver using page factory and 'initelements' method in order to use it in findby method
			PageFactory.initElements(driver, this);
			
			
		}
		
		@FindBy(css="h1[class='hero-primary']")
		WebElement Confirmationmessage;
		
		public String verifyconfirmation() {
		
			return Confirmationmessage.getText();
			
		}
		
		
		
		
		
		
		
}

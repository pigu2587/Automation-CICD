package Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulsheteacademy_Selenium_Framewor_Section19.Abstrsctcomponents.Abstractcomponents;

public class LoginPage  extends Abstractcomponents {
	  //part1 is the login page

			//in order to define the driver we need to create a constructor
			static WebDriver driver;
			
			//creating a constructor which will execute at the beginning in order to assign the driver 
			//check line no. 26 on the standalone test
			public LoginPage(WebDriver driver)
			{
				
			//inorder to send the driver from child class to parent we use super 
				super(driver);
				
				
				
				//initialization of a driver
				//from line no. 17 we are sending the driver from the standalone test to over here
				//and assigning the driver to the local variable in line no. 13 since the scope of driver is within the method
				this.driver = driver;
				
				//defining driver using page factory and 'initelements' method in order to use it in findby method
				PageFactory.initElements(driver, this);
				
				
			}
			
			//storing the locator of usermail in a web element
            @FindBy(id = "userEmail")
			static
            WebElement Email;
            
            
			//another method to define a locator and stroe it in Webelement is findelement method
			//now we need to give the details of driver so we pass it in a constructor using pagefactory
			@FindBy(id="userPassword")
			static
			
			//storing the locator of password in a web element
			WebElement Password;
			
			@FindBy(id="login")
			static
			WebElement login;
			
			@FindBy(css= "[class*='flyInOut']")
			WebElement errormessage;
			
			public String getErrorMessage() {
				waitforWebelementtoappear(errormessage);
				return errormessage.getText();
			}
			
			
			//implementing the Action method
			public static DashboardPage loginApplication(String name, String pass) {
				
				
				//taking the webelement dot sendkeys and it is not hardcoded and strings are used for it
				Email.sendKeys(name);
				
				//taking the webelement dot sendkeys and it is not hardcoded and strings are used for it
				Password.sendKeys(pass);
				
				//webelement dot click
				login.click();
				
				//since we know the next page is dashboard page  we are assigning it over here
				DashboardPage dashboard = new DashboardPage(driver);
				
				return dashboard;
			}
			
			//creating a method inorder to go to the desired link by calling the method
			public static void goTo() {
				 driver.get(("https://rahulshettyacademy.com/client"));
			}
			
		
			
			
}
			
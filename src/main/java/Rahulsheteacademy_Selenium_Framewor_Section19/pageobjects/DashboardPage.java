package Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Rahulsheteacademy_Selenium_Framewor_Section19.Abstrsctcomponents.Abstractcomponents;

public class DashboardPage extends Abstractcomponents {
	  //This is the dashboard page after logging in

			//in order to define the driver we need to create a constructor
			WebDriver driver;
			
			//creating a constructor which will execute at the beginning in order to assign the driver 
			//check line no. 19 on the section 5 test
			public DashboardPage(WebDriver driver)
			{
				//sending the the driver to parent
				super(driver);
				
				//initialization
				this.driver = driver;
				
				//defining driver using page factory and 'initelements' method in order to use it in findby method
				PageFactory.initElements(driver, this);
				
				
			}
			
			
			
			//another method to define a locator and stroe it in Webelement is findelement method
			//now we need to give the details of driver so we pass pagefactory method in a  constructor
			@FindBy(css=".mb-3")
			List <WebElement> elements;
			
			//wait for element to disappear
			@FindBy(css=".ng-animating")
			WebElement Spinner;
			
			//@FindBy(css="[class*='flyInOut']")
		//	WebElement errormessage;
			
			//public void errormessage() {
			//	waitforelementtoappear(errormessage);
				//errormessage.getText();
		//	}
			
			//passing the productby locator in waitforelement method which is called below 
			By productby = By.cssSelector(".mb-3");
			
			//passing the addtocart locator in addproducttocart method which is called below
			By addtocart =By.cssSelector("div.card-body button:last-of-type"); 
			
			//passing the toast message in addproducttocart method which is called below
			By toastmessage = By.id("toast-container");
			
			//Implementing action method
			//since it will return list type is changed to list<webelement>
			public List<WebElement> getProductlist() {
				
				//calling the method and passing the locator 
				waitforelementtoappear(productby);
				
				//returning all the elements
				return elements;
			}
			
			//implementing action method inorder to check whether the item is present
			public WebElement getProductByname(String product_name) {
				//Prod will store the value which is required for the user
				//converting items to stream and filtering it to get its name by using gettext
				//comparing the extracted text to string using equals 
				//find first will return the name which it found at the very first
				//or else null means the name is not present
				//getproductList() will have all the stored values
				WebElement prod = getProductlist().stream().filter(i->i.findElement(By.cssSelector("b")).getText().equals(product_name)).findFirst().orElse(null);
				
				//returning the value
				return prod;
			}
			
			//
			
			
			public  void addproducttocart(String product_name) throws InterruptedException {
				
			    //adding the product in prod  
				WebElement prod = getProductByname(product_name);
				
				//Below command will do add to card on the item added in prod
				prod.findElement(addtocart).click();
				
				//explicit wait to appear
				waitforelementtoappear(toastmessage);
				
				//explicitly wait to disappear
				waitforelemenettodisappear(Spinner);
				
			}

			
			
			
}
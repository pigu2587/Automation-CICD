package Rahulsheteacademy_Selenium_Framewor_Section19.Abstrsctcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.Goto_CartPage;
import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.OrderPage;



public class Abstractcomponents{
     
	//Parent class of all the class
	
	
	//in order to define the driver we need to create a constructor
	WebDriver driver;
	
	



	//creating a constructor in order to define the driver
	public  Abstractcomponents(WebDriver driver) {
		
		super();
		
         this.driver = driver;
         
         PageFactory.initElements(driver, this);
	}

	
	public void waitforelementtoappear(By findBy) {
		//We want to wait till products are  shown
		//instead of using thread.sleep we are  using explicit waits
		//applying wait globally
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//instead of putting by locator we are using findby method and defining it in waitforelementtoappear method
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitforWebelementtoappear(WebElement findBy) {
		//We want to wait till products are  shown
		//instead of using thread.sleep we are  using explicit waits
		//applying wait globally
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//instead of putting by locator we are using findby method and defining it in waitforelementtoappear method
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitforelemenettodisappear(WebElement ele) throws InterruptedException {
		
		Thread.sleep(2000);
		//we want to wait till products disappear
		//using explicit wait and applying wait globally
		//WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//since it is a webelement we are using WebElement ele instead of By findBy which is used in above method
		//wait1.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
	
	//Assigning locator of add to cart button to cartheader
	@FindBy(css="[routerlink*='cart']")
	WebElement cartheader;
	
	//Assigning locator of add to cart button to cartheader
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderheader;
	
	
	
	public Goto_CartPage gotocart() {
		
		//defining driver using page factory and 'initelements' method in order to use it in findby method
		//click on add to cart
		cartheader.click();
		
		//returning goto cart page so that we dont have to create an object
		Goto_CartPage cart = new Goto_CartPage(driver);
		return cart;
	}
	
	
	public OrderPage gotoOrderspage() {
		
		//defining driver using page factory and 'initelements' method in order to use it in findby method
		//click on add to cart
		orderheader.click();
		
		//returning goto cart page so that we dont have to create an object
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}
	
	
	
	

}
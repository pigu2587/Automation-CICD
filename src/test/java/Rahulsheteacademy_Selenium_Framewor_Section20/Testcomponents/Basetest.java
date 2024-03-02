package Rahulsheteacademy_Selenium_Framewor_Section20.Testcomponents;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Rahulsheteacademy_Selenium_Framewor_Section19.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

     //declaring driver globally
	public WebDriver driver;
	
	//inorder to define a driver we need to create a constructor
	public LoginPage loginpage;
	
	//intializing a method
	public WebDriver initializedriver() throws IOException {
		
		//created a file in global properties and gave value browser = chrome
		//creating object of properties class
		Properties prop = new Properties();
		
		//creating object of fileinputstream inorder to send it load method
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"src\\test\\java\\Rahulsheteacademy_Selenium_Framewor_Section20\\Resouces\\GlobalData.properties");
		
		//using load method
		prop.load(fis);
		
		String browsername = 	System.getProperty("broswer")!=null ? System.getProperty("browser"): prop.getProperty("browser");
		
		//getting the value of browser from global properties file over here
		// prop.getProperty("browser");
	
		//if the browser is chrome
	if(browsername.equalsIgnoreCase("Chrome"))
	{
	
	ChromeOptions option = new ChromeOptions();
	WebDriverManager.chromedriver().setup();
	if(browsername.contains("headless")) {
		option.addArguments("headless");
	}
		//use chrome logic to invoke the broswer
	  driver = new ChromeDriver(option);
	  driver.manage().window().setSize(new Dimension (1440,900));
	} 
	
	//else if it is edge
	else if(browsername.equalsIgnoreCase("Edge"))
	{
		//use edge logic to invoke the browser
		 driver = new EdgeDriver();
	}
	
	//else if browser is firefox
	else if(browsername.equalsIgnoreCase("Firefox"))
	{
		//invoke firefox browser
		 driver = new FirefoxDriver();
	}
	
	
    //waiting for 3 seconds to load the page
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//to maximize the windows
	driver.manage().window().maximize();
	return driver;
	
	
	
	}
  //applying before method
  @BeforeMethod(alwaysRun = true)
   public LoginPage launchapplication() throws IOException {
	  
	  //initializedriver method output is driver
	   driver = initializedriver();
	   
	   
	    //creating an object of another test
       loginpage = new LoginPage(driver);
       
       
	   //getting the URL by calling the method
	   LoginPage.goTo();
       return loginpage;  
       }
  
       @AfterMethod(alwaysRun = true)
       public void teardown() {
    	   driver.close();
         }
       
       public getjsontomap() {
   		
   		//reading json to string
   		String jsoncontent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src//test//java//Rahulsheteacademy_Selenium_Framework_Section21//data//Purchase.json"),
   				             StandardCharsets.UTF_8);
   	
   	    //string to jackson data bind
   		ObjectMapper mapper = new ObjectMapper();
   		
   		
   		
   		
   		
   		
   		
   		
   		
   		return data;
   		
   		
   	 public String getscreenshot(String testCaseName, WebDriver driver) throws IOException {
	    	//
	    	TakesScreenshot ts =  (TakesScreenshot)driver;
	    	//
	    File source = 	ts.getScreenshotAs(OutputType.FILE);
	    
	    //
	    File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName + ".png");
	    
	    //
	    FileUtils.copyFile(source, file);
	    
	    return System.getProperty("user.dir")+"//reports//"+testCaseName + ".png";
	    
	    }
   	
    
   
	
    }



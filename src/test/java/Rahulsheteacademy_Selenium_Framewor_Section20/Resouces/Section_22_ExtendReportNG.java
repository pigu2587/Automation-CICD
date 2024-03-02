package Rahulsheteacademy_Selenium_Framewor_Section20.Resouces;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Section_22_ExtendReportNG {
	
	public static ExtentReports getproject() {
	//Claases used over here are ExtentReports and ExtentSparkReporter
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		
		//renaming a report
		report.config().setReportName("Web Automation Results");
		
		//
		report.config().setDocumentTitle("Test Results");
		
		
		//
		ExtentReports extent = new ExtentReports();
		
		//inorder to give knowledge of object to class		
		extent.attachReporter(report);
		
		//
		extent.setSystemInfo("Tester", "Prajyot");
		
		return extent;
	}

}

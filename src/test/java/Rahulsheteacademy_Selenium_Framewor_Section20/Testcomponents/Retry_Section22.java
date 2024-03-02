package Rahulsheteacademy_Selenium_Framewor_Section20.Testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Section22 implements IRetryAnalyzer {



@Override
public boolean retry(ITestResult result) {
	
	int count = 0;
	int maxcount = 1;
			if(count<maxcount)
			{
				count++;
				return true;
			}
	// TODO Auto-generated method stub
	return false;
   }
}

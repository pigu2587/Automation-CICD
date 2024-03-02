package Rahulsheteacademy_Selenium_Framework_Section21.data;

import java.io.File;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Datareader {
	
	public getjsontomap(String filepath) {
		
		//reading json to string
		String jsoncontent = FileUtils.readFileToString(new File(filepath),
				             StandardCharsets.UTF_8);
	
	    //string to jackson data bind
		ObjectMapper mapper = new ObjectMapper();
		
		
		
		
		
		
		
		
		
		return data;
	
	
	
	
	
	}

}

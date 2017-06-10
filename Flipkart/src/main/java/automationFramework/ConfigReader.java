package automationFramework;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class ConfigReader {
	static  String serverurl = null;
	static String browserType = null;
	static  String username = null;
	static String password = null;
	Logger logger = Logger.getLogger(AccountLogin.class);
	
	
	public  static Object[][] configParameterReader(String env , String browser){
		System.out.println(1);
		File configFile = new File("/home/prospera-user12/Desktop/Flipkart/src/main/resources/config.properties");
	
	try {
	    FileReader reader = new FileReader(configFile);
	    Properties props = new Properties();
	    props.load(reader);
	     username = props.getProperty("USERNAME");
	    password = props.getProperty("PASSWORD");
	 
	    if(env.equalsIgnoreCase("stage")){
	    	serverurl = props.getProperty("STAGE_URL");
	    	
	    }else if(env.equalsIgnoreCase("uat")){
	    	 serverurl = props.getProperty("UAT_URL");
		    	
	    }else{
	    	 serverurl = props.getProperty("PROD_URL");
	    	
	    }
	    
	    if(browser.equalsIgnoreCase("Firefox")){
	    	browserType = props.getProperty("FIREFOX_BROWSER");
	    	
	    }else if(browser.equalsIgnoreCase("Chrome")){
	    	browserType = props.getProperty("CHROME_BROWSER");
		    	
	    }
	   
	    
	   
	    System.out.print("serverurl name is: " + serverurl);
	    System.out.print("browsertype name is: " + browserType);
	    System.out.print("username name is: " + username);
	    System.out.print("password name is: " + password);
	    
	  
	    reader.close();
	    return  new Object[][]{ {serverurl, browserType,username,password}}; 
	} catch (Exception e) {
	    e.printStackTrace();
	    
	}
	 return  new Object[][] { {null, null,null,null}};
	}
}

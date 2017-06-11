package automationFramework;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigReader {
	static  String serverurl = null;
	static String browserType = null;
	static  String username = null;
	static String password = null;
	static Logger logger = Logger.getLogger(ConfigReader.class);
	
	
	public  static List<String> configParameterReader(String env , String browser){
		
		File configFile = new File("/home/prospera-user12/git/Flipkart/Flipkart/src/main/resources/config.properties");
		logger.debug("Accessing Configuratio File to read Required parameters");
		List<String> parameters =new ArrayList<String>();							
	try {
	    FileReader reader = new FileReader(configFile);
	    Properties props = new Properties();
	    props.load(reader);
	    logger.debug("Reading Configuration file");
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
	   logger.debug("Parameters are available");
	    
	   
	    System.out.print("serverurl name is: " + serverurl);
	    System.out.print("browsertype name is: " + browserType);
	    System.out.print("username name is: " + username);
	    System.out.print("password name is: " + password);
	    
	  
	     reader.close();
	     parameters.add(serverurl);
	     parameters.add(browserType);
	     parameters.add(username);
	     parameters.add(password);
	     
	     logger.debug("Parameters are added to list");
	     logger.debug("Parameters sent to calling function");
	     return parameters;
	     
	} catch (Exception e) {
	    
	    
	    
	}
	 return null;
	}
}

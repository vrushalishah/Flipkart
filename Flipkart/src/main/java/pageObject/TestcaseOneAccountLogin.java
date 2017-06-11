package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationFramework.ConfigReader;
import automationFramework.StaticWebElementFinder;

public class TestcaseOneAccountLogin {

	
	/*@DataProvider(name = "ParamProvider")
	public static Object[][] dataProvider() {

		return ConfigReader.configParameterReader("stage", "Firefox");

	}*/
	Logger logger = Logger.getLogger(TestcaseOneAccountLogin.class);
	WebDriver driver =null;
	//@Test(dataProvider = "ParamProvider", dataProviderClass = TestcaseOneAccountLogin.class)
	public WebDriver accountLogin(String url, String executionBrowser,String userName,String password) {
 
		
		try {
			
			
			if (url == null || executionBrowser == null) {

				logger.error("Website url is incorrect,check for valid url");
			} else {
				if (executionBrowser.equalsIgnoreCase("Chrome")) {

					driver = new ChromeDriver();
					logger.debug("Chrome Browser is Executed");

				} else if (executionBrowser.equalsIgnoreCase("Firefox")) {
					driver = new FirefoxDriver();
					logger.debug("Firefox Browser is Executed");
				}

				// Tescase to login to flipkart site
				

				driver.get(url);
				logger.debug("Flipkart Site is Accessible");
				driver.findElement(By.xpath(StaticWebElementFinder.signInMenuFinder)).click();
				driver.findElement(By.xpath(StaticWebElementFinder.usernameFinder)).sendKeys(userName);
				driver.findElement(By.xpath(StaticWebElementFinder.passwordFinder)).sendKeys(password);
				logger.debug("Entered Login credential");
				driver.findElement(By.xpath(StaticWebElementFinder.loginFinder)).submit();
				logger.debug("Login successfully");

				System.out.println("Login Successfully");
			}

		} catch (Exception e) {
			logger.error("Login unsuccessfull , please try again");
			driver.close();
		}
		return driver;
		

	}

}

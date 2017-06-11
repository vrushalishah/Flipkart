package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationFramework.StaticWebElementFinder;

public class TestcaseFiveMotorolaCheckBoxVisibility {

	WebDriver driver = null;
	Logger logger = Logger.getLogger(TestcaseFiveMotorolaCheckBoxVisibility.class);

	

	public WebDriver motorolaCheckBoxVisibility(String url, String executionBrowser, String userName, String password) {

		try {
			
			TestcaseThreeMobileHomepage homePage = new TestcaseThreeMobileHomepage();
			logger.debug("Checking motorola checkbox visibility");
			driver = homePage.mobileHomepage(url, executionBrowser, userName, password);
			if (driver == null) {

				logger.debug(" motorolaCheckBoxVisibility driver is null");
			} else {

				logger.debug("Driver is not null");
			}
			StaticWebElementFinder.scrollDown(driver);
			logger.debug("Scrolling down page");
			logger.debug("Scrolling down page");
			logger.debug("finding brand filter textbox");
			driver.findElement(By.xpath(StaticWebElementFinder.brandFilterFinder)).sendKeys("Moto");
			logger.debug("Searching for moto keyword");
			logger.debug("Searching for moto keyword");
		
			WebElement motoCheckBox = null;


			try {
				motoCheckBox = driver.findElement(By.xpath(StaticWebElementFinder.motorolaBrandFinder));

			} catch (Exception e) {
				e.printStackTrace();
			}
			boolean motoCheckVisibility = motoCheckBox.isDisplayed();
			logger.debug("Flag value is : " + motoCheckVisibility);
			logger.debug("Checking Mototrola checkbox visibility");
			logger.debug("Checking Mototrola checkbox visibility");
			if (motoCheckVisibility == true) {
				
				logger.debug("Motorola checkbox is visble");

			} else {
				
				logger.error("Motorola checkbox is not visble");

			}
			return driver;
		} catch (Exception e) {

			logger.error(e.getMessage());
		}
		return driver;
	}
}

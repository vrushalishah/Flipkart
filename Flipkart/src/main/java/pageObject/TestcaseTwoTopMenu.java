package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automationFramework.StaticWebElementFinder;

public class TestcaseTwoTopMenu {

	WebDriver driver = null;
	Logger logger = Logger.getLogger(TestcaseTwoTopMenu.class);

	public WebDriver topMenu(String url, String executionBrowser, String userName, String password) {

		String electronicMenuName = "ELECTRONICS";
		TestcaseOneAccountLogin login = new TestcaseOneAccountLogin();

		try {

			driver = login.accountLogin(url, executionBrowser, userName, password);
			String topMenuName = driver.findElement(By.xpath(StaticWebElementFinder.electronicMenuFinder)).getText();

			logger.debug("Comparing menu names");
			if (topMenuName.equals(electronicMenuName)) {

				logger.debug("Top menu is ELECTRONICS");

			} else {
				logger.debug("Top menu is not ELECTRONICS");

			}
			return driver;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return driver;
	}
}

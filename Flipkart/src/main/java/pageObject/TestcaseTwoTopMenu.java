package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automationFramework.StaticWebElementFinder;

public class TestcaseTwoTopMenu {

	WebDriver driver =null;
	Logger logger = Logger.getLogger(TestcaseTwoTopMenu.class);
	TestcaseOneAccountLogin login = new TestcaseOneAccountLogin();
	public WebDriver topMenu(String url, String executionBrowser,String userName,String password) {

		String electronicMenuName = "ELECTRONICS";
		
		

		try {
			
			driver=	login.accountLogin(url, executionBrowser, userName, password);
			String topMenuName = driver.findElement(By.xpath(StaticWebElementFinder.electronicMenuFinder)).getText();
			
			System.out.println("Comparing menu names");
			if (topMenuName.equals(electronicMenuName)) {

				System.out.println("Top menu is ELECTRONICS");

			} else {
				System.out.println("Top menu is not ELECTRONICS");

			}
			return driver;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
}

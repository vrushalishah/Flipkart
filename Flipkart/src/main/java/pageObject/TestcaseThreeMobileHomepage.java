package pageObject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automationFramework.StaticWebElementFinder;

public class TestcaseThreeMobileHomepage {

	WebDriver driver = null;
	Logger logger = Logger.getLogger(TestcaseThreeMobileHomepage.class);

	public WebDriver mobileHomepage(String url, String executionBrowser, String userName, String password) {
		TestcaseOneAccountLogin login = new TestcaseOneAccountLogin();
		String mobilePageTitle = "Mobiles";
		String mobilePageVisibleTitle = null;

		try {

			driver = login.accountLogin(url, executionBrowser, userName, password);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			StaticWebElementFinder.openMobileHomepage(driver);

			mobilePageVisibleTitle = driver.findElement(By.xpath(StaticWebElementFinder.mobilePageTitleFinder))
					.getText();

			if (mobilePageVisibleTitle.equals(mobilePageTitle)) {

				logger.debug("Open page is mobile home page");

			} else {

				logger.debug("Open page is not mobile home page");
			}

			return driver;
		} catch (Exception e) {

			logger.error(e.getMessage());
		}
		return driver;
	}

}

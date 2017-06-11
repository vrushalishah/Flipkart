package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationFramework.StaticWebElementFinder;

public class TestcaseFiveMotorolaCheckBoxVisibility {

	WebDriver driver = null;
	Logger logger = Logger.getLogger(TestcaseFiveMotorolaCheckBoxVisibility.class);

	TestcaseThreeMobileHomepage homePage = new TestcaseThreeMobileHomepage();

	public WebDriver motorolaCheckBoxVisibility(String url, String executionBrowser, String userName, String password) {

		try {

			logger.debug("Checking motorola checkbox visibility");
			driver = homePage.mobileHomepage(url, executionBrowser, userName, password);
			if (driver == null) {

				System.out.println(" motorolaCheckBoxVisibility driver is null");
			} else {

				System.out.println("Driver is not null");
			}
			StaticWebElementFinder.scrollDown(driver);
			logger.debug("Scrolling down page");
			System.out.println("Scrolling down page");
			System.out.println("finding brand filter textbox");
			driver.findElement(By.xpath(StaticWebElementFinder.brandFilterFinder)).sendKeys("Moto");
			logger.debug("Searching for moto keyword");
			System.out.println("Searching for moto keyword");
			// driver.manage().timeouts().implicitlyWait(3000,
			// TimeUnit.MILLISECONDS);
			// Thread.sleep(3000);
			WebElement motoCheckBox = null;
			// Thread.sleep(3000);

			try {
				motoCheckBox = driver.findElement(By.xpath(StaticWebElementFinder.motorolaBrandFinder));

			} catch (Exception e) {
				e.printStackTrace();
			}
			boolean motoCheckVisibility = motoCheckBox.isDisplayed();
			System.out.println("Flag value is : " + motoCheckVisibility);
			logger.debug("Checking Mototrola checkbox visibility");
			System.out.println("Checking Mototrola checkbox visibility");
			if (motoCheckVisibility == true) {
				System.out.println("checkbox “Motorola” is Present");
				logger.debug("Motorola checkbox is visble");

			} else {
				System.out.println("checkbox “Motorola” is not Present");
				logger.error("Motorola checkbox is not visble");

			}
			return driver;
		} catch (Exception e) {

			logger.error(e.getMessage());
		}
		return driver;
	}
}

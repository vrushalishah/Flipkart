package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationFramework.StaticWebElementFinder;

public class TestcaseSevenOtherBrandItems {

	WebDriver driver = null;
	Logger logger = Logger.getLogger(TestcaseSevenOtherBrandItems.class);

	public WebDriver otherBrandItems(String url, String executionBrowser, String userName, String password) {

		try {
			TestcaseFourFilter4GbRam filterRam = new TestcaseFourFilter4GbRam();
			logger.debug("Searching for items of other brands");

			driver = filterRam.filter4GbRam(url, executionBrowser, userName, password);
			logger.debug("Finding brand check");

			logger.debug("Searching for moto keyword");

			StaticWebElementFinder.scrollDown(driver);
			logger.debug("Scrolling down page");
			logger.debug("Scrolling down page");
			logger.debug("finding brand filter textbox");
			StaticWebElementFinder.scrollDown(driver);
			driver.findElement(By
					.xpath(".//*[@id='container']/div/div[2]/div[2]/div/div[1]/div/div/div[5]/section/div[2]/div[1]/div[1]/input"))
					.sendKeys("Moto");
			logger.debug("Searching for moto keyword");
			logger.debug("Searching for moto keyword");

			driver.findElement(By
					.xpath(".//*[@id='container']/div/div[2]/div[2]/div/div[1]/div/div/div[5]/section/div[2]/div[1]/div[1]/input//following::div[1]"))
					.click();

			driver.findElement(By.xpath(StaticWebElementFinder.clearFilterFinder)).click();

			logger.debug("Clear brand filter");
			int j = 1;
			for (j = 1; j <= 3; j++) {

				driver.findElement(By.xpath(
						".//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div/div[" + j + "]/a"));
				StaticWebElementFinder.scrollDown(driver);
				String motoroloItemDesc = driver.getPageSource();
				if (motoroloItemDesc.contains("Moto") || motoroloItemDesc.contains("Yureka")
						|| motoroloItemDesc.contains("Lenovo")) {

					logger.debug("other brands  mobile item : " + j + "are present");
				} else {

					logger.debug("Other brands mobile are not present");
			
				}

			}
			return driver;
		} catch (Exception e) {
			logger.error(e.getMessage());
		

		}

		return null;
	}
}

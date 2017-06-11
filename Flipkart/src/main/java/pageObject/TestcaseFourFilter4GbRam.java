package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automationFramework.StaticWebElementFinder;

public class TestcaseFourFilter4GbRam {

	WebDriver driver = null;
	Logger logger = Logger.getLogger(TestcaseFourFilter4GbRam.class);
	TestcaseThreeMobileHomepage mobilePage = new TestcaseThreeMobileHomepage();

	public WebDriver filter4GbRam(String url, String executionBrowser, String userName, String password) {

		String fourGbRam = "4 GB RAM";

		try {

			logger.debug("Checking for 4 GB Ram filter");
			driver = mobilePage.mobileHomepage(url, executionBrowser, userName, password);
			if(driver == null){
				
				System.out.println(" TestcaseFourFilter4GbRam  driver is null");
			}
			else{
				
				System.out.println("TestcaseFourFilter4GbRam Driver is not null");
			}
			driver.findElement(By.xpath(StaticWebElementFinder.ramFilterFinder)).click();

			System.out.println("Ram selected");
			logger.debug(" Ram selected");
			StaticWebElementFinder.scrollDown(driver);
			logger.debug("page scrollig down");
			driver.findElement(By.xpath(StaticWebElementFinder.fourbRamFilter)).click();
			System.out.println(" 4GB Ram selected");
			logger.debug("4 GB Ram selected");
			for (int i = 1; i <= 2; i++) {

				driver.findElement(By.xpath(
						".//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div/div[" + i + "]/a"));
				String mobileItemDesc = driver.getPageSource();
				if (mobileItemDesc.contains(fourGbRam)) {

					System.out.println("element : " + i + "is of 4gb ram");
					logger.debug("element : " + i + "is of 4gb ram");

				}

				else {

					System.out.println("element is not of 4gb ram");
					logger.error("element is not of 4gb ram");
					
				}
			}
			return driver;
			
		} catch (Exception e) {

			logger.error(e.getMessage());
			
		}
		return driver;

	}

}

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
			try {
			driver = filterRam.filter4GbRam(url, executionBrowser, userName, password);
			StaticWebElementFinder.scrollDown(driver);
			System.out.println("Finding brand check");
			
			logger.debug("Searching for moto keyword");
			
			// driver.manage().timeouts().implicitlyWait(3000,
			// TimeUnit.MILLISECONDS);
			// Thread.sleep(3000);
			StaticWebElementFinder.scrollDown(driver);
			WebElement motoCheckBox = null;
			// Thread.sleep(3000);

			try {
				motoCheckBox = driver.findElement(By.xpath(StaticWebElementFinder.motorolaBrandFinder));
				motoCheckBox.click();

			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			try {
				driver.findElement(By.xpath(StaticWebElementFinder.clearFilterFinder)).click();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Brand filter gets cleared");
			logger.debug("Clear brand filter");
			int j = 1;
			for (j = 1; j <= 3; j++) {

				driver.findElement(By.xpath(
						".//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div/div[" + j + "]/a"));
				StaticWebElementFinder.scrollDown(driver);
				String motoroloItemDesc = driver.getPageSource();
				if (motoroloItemDesc.contains("Moto") || motoroloItemDesc.contains("Yureka")
						|| motoroloItemDesc.contains("Lenovo")) {

					System.out.println("other brands  mobile item : " + j + "are present");
					logger.debug("other brands  mobile item : " + j + "are present");
				} else {

					System.out.println("Other brands mobile are not present");
					driver.close();
				}

			}
			return driver;
		} catch (Exception e) {
			logger.error(e.getMessage());
			driver.close();

		}
		return null;
	}
}

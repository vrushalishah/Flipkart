package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automationFramework.StaticWebElementFinder;

public class TestcaseEightMotoG5PlusDetail {

	WebDriver driver = null;
	Logger logger = Logger.getLogger(TestcaseSixMotoItems.class);

	TestcaseFiveMotorolaCheckBoxVisibility motorolaSelect = new TestcaseFiveMotorolaCheckBoxVisibility();

	public WebDriver motoG5PlusDetail(String url, String executionBrowser, String userName, String password) {

		String pincode = "411030";

		try {

			logger.debug("Motorola Detail View");
			driver = motorolaSelect.motorolaCheckBoxVisibility(url, executionBrowser, userName, password);

			if (driver == null) {

				System.out.println("driver is null");
			}

			driver.findElement(By.xpath(StaticWebElementFinder.motorolaBrandFinder)).click();
			logger.debug("Motorola Brand selected");
			String winHandleBefore = driver.getWindowHandle();
			driver.findElement(By.xpath(StaticWebElementFinder.motog5PlusItemFinder)).click();
		
			logger.debug("Moto 5 plus item selected");
			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				
				//driver.get(driver.getCurrentUrl());
				System.out.println("Page Title is :" + driver.getTitle());

				logger.debug("Moto 5 plus item selected");
				String text = "Moto G5 Plus (Lunar Grey, 32 GB)";
				String temp = driver.getPageSource();

				if (temp.contains(text)) {

					System.out.println("New Tab is accessible");
					logger.debug("New Tab is accessible");
					try{
						System.out.println(driver.findElement(By.id("pincodeInputId")).getText()+"  id of pincode");
					}catch(Exception e){
						e.printStackTrace();
					}
					System.out.println("nikhil");
					
					driver.findElement(By.id("pincodeInputId")).sendKeys(pincode);
					logger.debug("Pincode enterd");
					StaticWebElementFinder.scrollDown(driver);
					driver.findElement(By.xpath(StaticWebElementFinder.goToCartButtonFinder)).click();
					logger.debug("Item Added in Cart is in process");
					System.out.println("Page Title is  :" + driver.getTitle());
					System.out.println("Product is add to cart");
					logger.debug("Item added to cart..");
					StaticWebElementFinder.captureScreenShot(driver, "../ScreenShot/MobileAddToCartCaputre.png");
					logger.debug("Screenshot has been taken");
					System.out.println("Screeen shot Taken");

				} else {

					System.out.println("New Tab is not accesssible");
					logger.error("New Tab is not accesssible");

				}
			}
			return driver;

		} catch (Exception e) {

			logger.error(e.getMessage());

		}
		return driver;

	}

}

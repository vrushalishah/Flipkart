package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automationFramework.StaticWebElementFinder;

public class TestcaseEightMotoG5PlusDetail {

	WebDriver driver = null;
	Logger logger = Logger.getLogger(TestcaseSixMotoItems.class);

	

	public WebDriver motoG5PlusDetail(String url, String executionBrowser, String userName, String password) {

		String pincode = "411030";
		TestcaseFiveMotorolaCheckBoxVisibility motorolaSelect = new TestcaseFiveMotorolaCheckBoxVisibility();
		try {

			logger.debug("Motorola Detail View");
			driver = motorolaSelect.motorolaCheckBoxVisibility(url, executionBrowser, userName, password);

			if (driver == null) {

				logger.debug("driver is null");
			}

			driver.findElement(By.xpath(StaticWebElementFinder.motorolaBrandFinder)).click();
			logger.debug("Motorola Brand selected");
			String winHandleBefore = driver.getWindowHandle();
			driver.findElement(By.xpath(StaticWebElementFinder.motog5PlusItemFinder)).click();
		
			logger.debug("Moto 5 plus item selected");
			
			// Switch to new window opened
			try{
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);

				logger.debug("Moto 5 plus item selected");
				String tempTextGoToCart = "GO TO CART";
				String tempTextAddToCart = "ADD TO CART";
				String temp = driver.getPageSource();
				
				if (temp.contains(tempTextGoToCart)||temp.contains(tempTextAddToCart)) {

					
					logger.debug("New Tab is accessible");
					
					driver.findElement(By.id("pincodeInputId")).sendKeys(pincode);
					logger.debug("Pincode enterd");
					StaticWebElementFinder.scrollDown(driver);
					driver.findElement(By.xpath(StaticWebElementFinder.goToCartButtonFinder)).click();
					logger.debug("Item Added in Cart is in process");
					logger.debug("Page Title is  :" + driver.getTitle());
					logger.debug("Product is add to cart");
					logger.debug("Item added to cart..");
					StaticWebElementFinder.captureScreenShot(driver,"../ScreenShot/MobileAddToCartCaputre.png");
					logger.debug("Screenshot has been taken");
					logger.debug("Screeen shot Taken");
					driver.close();
					logger.debug("Sub window is closed");
					driver.switchTo().window(winHandleBefore); 
					logger.debug("Switched to Parent Window");
				} else {

					logger.error("New Tab is not accesssible");

				}
			}
				}catch(Exception e){
					
					logger.error(e.getMessage());
				}
			
			return driver;

		} catch (Exception e) {

			logger.error(e.getMessage());

		}
		return driver;

	}

}

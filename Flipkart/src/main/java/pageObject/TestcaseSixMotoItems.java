package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automationFramework.StaticWebElementFinder;

public class TestcaseSixMotoItems {

	
	WebDriver driver = null;
	Logger logger = Logger.getLogger(TestcaseSixMotoItems.class);
	
	
	
	public WebDriver motoItems(String url, String executionBrowser,String userName,String password) {

		try {
			

			TestcaseFiveMotorolaCheckBoxVisibility motorolaSelect = new TestcaseFiveMotorolaCheckBoxVisibility();
			logger.debug("MotoItem method called");
			driver = motorolaSelect.motorolaCheckBoxVisibility(url,executionBrowser,userName,password);
			try{
				driver.findElement(By.xpath(StaticWebElementFinder.motorolaBrandFinder)).click();
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
			
			int i = 1;
			for (i = 1; i <= 2; i++) {

				driver.findElement(By.xpath(
						".//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div/div[" + i + "]/a"));
				logger.debug("Motorola mobile Item :" + i +" description");
				String motoroloItemDesc = driver.getPageSource();
				if (motoroloItemDesc.contains("Moto")) {

					logger.debug("Motorola mobile items : "+ i+ "present");
				}
			}
			return driver;
			}catch(Exception e){
				logger.error(e.getMessage());
			}

		return driver;
	}
}

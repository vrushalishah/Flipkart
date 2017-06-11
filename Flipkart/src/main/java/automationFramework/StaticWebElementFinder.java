package automationFramework;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class StaticWebElementFinder {

	public static String signInMenuFinder = ".//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[8]/a";
	public static String usernameFinder = ".//div[3]/div/div/div/div/div[2]/div/form/div[1]/input";
	public static String passwordFinder = ".//div[3]/div/div/div/div/div[2]/div/form/div[2]/input";
	public static String loginFinder = ".//div[3]/div/div/div/div/div[2]/div/form/div[3]/button";
	public static String electronicMenuFinder = ".//*[@id='container']/div/header/div[2]/div/ul/li[1]/a/span";
	public static String submenuMobileFinder = ".//*[@id='container']/div/header/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[1]/a/span[1]";
	public static String mobilePageTitleFinder = ".//*[@id='container']/div/div[2]/div/div[1]/h1";
	public static String ramFilterFinder = ".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[4]/section/div";
	public static String fourbRamFilter = ".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[4]/section/div[2]/div/div[6]/div/div/label/div[1]";
	public static String brandFilterFinder = ".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[5]/section/div[2]/div[1]/div[1]/input";
	public static String motorolaBrandFinder = ".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[5]/section/div[2]/div[1]/div[2]/div/div";
	public static String clearFilterFinder = ".//*[@id='container']/div/div[2]/div[2]/div/div[1]/div/div/div[5]/section/div[2]/div[1]/div[1]/div[1]";
	public static String motog5PlusItemFinder = ".//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div/div[2]/a/div[2]/div[1]/div[1]";
	public static String goToCartButtonFinder = ".//*[@id='container']/div/div[2]/div/div/div[1]/div/div[1]/div/div/div[2]/ul/li[1]/button";
	public static Logger logger = Logger.getLogger(StaticWebElementFinder.class);
	
	
	//Method to page scroll down
	public static void scrollDown(WebDriver driver) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

	}

	//Method to accessing mobile home page
	public static void openMobileHomepage(WebDriver driver) {
		
		driver.findElement(By.xpath(electronicMenuFinder)).click();
		driver.findElement(By.xpath(submenuMobileFinder)).click();	
	}
	
	//Method to capture screenshot
	public static void captureScreenShot(WebDriver webdriver, String fileWithPath) {

		// Convert web driver object to TakeScreenshot
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

			// Call getScreenshotAs method to create image file

			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination

			File DestFile = new File(fileWithPath);

			// Copy file at destination

			FileUtils.copyFile(SrcFile, DestFile);

		} catch (Exception e) {

			logger.error(e.getMessage());
		}
	}

}




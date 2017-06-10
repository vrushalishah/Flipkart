package automationFramework;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class AccountLogin {

	WebDriver driver = null;
	Logger logger = Logger.getLogger(AccountLogin.class);


	String signInMenuFinder = ".//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[8]/a";
	String usernameFinder = ".//div[3]/div/div/div/div/div[2]/div/form/div[1]/input";
	String passwordFinder = ".//div[3]/div/div/div/div/div[2]/div/form/div[2]/input";
	String loginFinder = ".//div[3]/div/div/div/div/div[2]/div/form/div[3]/button";
	String electronicMenuFinder = ".//*[@id='container']/div/header/div[2]/div/ul/li[1]/a/span";
	String submenuMobileFinder = ".//*[@id='container']/div/header/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[1]/a/span[1]";
	String mobilePageTitleFinder = ".//*[@id='container']/div/div[2]/div/div[1]/h1";
	String ramFilterFinder = ".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[4]/section/div";
	String fourbRamFilter = ".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[4]/section/div[2]/div/div[6]/div/div/label/div[1]";
	String brandFilterFinder = ".//*[@id='container']/div/div[2]/div[2]/div/div[1]/div/div/div[5]/section/div[2]/div[1]/div[1]/input";
	String motorolaBrandFinder = ".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[5]/section/div[2]/div[1]/div[5]/div/div/label/div[1]";
	String clearFilterFinder = ".//*[@id='container']/div/div[2]/div[2]/div/div[1]/div/div/div[5]/section/div[2]/div[1]/div[1]/div[1]";
	String motog5PlusItemFinder = ".//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div/div[2]/a/div[2]/div[1]/div[1]";
	String goToCartButtonFinder = ".//*[@id='container']/div/div[2]/div/div/div[1]/div/div[1]/div/div/div[2]/ul/li[1]/button";

	@DataProvider(name = "ParamProvider")
	public static Object[][] dataProvider() {

		return ConfigReader.configParameterReader("stage", "Firefox");

	}

	@Test(dataProvider = "ParamProvider", dataProviderClass = AccountLogin.class)
	public void TestcaseOneAccountLogin(String url, String executionBrowser,String userName,String password) {

		try {
			
			
			if (url == null || executionBrowser == null) {

				logger.error("Website url is incorrect,check for valid url");
			} else {
				if (executionBrowser.equalsIgnoreCase("Chrome")) {

					driver = new ChromeDriver();
					logger.debug("Chrome Browser is Executed");

				} else if (executionBrowser.equalsIgnoreCase("Firefox")) {
					driver = new FirefoxDriver();
					logger.debug("Firefox Browser is Executed");
				}

				// Tescase to login to flipkart site
				driver = new FirefoxDriver();
				driver.get(url);
				driver.findElement(By.xpath(signInMenuFinder)).click();
				driver.findElement(By.xpath(usernameFinder)).sendKeys(userName);
				driver.findElement(By.xpath(passwordFinder)).sendKeys(password);
				driver.findElement(By.xpath(loginFinder)).submit();
				logger.debug("Login successfully");

				System.out.println("Login Successfully");
			}

		} catch (Exception e) {
			logger.error("Login unsuccessfull");
			System.exit(0);
			driver.close();
		}

	}

	public void scrollDown() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

	}

	public void openMobileHomepage() {

		driver.findElement(By.xpath(electronicMenuFinder)).click();
		driver.findElement(By.xpath(submenuMobileFinder)).click();

	}
	@Test(dataProvider = "ParamProvider", dataProviderClass = AccountLogin.class)
	public void TestcaseTwoTopMenu(String url, String executionBrowser,String userName,String password) {

		String electronicMenuName = "ELECTRONICS";
		String topMenuName = driver.findElement(By.xpath(electronicMenuFinder)).getText();
		

		try {
			
			TestcaseOneAccountLogin(url, executionBrowser, userName, password);
			if (topMenuName.equals(electronicMenuName)) {

				System.out.println("Top menu is ELECTRONICS");

			} else {
				System.out.println("Top menu is not ELECTRONICS");

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Test(dataProvider = "ParamProvider", dataProviderClass = AccountLogin.class)
	public void TestcaseThreeMobileHomepage(String url, String executionBrowser,String userName,String password) {

		String mobilePageTitle = "Mobiles";
		String mobilePageVisibleTitle = null;

		try {
			TestcaseOneAccountLogin(url, executionBrowser,userName,password);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			openMobileHomepage();

			mobilePageVisibleTitle = driver.findElement(By.xpath(mobilePageTitleFinder)).getText();

			if (mobilePageVisibleTitle.equals(mobilePageTitle)) {

				System.out.println("Open pages is mobile home page");

			} else {

				System.out.println("Open pages is not mobile home page");
			}

		} catch (Exception e) {

			logger.error(e.getMessage());
		}
	}
	@Test(dataProvider = "ParamProvider", dataProviderClass = AccountLogin.class)
	public void TestcaseFourFilter4GbRam(String url, String executionBrowser,String userName,String password) {

		String fourGbRam = "4 GB RAM";

		try {

			TestcaseThreeMobileHomepage(url,executionBrowser,userName,password);

			driver.findElement(By.xpath(ramFilterFinder)).click();

			System.out.println("Ram selected");

			scrollDown();

			driver.findElement(By.xpath(fourbRamFilter)).click();
			System.out.println(" 4GB Ram selected");

			for (int i = 1; i <= 2; i++) {

				driver.findElement(By.xpath(
						".//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div/div[" + i + "]/a"));
				String mobileItemDesc = driver.getPageSource();
				if (mobileItemDesc.contains(fourGbRam)) {

					System.out.println("element is of 4gb ram");

				} else {

					System.out.println("element is not of 4gb ram");
				}
			}

		} catch (Exception e) {

			logger.error(e.getMessage());
		}

	}


	@Test(dataProvider = "ParamProvider", dataProviderClass = AccountLogin.class)
	public void TestcaseFiveMotorolaCheckBoxVisibility(String url, String executionBrowser,String userName,String password) {

		try {
			TestcaseThreeMobileHomepage(url,executionBrowser,userName,password);
			scrollDown();

			driver.findElement(By.xpath(brandFilterFinder)).sendKeys("Moto");
			WebElement MotoCheckBox = driver.findElement(By.xpath(motorolaBrandFinder));
			boolean motoCheckVisibility = MotoCheckBox.isDisplayed();

			if (motoCheckVisibility == true) {
				System.out.println("checkbox “Motorola” is Present");

			} else {
				System.out.println("checkbox “Motorola” is not Present");

			}
		} catch (Exception e) {

			logger.error(e.getMessage());
		}
	}
	@Test(dataProvider = "ParamProvider", dataProviderClass = AccountLogin.class)
	public void TestcaseSixMotoItems(String url, String executionBrowser,String userName,String password) {

		try {
			TestcaseFiveMotorolaCheckBoxVisibility(url,executionBrowser,userName,password);
			driver.findElement(By.xpath(motorolaBrandFinder)).click();
			int i = 1;
			for (i = 1; i <= 2; i++) {

				driver.findElement(By.xpath(
						".//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div/div[" + i + "]/a"));
				String motoroloItemDesc = driver.getPageSource();
				if (motoroloItemDesc.contains("Moto")) {

					System.out.println("Motorola mobile items are present");
				}

			}
		} catch (Exception e) {

			logger.error(e.getMessage());

		}
	}
	@Test(dataProvider = "ParamProvider", dataProviderClass = AccountLogin.class)
	public void TestcaseSevenOtherBrandTems(String url, String executionBrowser,String userName,String password) {

		try {
			TestcaseFourFilter4GbRam(url,executionBrowser,userName,password);
			driver.findElement(By.xpath(motorolaBrandFinder)).click();

			driver.findElement(By.xpath(clearFilterFinder)).click();
			int j = 1;
			for (j = 1; j <= 3; j++) {

				driver.findElement(By.xpath(
						".//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div/div[" + j + "]/a"));
				String motoroloItemDesc = driver.getPageSource();
				if (motoroloItemDesc.contains("Moto") || motoroloItemDesc.contains("Yureka")
						|| motoroloItemDesc.contains("Lenovo")) {

					System.out.println("other brands  mobile items are present");
				} else {

					System.out.println("Other brands mobile are not present");
				}

			}
		} catch (Exception e) {
			logger.error(e.getMessage());

		}
	}
	@Test(dataProvider = "ParamProvider", dataProviderClass = AccountLogin.class)
	public void TestcaseEightMotoG5PlusDetail(String url, String executionBrowser,String userName,String password) {

		String pincode = "411030";

		try {

			TestcaseFiveMotorolaCheckBoxVisibility(url,executionBrowser,userName,password);
			driver.findElement(By.xpath(motorolaBrandFinder)).click();

			String winHandleBefore = driver.getWindowHandle();
			driver.findElement(By.xpath(motog5PlusItemFinder)).click();

			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				System.out.println("Page Title is :" + driver.getTitle());

				String text = "Usually delivered in 3-4 days.";
				String temp = driver.getPageSource();

				if (temp.contains(text)) {

					System.out.println("New Tab is accessible");
					driver.manage().window().maximize();
					driver.findElement(By.id("pincodeInputId")).sendKeys(pincode);

					driver.findElement(By.xpath(goToCartButtonFinder)).click();
					System.out.println("Page Title is  :" + driver.getTitle());
					System.out.println("Product is add to cart");
					captureScreenShot(driver, "../ScreenShot/MObileAddToCartCaputre.png");
					System.out.println("Screeen shot Taken");

				} else {

					System.out.println("New Tab is not accesssible");
				}
			}

		} catch (Exception e) {

			logger.error(e.getMessage());

			System.exit(0);
		}

	}

	public void captureScreenShot(WebDriver webdriver, String fileWithPath) {

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

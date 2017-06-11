package automationFramework;

import java.util.List;

import org.testng.annotations.Test;

import pageObject.TestcaseEightMotoG5PlusDetail;
import pageObject.TestcaseFiveMotorolaCheckBoxVisibility;
import pageObject.TestcaseFourFilter4GbRam;
import pageObject.TestcaseOneAccountLogin;
import pageObject.TestcaseSevenOtherBrandItems;
import pageObject.TestcaseSixMotoItems;
import pageObject.TestcaseThreeMobileHomepage;
import pageObject.TestcaseTwoTopMenu;

public class MainExecution {
	List<String> parameters = ConfigReader.configParameterReader("stage", "Firefox");

	//object creation for all test cases
	TestcaseOneAccountLogin accountLogin = new TestcaseOneAccountLogin();
	TestcaseTwoTopMenu topMenu = new TestcaseTwoTopMenu();
	TestcaseThreeMobileHomepage mobilePage = new TestcaseThreeMobileHomepage();
	TestcaseFourFilter4GbRam filterRam = new TestcaseFourFilter4GbRam();
	TestcaseFiveMotorolaCheckBoxVisibility motorolaSelect = new TestcaseFiveMotorolaCheckBoxVisibility();
	TestcaseSixMotoItems motoItems = new TestcaseSixMotoItems();
	TestcaseSevenOtherBrandItems otherBrand = new TestcaseSevenOtherBrandItems();
	TestcaseEightMotoG5PlusDetail motoG5DetailView = new TestcaseEightMotoG5PlusDetail();

	
	//Test cases are executing 
	

	/*@Test

	public void testcaseOne() {
		
		System.out.println("Test case one in progress...");
		
		accountLogin.accountLogin(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));

	}

	@Test
	public void testcaseTwo() {

		topMenu.topMenu(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));

	}

	@Test
	public void testcaseThree() {

		mobilePage.mobileHomepage(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));

	}

	@Test
	public void testcaseFour() {

		filterRam.filter4GbRam(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));

	}

	@Test
	public void testcaseFive() {

		motorolaSelect.motorolaCheckBoxVisibility(parameters.get(0), parameters.get(1), parameters.get(2),parameters.get(3));

	}

	@Test
	public void testcaseSix() {

		motoItems.motoItems(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));

	}

	@Test
	public void testcaseSeven() {

		otherBrand.otherBrandItems(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));

	}
*/
	@Test
	public void testcaseEight() {

		motoG5DetailView.motoG5PlusDetail(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));

	}

}

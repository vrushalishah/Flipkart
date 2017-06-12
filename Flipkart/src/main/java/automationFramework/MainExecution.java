package automationFramework;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
	WebDriver driver = null;

	public String workingDir;
	// Declare An Excel Work Book
	HSSFWorkbook workbook;
	// Declare An Excel Work Sheet
	HSSFSheet sheet;
	// Declare A Map Object To Hold TestNG Results
	Map<String, Object[]> TestNGResults;
	public static String driverPath = "../";
	// Test cases are executing

	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() {
		// create a new work book
		workbook = new HSSFWorkbook();
		// create a new work sheet
		sheet = workbook.createSheet("TestNG Result Summary");
		TestNGResults = new LinkedHashMap<String, Object[]>();
		// add test result excel file column header
		// write the header in the first row
		TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });
		try {
			// Get current working directory and load the data file
			workingDir = "../";

		} catch (Exception e) {
			throw new IllegalStateException("Can't start the Firefox Web Driver", e);
		}
	}

	@Test
	public void testcaseEight() {
		TestcaseEightMotoG5PlusDetail motoG5DetailView = new TestcaseEightMotoG5PlusDetail();
		driver = motoG5DetailView.motoG5PlusDetail(parameters.get(0), parameters.get(1), parameters.get(2),
				parameters.get(3));
		driver.close();
		TestNGResults.put("2", new Object[] { 1d, "Product Added to cart and stay o page",
				"Product added to cart and cature screen shot", "Pass" });

	}

	@Test

	public void testcaseOne() {

		TestcaseOneAccountLogin accountLogin = new TestcaseOneAccountLogin();

		driver = accountLogin.accountLogin(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));
		driver.close();
		TestNGResults.put("3", new Object[] { 2d, "Login to account",
				"Enter credential and able to access flipkart account", "Pass" });

	}

	@Test
	public void testcaseTwo() {

		TestcaseTwoTopMenu topMenu = new TestcaseTwoTopMenu();
		driver = topMenu.topMenu(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));
		driver.close();
		TestNGResults.put("4", new Object[] { 3d, "Top menu check",
				"Top menu should be Electronics", "Pass" });

	}

	@Test
	public void testcaseThree() {
		TestcaseThreeMobileHomepage mobilePage = new TestcaseThreeMobileHomepage();
		driver = mobilePage.mobileHomepage(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));
		driver.close();
		TestNGResults.put("5", new Object[] { 4d, "Oprn mobile home page",
				"Open page is Mobile home page", "Pass" });

	}

	@Test
	public void testcaseFour() {
		TestcaseFourFilter4GbRam filterRam = new TestcaseFourFilter4GbRam();
		driver = filterRam.filter4GbRam(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));
		driver.close();
		TestNGResults.put("6", new Object[] { 7d, "Filter of four GB Ram",
				"Selected filter is of 4 gb and product are og 4 4GB ram", "Pass" });

	}

	@Test
	public void testcaseFive() {
		TestcaseFiveMotorolaCheckBoxVisibility motorolaSelect = new TestcaseFiveMotorolaCheckBoxVisibility();
		driver = motorolaSelect.motorolaCheckBoxVisibility(parameters.get(0), parameters.get(1), parameters.get(2),
				parameters.get(3));
		TestNGResults.put("7", new Object[] { 8d, "Motorola checkbox visibility",
				"Motorola checkbox is visible", "Pass" });

		driver.close();
	}

	@Test
	public void testcaseSix() {
		TestcaseSixMotoItems motoItems = new TestcaseSixMotoItems();

		driver = motoItems.motoItems(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));
		driver.close();
		TestNGResults.put("8", new Object[] { 9d, "Mototrola Items find", "Only Motorola Iems are getting display", "Pass" });
	}

	@Test
	public void testcaseSeven() {
		TestcaseSevenOtherBrandItems otherBrand = new TestcaseSevenOtherBrandItems();

		driver = otherBrand.otherBrandItems(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));
		driver.close();
		TestNGResults.put("9", new Object[] { 10d, " Other brand products visibility",
				"on remove brand filter display items of other brandr", "Pass" });

	}

	@AfterClass
	public void suiteTearDown() {
		// write excel file and file name is SaveTestNGResultToExcel.xls
		Set<String> keyset = TestNGResults.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = TestNGResults.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("../SaveTestNGResultToExcel.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		// close the browser
		driver.close();
		driver.quit();
	}
}

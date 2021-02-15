package AutomationFrameWork.TestCases;

import static AutomationFrameWork.Helpers.LoginPage.userLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.jdi.Method;
import com.sun.org.apache.xml.internal.security.Init;
import com.aventstack.extentreports.model.Report;
import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentTest;

import AutomationFrameWork.Helpers.LoginPage;
import AutomationFrameWork.SetupFiles.Initilization;
import jdk.internal.net.http.common.Logger;

public class TestCase1 extends Initilization {

//ExtentReports report;
//ExtentTest test;

	// @BeforeMethod
	/*
	 * public void setup(java.lang.reflect.Method testMethod ) {
	 * 
	 * String methodNameUsingClassInstance = testMethod.getName();
	 * 
	 * logger = report.startTest(methodNameUsingClassInstance);
	 * 
	 * }
	 */

	@Test(description = "Verify if the save button is enabled", enabled = false)
	@Parameters("browsers")
	public static void TC1(String BrowserName) {

		// logger =
		// report.startTest(method.getClass().getSimpleName(),method.getClass().getEnclosingMethod().getName());

		// test =
		// extent.startTest(method.getClass().getSimpleName(),method.getClass().getEnclosingMethod().getName());

		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "http://thedemosite.co.uk/login.php";
		// WebDriver driver = SetupClass.setup();

		Initilization.setup();
		userLogin("hariskhan123", "Karachi");

		String ActualUrl = Initilization.getAppUrl();

		Initilization.HardAssertion(ActualUrl, "http://thedemosite.co.uk/login.php");
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}

		// driver.quit();
		Initilization.DriverClose();

	}

	@Test(description = "Select Monday from the week drop down", enabled = false)
	@Parameters("browsers")
	public static void TC3(String BrowserName) {

		// logger = report.startTest("Test2");

		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "http://thedemosite.co.uk/login.php";
		// WebDriver driver = SetupClass.setup();

		Initilization.setup();
		userLogin("hariskhan", "sdasdasdasdsaddasds");

		String ActualUrl = Initilization.getAppUrl();

		Initilization.HardAssertion(ActualUrl, "http://thedemosite.co.uk/login.php");
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}

		// driver.quit();
		Initilization.DriverClose();
	}

	@Test(description = "Verify if the save button is disbaled", enabled = false)
	@Parameters("browsers")
	public static void TC2(String BrowserName) {

		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";

		Initilization.setup();
		// Initilization.maximizeScreen();

		Initilization.select_From_Dd("id", "select-demo", "text", "Monday");
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test(description = "Recaptcha - checking against multiple sessions", enabled = false, invocationCount = 3)
	@Parameters("browsers")
	public static void TC4(String BrowserName) {

		Initilization.BrowsersType = BrowserName;

		Initilization.URL = "http://dev.psw.gov.pk/app/";
		// Initilization.maximizeScreen();
		Initilization.setup();
		// Initilization.maximizeScreen();

		Initilization.click_On_Button("xpath", "//strong[text()='Create an account']");
		Initilization.click_On_Button("id", "1");

		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}
		// div[@id='card-content-container']//h5[contains(text(), 'NTN Holder')]"
		Initilization.click_On_Button("id", "1");

		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(200);
		} catch (Exception e) {
			System.out.println(e);
		}
		Initilization.click_On_Button("id", "sub-type-button-proceed");

		// Initilization.click_On_Button("xpath", "//div[contains(@class,'Card p-5 card
		// CardSelected CardScaleUp')]");
		// Initilization.click_On_Button("xpath", "//button[text()='Proceed']");

		Initilization.DriverClose();
	}

	@Test(description = "Recaptcha TC2: moving on different cards and select Proceed button", enabled = false)
	@Parameters("browsers")
	public static void TC5(String BrowserName) {

		Initilization.BrowsersType = BrowserName;

		Initilization.URL = "http://dev.psw.gov.pk/app/";
		// Initilization.maximizeScreen();
		Initilization.setup();
		// Initilization.maximizeScreen();

		Initilization.click_On_Button("xpath", "//strong[text()='Create an account']");
		Initilization.click_On_Button("id", "1");

		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}
		// div[@id='card-content-container']//h5[contains(text(), 'NTN Holder')]"

		for (int i = 0; i < 10; i++) {
			Initilization.click_On_Button("id", "1");
			Initilization.click_On_Button("id", "2");
			Initilization.click_On_Button("id", "3");
		}
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(200);
		} catch (Exception e) {
			System.out.println(e);
		}
		Initilization.click_On_Button("id", "sub-type-button-proceed");

		// Initilization.click_On_Button("xpath", "//div[contains(@class,'Card p-5 card
		// CardSelected CardScaleUp')]");
		// Initilization.click_On_Button("xpath", "//button[text()='Proceed']");

		Initilization.DriverClose();
	}

	@Test(description = "Generate and Pay Voucher fees", enabled = true)
	@Parameters("browsers")
	public static void TC6(String BrowserName) {

		Initilization.BrowsersType = BrowserName;

		Initilization.URL = "http://dev.psw.gov.pk/app/";
		// Initilization.maximizeScreen();
		Initilization.setup();
		// Initilization.maximizeScreen();

		Initilization.click_On_Button("xpath", "//strong[text()='Create an account']");
		Initilization.click_On_Button("id", "1");

		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e);
		}
		// div[@id='card-content-container']//h5[contains(text(), 'NTN Holder')]"

		
			Initilization.click_On_Button("id", "1");
		
	
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e);
		}
		Initilization.click_On_Button("id", "sub-type-button-proceed");
		
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}

		
		//Initilization.click_On_Button("id", "sub-info-button-sendOTP");
		
		Initilization.enter_Text("id", "input-ntn", "0000094");
		
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Initilization.click_On_Button("id", "sub-info-button-validate");
		
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Initilization.enter_Text("name", "Email", "haris.khan@pral.com.pk");
		Initilization.enter_Text("name", "CellNumber", "3453185150");
		Initilization.enter_Text("id", "input-cnic", "3520112905089");
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Generate Voucher']");
		String abc = Initilization.getText("sub-fee-slip-subscriptionFees-data");
		String abc1 = abc.substring(6, 23);
		System.out.println("PSID wo 6 digits:" +abc1);
		
		Initilization.UpdatePaymentStatus("https://dev.psw.gov.pk/api/ups/PSID/open", abc1);
		
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Initilization.click_On_Button("xpath","//div[@class='slip-box py-4 col-4']//p[@id='sub-info-subtext-cancel']");
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
			
		Initilization.click_On_Button("id", "sub-info-button-sendOTP");
	
		//Initilization.DriverClose();
		
		
		
		
		
	
		
	}
	
	
}

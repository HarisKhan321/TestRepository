package AutomationFrameWork.TestCases;

import static AutomationFrameWork.Helpers.LoginPage.userLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import com.aventstack.extentreports.model.Report;
import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentTest;

import AutomationFrameWork.Helpers.LoginPage;
import AutomationFrameWork.SetupFiles.Initilization;
import jdk.internal.net.http.common.Logger;


public class TestCase1 extends Initilization {

	
//ExtentReports report;
//ExtentTest test;

	

	
	//@BeforeMethod
	/*public void setup(java.lang.reflect.Method testMethod ) {
	
		String methodNameUsingClassInstance = testMethod.getName();
		
		logger = report.startTest(methodNameUsingClassInstance);

	}
*/
	
	
	@Test(description="Verify if the save button is enabled" ,enabled = true)
	@Parameters("browsers")
	public static void TC1(String BrowserName) {
	
	//logger = report.startTest(method.getClass().getSimpleName(),method.getClass().getEnclosingMethod().getName());
		
		//test = extent.startTest(method.getClass().getSimpleName(),method.getClass().getEnclosingMethod().getName());

	
		
	Initilization.BrowsersType =BrowserName;
	Initilization.URL ="http://thedemosite.co.uk/login.php";
	//WebDriver driver = SetupClass.setup();
	
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
	
	
	//driver.quit();
	Initilization.DriverClose();
	
	   }
	
	

	@Test(description="Select Monday from the week drop down" ,enabled = true)
	@Parameters("browsers")
	public static void TC3(String BrowserName) {
		
		//logger = report.startTest("Test2");

	Initilization.BrowsersType =BrowserName;
	Initilization.URL ="http://thedemosite.co.uk/login.php";
	//WebDriver driver = SetupClass.setup();
	
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
	
	
	//driver.quit();
	Initilization.DriverClose();
	   }
	
	@Test(description="Verify if the save button is disbaled" ,enabled = true)
	@Parameters("browsers")
	public static void TC2(String BrowserName) {
		
	
	Initilization.BrowsersType =BrowserName;
	Initilization.URL = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
	
	Initilization.setup();
	//Initilization.maximizeScreen();
	
	Initilization.select_From_Dd("id", "select-demo", "text", "Monday");
	try {
        // thread to sleep for 1000 milliseconds
        Thread.sleep(2000);
     } catch (Exception e) {
        System.out.println(e);
     }
	
	

	
	Initilization.DriverClose();
	   }
	
}

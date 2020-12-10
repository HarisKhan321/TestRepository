package AutomationFrameWork.TestCases;

import static AutomationFrameWork.Helpers.LoginPage.userLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.beust.jcommander.Parameter;

import AutomationFrameWork.Helpers.LoginPage;
import AutomationFrameWork.SetupFiles.Initilization;


public class TestCase1 extends Initilization {


	

	@Test(enabled = true)
	@Parameters("browsers")
	public void TC1(String BrowserName) {
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
	
	@Test
	@Parameters("browsers")
	public void TC2(String BrowserName) {
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

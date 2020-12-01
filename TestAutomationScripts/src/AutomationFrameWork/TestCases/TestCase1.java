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


	@Test
	@Parameters("browsers")
	public void TC1(String BrowserName) {
	Initilization.BrowsersType =BrowserName;
	Initilization.URL ="http://thedemosite.co.uk/login.php";
	//WebDriver driver = SetupClass.setup();
	Initilization.setup();
	userLogin("hariskhan123", "Karachi");
	
	String ActualUrl = Initilization.getAppUrl();
	
	Initilization.HardAssertion(ActualUrl, "http://thedemosite.co.uk/login.php");
	//driver.quit();
	Initilization.DriverClose();
	  
  
	
	

}
}

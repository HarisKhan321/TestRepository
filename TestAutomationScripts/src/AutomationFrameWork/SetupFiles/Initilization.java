package AutomationFrameWork.SetupFiles;

import java.util.NoSuchElementException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/*import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
*/
public class Initilization {

public static WebDriver driver =null;
public static String BrowsersType;
public static String URL;
public static WebDriverWait wait;

// extent reports
//static ExtentReports report =new ExtentReports("C:\\Report\\TestResult.html");
//static ExtentTest  logger =report.startTest("Check Browser and Application Opened");

// Open Application
public static void setup()
{	 
	//Extent report
	
	if(BrowsersType.equalsIgnoreCase("firefox"))
	{
	System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriverServer\\geckodriver.exe");		
	driver = new FirefoxDriver();
	 //Reporter.log("Browser Opened");
	//logger.log(LogStatus.INFO, "Fire fox Browser started ");
	
	driver.get(URL);
	 //Reporter.log("Application");
	//logger.log(LogStatus.PASS, "Application Opened");
	//report.endTest(logger);
	//report.flush();
	}

	else if (BrowsersType.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\HarisDocs\\AutomationStuff\\Automation Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		// Reporter.log("Browser Opened");
		//logger.log(LogStatus.INFO, "Chrome Browser started ");
		
		driver.get(URL);
		 //Reporter.log("Application");
		//logger.log(LogStatus.PASS, "Application Opened");
		//report.endTest(logger);
		//report.flush();
		//	 Reporter.log("Application Opened Opened");
	} else if (BrowsersType.equalsIgnoreCase("IE")) {
		System.setProperty("webdriver.ie.driver",
				"C:\\SeleniumDriverServer\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		 //Reporter.log("Browser Opened");
		//logger.log(LogStatus.INFO, "IE Browser started ");
		
		driver.get(URL);
		 //Reporter.log("Application");
		//logger.log(LogStatus.PASS, "Application Opened");
		//report.endTest(logger);
		//report.flush();
			// Reporter.log("Application Opened Opened"); 
	}

}


// this method is used  to set locator type e.g ID,NAME etc and its value 
public static  By locatorValue(String locatorTpye, String value) {
	By by;
	switch (locatorTpye) {
	case "id":
		by = By.id(value);
		break;
	case "name":
		by = By.name(value);
		break;
	case "xpath":
		by = By.xpath(value);
		break;
	case "css":
		by = By.cssSelector(value);
		break;
	case "linkText":
		by = By.linkText(value);
		break;
	case "partialLinkText":
		by = By.partialLinkText(value);
		break;
	default:
		by = null;
		break;
	}
	return by;
}

public static void enter_Text(String locatorType, String value, String text) {
	try {
		By locator;
		locator = locatorValue(locatorType, value);
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
		
	} catch (Exception e) {
		//logger.log(LogStatus.FAIL, "Locator not found: Locator Type:"+ locatorType + "and Value:" +value+ "and InputData:"+ text );
		//System.err.format("No Element Found to enter text" + e);
		driver.close();
	}
	//logger.log(LogStatus.PASS, "Enter Text Successfully : Locator Type:"+ locatorType + "and Value:" +value+ "and InputData:"+ text );
	//report.endTest(logger);
	//report.flush();
	
}

public void click_On_Link(String locatorType, String value) {
	try {
		By locator;
		locator = locatorValue(locatorType, value);
		WebElement element = driver.findElement(locator);
		element.click();
	} catch (Exception e) {
		//System.err.format("No Element Found to enter text" + e);
		//logger.log(LogStatus.FAIL, "Locator not found: Locator Type:"+ locatorType + "and Value:" +value);
		//System.err.format("No Element Found to enter text" + e);
		
	}
	//report.endTest(logger);
	//report.flush();
	driver.close();
}

public static void click_On_Button(String locatorType, String value) {
	try {
		By locator;
		locator = locatorValue(locatorType, value);
		WebElement element = driver.findElement(locator);
		element.click();
	} catch (Exception e) {
		//System.err.format("No Element Found to perform click" + e);
		//logger.log(LogStatus.FAIL, "Locator not found: Locator Type:"+ locatorType + "and Value:" +value);
		//System.err.format("No Element Found to enter text" + e);
		
		driver.close();
	
	}
	//report.endTest(logger);
	//report.flush();
}


public static String getAppUrl()
{
String url = driver.getCurrentUrl();	
return url;
}


// it will close driver
public static void DriverClose()
{	 
driver.close();

}

public static void HardAssertion(String ActualResult, String ExpectedResult)
{
Assert.assertEquals(ActualResult, ExpectedResult);
if(ActualResult == ExpectedResult)
{
//logger.log(LogStatus.PASS,"Assert Passed as Actual Result is equal to the Expected Result."+"Actual result:"+ActualResult +"Expected Result:"  + ExpectedResult);
//report.endTest(logger);
//report.flush();
}
else
{
//logger.log(LogStatus.FAIL,"Assert Failed as Actual Result is not equal to the Expected Result." +"Actual result:"+ActualResult +"Expected Result:"  + ExpectedResult);
//report.endTest(logger);
//report.flush();
}

}

}



package AutomationFrameWork.SetupFiles;

//import static AutomationFrameWork.SetupFiles.Initilization.logger;
//import static AutomationFrameWork.SetupFiles.Initilization.report;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
 

import org.apache.commons.io.FileUtils;

import org.apache.*;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Initilization {


public static WebDriver driver =null;
public static String BrowsersType;
public static String URL;
public static WebDriverWait wait;
public static String TestCaseName;
// extent reports

public static ExtentTest  logger;
static public ExtentReports report;
//static public ExtentReports report =new ExtentReports("D:\\TestResult.html",false);
//static ExtentTest  logger  =report.startTest("Automation Scritps have been excuted");;



@BeforeClass

public static void BeforeClass()
{

Initilization.getExtentInstance();	}

@BeforeMethod
public static void BeforeMethod(ITestResult result )
{
//This  is used to read and write Test Description of Methods in extent report
String methodNameUsingClassInstance = result.getMethod().getDescription();
logger = report.startTest(methodNameUsingClassInstance);

}


//This method is used to set the Instance of Extent Report and its path
public static ExtentReports getExtentInstance() {
	 report =new ExtentReports("D:\\TestResult_" + System.currentTimeMillis() + ".html",false);
	return report;
}

// Open Application
public static void setup()
{	 

	if(BrowsersType.equalsIgnoreCase("firefox"))
	{
	System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriverServer\\geckodriver.exe");		
	driver = new FirefoxDriver();
	 Reporter.log("Browser Opened");
	logger.log(LogStatus.INFO, "Fire fox Browser started ");
	
	driver.get(URL);
	 Reporter.log("Application");
	logger.log(LogStatus.PASS, "Application Opened");
	report.endTest(logger);
	report.flush();
	report.close();
	}

	else if (BrowsersType.equalsIgnoreCase("chrome")) {
	
		System.setProperty("webdriver.chrome.driver",
				"D:\\harisStuff\\TestAutomationStuff\\Automation Drivers\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
	   opt.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		driver = new ChromeDriver(opt);
		//driver = new ChromeDriver();
		
		Reporter.log("Browser Opened");
		logger.log(LogStatus.INFO, "Chrome Browser started ");
		driver.manage().window().maximize();
		driver.get(URL);
		 Reporter.log("Application");
		logger.log(LogStatus.PASS, "Application Opened");
		report.endTest(logger);
		report.flush();
		Reporter.log("Application Opened Opened");
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
	
	//This is for extent report Path

	//This is for Showing 

	
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


//Take Screen shots
public static String capture(WebDriver driver) throws IOException {
File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
File Dest = new File("D://../Pics/" + System.currentTimeMillis()
+ ".png");
String errflpath = Dest.getAbsolutePath();
FileUtils.copyFile(scrFile, Dest);
return errflpath;
}



public static void enter_Text(String locatorType, String value, String text){
	try {
		By locator;
		locator = locatorValue(locatorType, value);
		WebElement element = driver.findElement(locator);
		// scrolling until the element is visible
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys(text);
		
	} catch (Exception e) {
		logger.log(LogStatus.FAIL, "Locator not found: Locator Type:"+ locatorType + "and Value:" +value+ "and InputData:"+ text );
		System.err.format("No Element Found to enter text" + e);
		driver.close();
	}
	
	try {
        // thread to sleep for 1000 milliseconds
        Thread.sleep(2200);
     } catch (Exception e) {
        System.out.println(e);
     }
	try {
		logger.log(LogStatus.PASS, "Enter Text Successfully : Locator Type: "+ locatorType + "and Value: " +value+ "and InputData: "+ text + logger.addScreenCapture(capture(driver)) );
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	report.endTest(logger);
	report.flush();
	
}


public static String  getText(String value)
{
	String abc;
	abc= driver.findElement(By.id(value)).getText();
	return abc;
}

public static void click_On_Link(String locatorType, String value) {
	try {
		By locator;
		locator = locatorValue(locatorType, value);
		WebElement element = driver.findElement(locator);
		// scrolling until the element is visible
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	} catch (Exception e) {
		System.err.format("No Element Found to enter text" + e);
		logger.log(LogStatus.FAIL, "Locator not found: Locator Type: "+ locatorType + " and Value: " +value);
		System.err.format("No Element Found to enter text" + e);
		
	}
	report.endTest(logger);
	report.flush();
	driver.close();
	try {
        // thread to sleep for 1000 milliseconds
        Thread.sleep(2000);
     } catch (Exception e) {
        System.out.println(e);
     }
	
}

public static void click_On_Button(String locatorType, String value) {
	try {
		By locator;
		locator = locatorValue(locatorType, value);
		WebElement element = driver.findElement(locator);
		// scrolling until the element is visible
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		logger.log(LogStatus.PASS, "Successfully Clicked"+ locatorType + "and Value: " +value + logger.addScreenCapture(capture(driver)) );
	} catch (Exception e) {
		System.err.format("No Element Found to perform click" + e);
		logger.log(LogStatus.FAIL, "Locator not found: Locator Type:"+ locatorType + "and Value:" +value);
		System.err.format("No Element Found to enter text" + e);
		
		driver.close();
	
	}
	report.endTest(logger);
	report.flush();
}

public static void click_On_CheckBox(String locatorType, String value) {
	try {
		By locator;
		locator = locatorValue(locatorType, value);
		WebElement element = driver.findElement(locator);
		// scrolling until the element is visible
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	} catch (Exception e) {
		System.err.format("No Element Found to perform click" + e);
		logger.log(LogStatus.FAIL, "Locator not found: Locator Type:"+ locatorType + "and Value:" +value);
		System.err.format("No Element Found to enter text" + e);
		
		driver.close();
	
	}
	report.endTest(logger);
	report.flush();
}


public static void click_On_RadioButton(String locatorType, String value) {
	try {
		By locator;
		locator = locatorValue(locatorType, value);
		WebElement element = driver.findElement(locator);
		// scrolling until the element is visible
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	} catch (Exception e) {
		System.err.format("No Element Found to perform click" + e);
		logger.log(LogStatus.FAIL, "Locator not found: Locator Type:"+ locatorType + "and Value:" +value);
		System.err.format("No Element Found to enter text" + e);
		
		driver.close();
	
	}
	report.endTest(logger);
	report.flush();
}

public static void select_From_Dd(String locatorType, String value, String Dd_Type,String dD_Value) {
	
	try {
	By locator;
		locator = locatorValue(locatorType, value);
		WebElement element = driver.findElement(locator);
	
	Select dropdown = new Select(element);
	// scrolling until the element is visible
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	if(Dd_Type == "text")
	{
		dropdown.selectByVisibleText(dD_Value);
	}
	else if (Dd_Type == "index")
	{
		dropdown.selectByIndex(1);	
	}
	else if (Dd_Type == dD_Value)
	{
		dropdown.selectByValue(dD_Value);
	}
	}
	catch (Exception e) {
		System.err.format("No Element Found to perform click" + e);
		logger.log(LogStatus.FAIL, "Locator not found: Locator Type:"+ locatorType + "and Value:" +value);
		System.err.format("No Element Found to enter text" + e);
		
		driver.close();
	
	}
}


public static String getAppUrl()
{
String url = driver.getCurrentUrl();	
return url;
}


// it will close driver
public static void DriverClose()
{	 
driver.quit();

}

public static void HardAssertion(String ActualResult, String ExpectedResult)
{
Assert.assertEquals(ActualResult, ExpectedResult);
if(ActualResult == ExpectedResult)
{
logger.log(LogStatus.PASS,"Assert Passed as Actual Result is equal to the Expected Result."+"Actual result:"+ActualResult +"Expected Result:"  + ExpectedResult);
report.endTest(logger);
report.flush();
}
else
{
logger.log(LogStatus.FAIL,"Assert Failed as Actual Result is not equal to the Expected Result." +"Actual result:"+ActualResult +"Expected Result:"  + ExpectedResult);
report.endTest(logger);
report.flush();
}

}

public static void UpdatePaymentStatus(String APIUrl, String PSID )
{   
 RestAssured.baseURI  = APIUrl; 

	 
    Response res = given()
    .contentType("application/json").
   // body("{\"reserved\":\"PSID20210126024230|1122332|PSW:58400;GST:13600;FE:8000\"}").
    body("{\r\n"
    		+ "    \"methodId\": \"1411\",\r\n"
    		+ "    \"data\": {\r\n"
    		+ "        \"username\" : \"saad123\",\r\n"
    		+ "        \"password\" : \"qwe123\",\r\n"
    		+ "        \"psid\" : \""+PSID+"\",\r\n"
    		+ "        \"transaction_auth_id\" : \"112233\",\r\n"
    		+ "        \"transaction_amount\" : \"0000000080000\",\r\n"
    		+ "        \"tran_time\" : \"120911\",\r\n"
    		+ "        \"tran_date\" : \"20201208\",\r\n"
    		+ "        \"bank_mnemonic\" : \"UBL\",\r\n"
    		+ "        \"reserved\" : \"PSID20210126024932|1122332|PSW:58400;GST:13600;FE:8000;\"\r\n"
    		+ "    },\r\n"
    		+ "    \"signature\": \"\",\r\n"
    		+ "    \"pagination\": {\r\n"
    		+ "        \"offset\": 10,\r\n"
    		+ "        \"size\": 10,\r\n"
    		+ "        \"sortColumn\": \"\",\r\n"
    		+ "        \"sortOrder\": \"\"\r\n"
    		+ "    }\r\n"
    		+ "}"
    		
    		). 
    when().
       post("");

    String body = res.getBody().asString();
    System.out.println(body);


}


}




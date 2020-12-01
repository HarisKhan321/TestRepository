package AutomationFrameWork.Helpers;

import net.bytebuddy.asm.Advice.Enter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import AutomationFrameWork.SetupFiles.Initilization;

public class LoginPage extends Initilization {

public static void userLogin(String userName, String Password) {
		
			//Login
	
	//driver.findElement(By.id("txtUsername")).sendKeys(userName); 
	//driver.findElement(By.id("txtPassword")).sendKeys(Password);
	//driver.findElement(By.id("btnLoginLabel")).click();
	
	enter_Text("name","username",userName);
	enter_Text("name","password",Password);
	click_On_Button("name", "FormsButton2");

}
	
}

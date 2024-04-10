package tests;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class HRMLoginTest extends BaseTest {
    
	

    
	@Test(priority = 2 )
	public void loginTest_001(Method method) throws InterruptedException {

		extentTest = extentReport.createTest(method.getName(), "HRM Login Test");
		extentTest.info("Open HRM application");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.name("username")).sendKeys("Admin");
    	driver.findElement(By.name("password")).sendKeys("admin123");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[contains(@class,'orangehrm-login-action')]/button")).click();
    	Thread.sleep(4000);
	    getScreenShot(driver);
		

		getScreenShot(driver);

	}
}

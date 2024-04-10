package tests;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.HomePage;



public class LoginTests extends BaseTest {
    
	//WebDriver driver;
	ExtentTest test1,test2,test3;
	 // Web Elements
//    By username = By.name("username");
//    By password = By.name("password");
//    By signInButtonClass = By.xpath("//div[contains(@class,'orangehrm-login-action')]/button");
    
//    @BeforeMethod()
//	public void beforeMethod() {
//		
//		ChromeOptions option = new ChromeOptions();
//		driver = new ChromeDriver(option);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
//    
//    @AfterMethod()
//	public void afterTest() {
//		driver.quit();
//	}
	
	
	@Test(priority = 0)
    public void validLoginTest(Method method) throws InterruptedException {
         
		extentTest =extentReport.createTest(method.getName(),"dssfdsf");
		
		
        
	    driver.get("https://opensource-demo.orangehrmlive.com/"); 
	    extentTest.info("Open HRM application");
	    
		driver.findElement(By.name("username")).sendKeys("Admin");
    	driver.findElement(By.name("password")).sendKeys("admin123");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[contains(@class,'orangehrm-login-action')]/button")).click();
    	Thread.sleep(4000);
	    getScreenShot(driver);

	}
	
	@Test(priority = 1)
	public void test2(Method m) throws InterruptedException {
		extentTest =extentReport.createTest(m.getName(),"Google Test");

	    driver.get("https://www.google.com/"); 
	    extentTest.info("Open Google application");
	    
		driver.findElement(By.name("q")).sendKeys("extent\n");
      	Thread.sleep(4000);
   	    getScreenShot(driver);
	}
	
	
	
	
	
}
package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.HomePage;

public class BaseTest {
      
	public WebDriver driver;
	public BrowserInit Browser;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	

    public HomePage homePage;// =new HomePage(driver);;	
	
	
	@BeforeSuite()
	public void beforeSuite() {
		System.out.println("Executing @BeforeSuite method ...");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./extent-with-config.html");
		try { sparkReporter.loadJSONConfig(new File("./src/test/resources/spark-config.json"));} 
		catch (IOException e) { e.printStackTrace(); }
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("OS","WIN10");
	}
	
	@AfterSuite()
	public void afterSuite() {
		System.out.println("Executing @AfterSuite method ...");
		System.out.println("executing after suite method");
		extentReport.flush();
	}
	
	@BeforeTest()
	public void beforeMethod(ITestContext context) {
		System.out.println("Executing @BeforeTest method ...");
//		ChromeOptions option = new ChromeOptions();
//		driver = new ChromeDriver(option);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver = new BrowserInit().getBrowser();
		
	}
	
	
	
	@BeforeMethod()
	public void beforeMethod() {
		System.out.println("Executing @BeforeMethod method ...");
//		homePage = new HomePage(driver);
//		ChromeOptions option = new ChromeOptions();
//		driver = new ChromeDriver(option);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver = new BrowserInit().getBrowser();
	}
	
	
	@AfterMethod()
	public void afterMethod(Method m,ITestResult result) {
		System.out.println("Executing @AfterMethod method ...");
          if(!result.isSuccess()) {
        	  System.out.println("test failed");
        	  //extentTest.addScreenCaptureFromPath("path/to/file");
        	  //extentTest.log(null, null);
        	  extentTest.fail(result.getThrowable());
          }
          
          if(result.getStatus()==ITestResult.SUCCESS) {
        	  System.out.println("test Pass");
//        	  getScreenShot(driver);
          }
//          //extentTest.assignCategory(m.getAnnotation(Test.class))
//          driver.quit();   
	}
	

	
	@AfterTest()
	public void afterTest() {
		System.out.println("Executing @AfterTest method ...");
//		driver.close();
	}
	
	
	
	public static void getScreenShot(WebDriver driver) {
		String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.BASE64);
        extentTest.log(Status.PASS, "Test Pass", extentTest.addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));           
    }
	
	
	
}




//sparkReporter.viewConfigurer().viewOrder().as(new ViewName[] { 
//		  ViewName.DASHBOARD,
//		  ViewName.CATEGORY,
//		  ViewName.TEST,
//		  ViewName.LOG
//		}).apply();

package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserInit {
     WebDriver driver;
     
     public WebDriver getBrowser() {
    	 ChromeOptions options = new ChromeOptions();
    	 driver = new ChromeDriver(options);
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	 return driver;
    	 
    	 
     }
}

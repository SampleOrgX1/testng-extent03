package tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;

public class SnipeItTest3 extends BaseTest{
 
  @BeforeMethod()
  public void beforeTest() {
	  driver.get("https://demo.snipeitapp.com/login");
  }

  @AfterTest
  public void afterTest() {
  }
  
  @Test(priority=0)
  public void test1() {
	  driver.findElement(By.name("username")).sendKeys("admin");  
  }
  
  @Test(priority=1)
  public void test2() {
	  driver.findElement(By.name("password")).sendKeys("password");  
  }

}

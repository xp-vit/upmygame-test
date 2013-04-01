package com.upmygame.test.core;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
  @BeforeTest
  public void beforeTest() {
	 Driver.driverInstance().manage().window().maximize();
	 Driver.driverInstance().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
  }
  @BeforeMethod
  public void beforeMethod(){
	  Driver.driverInstance().get("http://www.upmygame.com/");
  }
  @AfterMethod
  public void afterMethod(){
	 Driver.driverInstance().manage().deleteAllCookies();
  }
  @AfterTest
  public void afterTest() {
	Driver.close();
  }
  
 
  
}

package com.upmygame.test.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	private static WebDriver driver;
	
	
	public static WebDriver driverInstance(){
		 if (driver == null)
         {
			 //File profileDir = new File("e:\\firefoxProfile");
			 //FirefoxProfile profile = new FirefoxProfile(profileDir);
			 driver = new FirefoxDriver();
         }
         return driver;
     }
	 public static void close()
     {
         if (driver != null)
         {
             driver.quit();
             driver = null;
         }
     }
	
}

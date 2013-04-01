package com.upmygame.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.upmygame.test.core.BaseTest;
import com.upmygame.test.pages.front.LoginPage;
import com.upmygame.test.pages.front.MainPage;


public class Authorization extends BaseTest {

	@Test
	public void positiveLogin() {
		Properties properties = new Properties();
		try {
		  properties.load(new FileInputStream("credentials.properties"));
		} catch (IOException e) {
		 }
		 String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		MainPage mp = new MainPage();
		LoginPage lp = mp.getLoginPage();
		lp.doLogin(username, password);
		Assert.assertTrue(lp.isLogin());
		
	}
	@Test
	public void negativeLogin() {
		Properties properties = new Properties();
		try {
		  properties.load(new FileInputStream("credentials.properties"));
		} catch (IOException e) {
		 }
		 String username = properties.getProperty("username1");
		String password = properties.getProperty("password1");
		MainPage mp = new MainPage();
		LoginPage lp = mp.getLoginPage();
		lp.doLogin(username, password);
		Assert.assertFalse(lp.isLogin());
		
	}
}

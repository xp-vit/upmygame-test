package com.upmygame.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.upmygame.test.core.BaseTest;
import com.upmygame.test.pages.dashbord.DashboardPage;
import com.upmygame.test.pages.dashbord.UploadVideoPage;
import com.upmygame.test.pages.front.LoginPage;
import com.upmygame.test.pages.front.MainPage;



public class UploadVideo extends BaseTest{

	
	@Test
	public void uploadVideo(){
		Properties properties = new Properties();
		try {
		  properties.load(new FileInputStream("credentials.properties"));
		} catch (IOException e) {
		 }
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		MainPage mp = new MainPage();
		LoginPage lp = mp.getLoginPage();
		DashboardPage dhp = lp.doLogin(username, password);	
		UploadVideoPage uvp = dhp.getUploadPage();
		uvp.uploadVideo();
	}
	
}

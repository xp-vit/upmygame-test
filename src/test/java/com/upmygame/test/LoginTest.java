package com.upmygame.test;

import org.testng.annotations.Test;

import com.upmygame.test.core.BaseTest;
import com.upmygame.test.pages.front.LoginPage;
import com.upmygame.test.pages.front.MainPage;


public class LoginTest extends BaseTest {
	@Test
	public void doLogin(){
		MainPage mp = new MainPage();
		LoginPage lp = mp.getLoginPage();
		lp.doLogin(null, null);
		
	}
	
	@Test
	public void enterValue(){
		MainPage mp = new MainPage();
		mp.enterFields();
	}

}

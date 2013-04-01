package com.upmygame.test.pages.front;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.upmygame.test.core.Driver;
import com.upmygame.test.pages.dashbord.DashboardPage;


public class LoginPage {
	
	@FindBy(id = "username")
	private WebElement loginField;
	
	@FindBy(id= "password")
	private WebElement pswdField;
	
	@FindBy(id= "loginbutton")
	private WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(Driver.driverInstance(), this);		
	}

	public  DashboardPage doLogin(String username,String password ){
		
		loginField.sendKeys(username);
		pswdField.sendKeys(password);
		loginButton.click();
		return new DashboardPage();
	}
	public boolean isLogin() {
		try {
			Driver.driverInstance().findElement(By.xpath("//img[@class='avatar']"));
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	}

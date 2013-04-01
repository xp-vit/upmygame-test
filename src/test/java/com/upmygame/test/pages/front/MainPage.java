package com.upmygame.test.pages.front;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.upmygame.test.core.Driver;


public class MainPage {

	@FindBy(xpath = "//a[text()='Sign In']")
    private WebElement loginButton;
	
	@FindBy(id = "umg-trial")
	private WebElement signUpButton;
	
	@FindBy(id="email")
	private WebElement emailField;
	
	
	
	public MainPage() {
		PageFactory.initElements(Driver.driverInstance(),this);		
	}
	
	public LoginPage getLoginPage(){		
		loginButton.click();
		return new LoginPage();
	}
	
	public void enterFields(){
		signUpButton.click();
		Driver.driverInstance().switchTo().frame(Driver.driverInstance().findElement(By.id("fancybox-frame")));
		emailField.sendKeys("demo");
	}
	
}

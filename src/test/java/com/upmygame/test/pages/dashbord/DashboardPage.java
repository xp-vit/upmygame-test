package com.upmygame.test.pages.dashbord;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.upmygame.test.core.Driver;


public class DashboardPage {
	@FindBy(xpath="//a[@class='upload']")
	private WebElement uploadLink;
	 public DashboardPage() {
		PageFactory.initElements(Driver.driverInstance(), this);	
	
	}
	 
	 
	 public UploadVideoPage getUploadPage(){
		 this.uploadLink.click();
		 return new UploadVideoPage();
	 }
	 
	 public VideoPage getVideoPage(){
		 Driver.driverInstance().get("http://www.upmygame.com/teamname/watchv/366/0");
		 return new VideoPage();
	 }
}

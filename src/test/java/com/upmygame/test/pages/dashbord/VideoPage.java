package com.upmygame.test.pages.dashbord;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.upmygame.test.core.Driver;
import com.upmygame.test.utils.Waiters;



public class VideoPage {
	@FindBy(xpath="//div[@data='play']")
	private WebElement playButton;
	@FindBy(xpath="//div[@data='pause']")
	private WebElement pauseButton;
	
	@FindBy(xpath="//div[@data='line']")
	private WebElement lineButton;
	@FindBy(xpath="//div[@data='save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//video[@data='video']")
	private WebElement videoContainer;
	public VideoPage() {
		PageFactory.initElements(Driver.driverInstance(), this);	
	}
	
	public void playVideo(){
		Driver.driverInstance().get("http://www.upmygame.com/html5");
		Driver.driverInstance().findElement(By.id("on")).click();
		Driver.driverInstance().get("http://www.upmygame.com/teamname/watchv/364/0");
		int xLoc = videoContainer.getLocation().x;
		int yLoc = videoContainer.getLocation().y;
		System.out.println(xLoc);
		System.out.println(yLoc);
		Waiters.threadSleep(4000);
		playButton.click();
		System.out.println("Click Play");
		Waiters.threadSleep(4000);
				
		pauseButton.click();
		System.out.println("Click Pause");
		lineButton.click();
		System.out.println("Click Line Button");
			
		Actions builder = new Actions(Driver.driverInstance());
		builder.moveToElement(videoContainer).moveByOffset(30, 30).click().moveByOffset(50, 50).click();
		
		builder.build().perform();
		saveButton.click();
		System.out.println("Click Save Button");
		Waiters.threadSleep(10000);
		
	}
}

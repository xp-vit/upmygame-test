package com.upmygame.test.pages.dashbord;

import java.io.File;

import org.openqa.selenium.support.PageFactory;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;

import com.upmygame.test.core.Driver;
import com.upmygame.test.utils.Waiters;





public class UploadVideoPage {

	
	public UploadVideoPage() {
		PageFactory.initElements(Driver.driverInstance(), this);	
	}
	
	public void uploadVideo(){
	
		
		Waiters.threadSleep(5000);
		ScreenRegion s = new DesktopScreenRegion();
		Target target = new ImageTarget(new File("sikuli-img//select_video.PNG"));
		ScreenRegion r = s.find(target);
		Mouse mouse = new DesktopMouse();
		mouse.click(r.getCenter());
		com.upmygame.test.utils.Waiters.threadSleep(5000);
		Keyboard keyboard = new DesktopKeyboard();
		keyboard.type("d:\\Contact Sheet Deluxe FINAL_1.avi");
		keyboard.type(Key.ENTER);
		
		
		
	}
	
	
}

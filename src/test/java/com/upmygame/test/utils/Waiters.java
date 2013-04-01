package com.upmygame.test.utils;

public class Waiters {

	
	public static void threadSleep(int timeOut){
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

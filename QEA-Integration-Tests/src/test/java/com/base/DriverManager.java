package com.base;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	private static CommonActions commonActions;

	public void setDriver(WebDriver driver) {
		webDriver.set(driver);
	}

	public static WebDriver getDriver() {
		return webDriver.get();


	}

	public void setCommonActions(DriverManager driver) {
		commonActions = new CommonActions(driver);
	}

	public static CommonActions getCommonActions() {
		return commonActions;
	}

}

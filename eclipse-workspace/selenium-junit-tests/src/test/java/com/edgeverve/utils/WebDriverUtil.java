package com.edgeverve.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public final class WebDriverUtil {

	private WebDriverUtil() {
	}

	static {
		System.setProperty("webdriver.chrome.driver", "/Users/vinod/Desktop/selenium-drivers/chromedriver");
		System.setProperty("webdriver.edge.driver", "/Users/vinod/Desktop/selenium-drivers/msedgedriver");
	}

	public static WebDriver getWebDriver(String type) {
		switch (type.toLowerCase()) {
		case "chrome":
			return new ChromeDriver();
		case "edge":
		case "msedge":
			return new EdgeDriver();
		default:
			throw new IllegalArgumentException("Unknown type of driver requested!");
		}
	}
	
	public static WebDriver getWebDriver() {
		return getWebDriver("chrome");
	}
}

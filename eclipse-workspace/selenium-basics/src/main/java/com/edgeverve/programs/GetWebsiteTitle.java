package com.edgeverve.programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetWebsiteTitle {
	
	static Logger log = LoggerFactory.getLogger(GetWebsiteTitle.class);

	public static void main(String[] args) {

		// 1. specify the location of the web driver executable (Chrome/Edge/...)
		System.setProperty("webdriver.edge.driver", "/Users/vinod/Desktop/selenium-drivers/msedgedriver");
		System.setProperty("webdriver.chrome.driver", "/Users/vinod/Desktop/selenium-drivers/chromedriver");
		
		// 2. Create an object of an appropriate driver (that uses the executable driver, to control the browser)
		WebDriver driver = new ChromeDriver(); // or new EdgeDriver() or new SafariDriver()
		
		// 3. Start controlling the browser (open, visit, type, click, close, etc)
		driver.get("https://vinod.co");
		String title = driver.getTitle();
		driver.quit();
		
		log.trace("Browser title is '{}'", title);
		
	}

}

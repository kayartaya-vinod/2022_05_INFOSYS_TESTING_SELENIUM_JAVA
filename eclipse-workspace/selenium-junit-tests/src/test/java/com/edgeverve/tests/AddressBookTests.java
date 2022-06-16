package com.edgeverve.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edgeverve.utils.WebDriverUtil;

class AddressBookTests {

	WebDriver driver;

	@BeforeEach
	void setup() {
		driver = WebDriverUtil.getWebDriver();
		driver.get("http://localhost:3000/");
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}

	@Test
	void shouldCheckTitle() {
		String expected = "React Addressbook App";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void shouldAddNewContact() {

		List<WebElement> contacts = driver.findElements(By.cssSelector("div.card.mb-3"));
		int countBefore = contacts.size();

		String name = "Kayartaya Vinod Kumar";
		String email = "vinod@vinod.co";
		String phone = "9731424784";
		
		WebElement nameTf = driver.findElement(By.id("name"));
		nameTf.sendKeys(name);

		WebElement emailTf = driver.findElement(By.name("email"));
		emailTf.sendKeys(email);

		WebElement phoneTf = driver.findElement(By.cssSelector("input[type=tel]"));
		phoneTf.sendKeys(phone);

		WebElement avatarTf = driver.findElement(By.xpath("//input[@id='avatar']"));
		avatarTf.sendKeys("https://avatars.githubusercontent.com/u/14976510?v=4");

		driver.findElement(By.cssSelector("button[type=submit]")).click();

		contacts = driver.findElements(By.cssSelector("div.card.mb-3"));
		int countAfter = contacts.size();

		assertEquals("", nameTf.getText());
		assertEquals("", emailTf.getText());
		assertEquals("", phoneTf.getText());
		assertEquals("", avatarTf.getText());

		assertEquals(countBefore + 1, countAfter);
		
		WebElement card = contacts.get(countBefore); // newly added contact
		
		String txt = card.getText();
		assertTrue(txt.contains(name));
		assertTrue(txt.contains(email));
		assertTrue(txt.contains(phone));
		
		
		String nameAdded = driver.findElement(By.cssSelector("div.card:last-child h5.card-title")).getText();
		assertEquals(name, nameAdded);
	}

}

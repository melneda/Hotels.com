package com.qa.hotels.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.HomePage;
import com.qa.hotels.util.AppConstants;
import com.qa.hotels.util.ElementUtil;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	ElementUtil elementutil;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void verifyMainPageTitleTest() throws InterruptedException {
		String title = homePage.getPageTitle();
		System.out.println("Home page title is" + title);
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void fillFormTest() throws InterruptedException {
		homePage.fillUpForms();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}

package com.qa.hotels.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.FourStarHotels;
import com.qa.hotels.page.HomePage;
import com.qa.hotels.page.ThreeStarHotels;
import com.qa.hotels.util.AppConstants;
import com.qa.hotels.util.ElementUtil;

public class ThreeStarHotelsTest {
	
	WebDriver driver;
	BasePage basePage;	
	Properties prop;
	HomePage homePage;
	ElementUtil elementUtil;
    ThreeStarHotels threestarhotels;
    

@BeforeTest
public void setUp() throws InterruptedException {
basePage=new BasePage();
prop=basePage.init_properties();
String browserName=prop.getProperty("browser");
driver=basePage.init_driver(browserName);	
driver.get(prop.getProperty("url"));
homePage=new  HomePage(driver);
threestarhotels=homePage.gotoThreeStarHotelsPage();
threestarhotels= new ThreeStarHotels(driver);
}

@Test(priority = 1)
public void verifyThreeStarHotelsTitleTest() throws InterruptedException {
	String title = threestarhotels.getPageTitle();
	System.out.println("ThreeStarHotels title is" + title);
	Assert.assertEquals(title,AppConstants.THREESTARHOTELS_PAGE_TITLE);
    Thread.sleep(5000);
    
}
@Test(priority=2 ,enabled=false)
public void showHiltonAvailablein3StarVerify() throws InterruptedException {
	threestarhotels.showHiltonAvailablein3Star();
}


@AfterTest
public void tearDown() {
	driver.quit();
}	
}





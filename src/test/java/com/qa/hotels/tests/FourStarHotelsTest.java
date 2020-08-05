package com.qa.hotels.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.FourStarHotels;
import com.qa.hotels.page.HomePage;
import com.qa.hotels.page.ThreeStarHotels;
import com.qa.hotels.util.ElementUtil;
public class FourStarHotelsTest {
	

	WebDriver driver;
	BasePage basePage;	
	Properties prop;
	HomePage homePage;
	ElementUtil elementUtil;
    ThreeStarHotels threestarhotels;
     FourStarHotels fourStarHotels;
     
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
    	 fourStarHotels=threestarhotels.gotoFourStarHotelsPage();
    	 fourStarHotels= new FourStarHotels(driver);
    	 
    	 }
	
	
	@Test(enabled=true)
	
	   public void  fourStarCitycenterverify() throws InterruptedException {
		fourStarHotels.fourStarCitycenter();
		}
	
	
	
	@AfterTest
	public void tearDown() {
	driver.quit();


}}

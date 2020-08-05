package com.qa.hotels.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.AppConstants;
import com.qa.hotels.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// locators;

	By adv = By.linkText("Continue to Hotels.com");
	By dest = By.id("qf-0q-destination");
	By chkin = By.id("qf-0q-localised-check-in");
	// By chkin=By.cssSelector("#qf-0q-localised-check-in");
	By chkout = By.xpath("//input[@id='qf-0q-localised-check-out']");
	By room = By.id("qf-0q-rooms");
	// By room=By.xpath("//div[@class='widget-query-room-number']");
	By adlt = By.xpath("//select[@id='qf-0q-room-0-adults']");
	By chld = By.xpath("//select[@id='qf-0q-room-0-children']");
	By chld1age = By.xpath("//select[@id='qf-0q-room-0-child-0-age']");
	By chld2age = By.xpath("//select[@name='q-room-0-child-1-age']");
	By srcbtn = By.xpath("//button[@type='submit']");

	// Constructors
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// Page title
	public String getPageTitle() {
		return elementUtil.waitForGetPageTitle(AppConstants.HOME_PAGE_TITLE);
	}

	public void fillUpForms() throws InterruptedException {
	//	driver.findElement(adv).click();
		elementUtil.doSendKeys(dest, "Boston, Massachusetts, United States of America");
		elementUtil.doSendKeys(chkin, "08/20/20");
		elementUtil.doSendKeys(chkout, "08/25/20");
		elementUtil.selectDropdownByVisibleText(driver, room, "1");
		elementUtil.selectDropdownByVisibleText(driver, adlt, "2");
		elementUtil.selectDropdownByVisibleText(driver, chld, "2");
		elementUtil.selectDropdownByVisibleText(driver, chld1age, "4");
		elementUtil.selectDropdownByVisibleText(driver, chld2age, "9");
		elementUtil.doClick(srcbtn);
	}

	public ThreeStarHotels gotoThreeStarHotelsPage() throws InterruptedException {
		fillUpForms();
		return new ThreeStarHotels(driver);

	}
}

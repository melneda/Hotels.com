package com.qa.hotels.page;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class FiveStarHotels extends BasePage {
WebDriver driver;
ElementUtil elementUtil;
JavaScriptUtil javaScriptUtil;
double requestedMile =10;

//Locators
	
By fifthstar=By.id("f-star-rating-5");	
By citycenter=By.xpath("//a[text()='City center']");
//By distance= By.xpath("//a[contains(text(),'Distance']");
By hotelMiles = By.xpath("//ul[@class='property-landmarks']/li[contains(text(), 'City center')]");
By distance = By.xpath("//a[text()='Distance']");

public FiveStarHotels(WebDriver driver) {
	this.driver=driver;
	elementUtil=new ElementUtil(driver);
	javaScriptUtil=new JavaScriptUtil(driver);
	
}
		
public void  fiveStarCitycenter() throws InterruptedException {
elementUtil.doClick( fifthstar);
//elementUtil.waitForElementPresent(distance);
Thread.sleep(3000);
elementUtil.moveToElement(distance, citycenter);
for(int second = 0;; second++){
	if(second >=60){
		break;
	}
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
	Thread.sleep(3000);
}	
List<WebElement> hotelNames = driver.findElements(By.xpath("//*[@class='hotel-wrap']//h3"));
List<WebElement> miles = driver.findElements(hotelMiles);
for (int i = 0; i < hotelNames.size(); i++) {
String text = hotelNames.get(i).getText();
String text1 = miles.get(i).getText();
String hotelMilesr=text1.substring(0,3);
double radius = Double.parseDouble(hotelMilesr);
// System.out.println(radius);
if (radius<10) {
	System.out.println("5 start hotel is " +hotelNames.get(i).getText() + " " + radius);
}
}


	



}}	
	
	
	



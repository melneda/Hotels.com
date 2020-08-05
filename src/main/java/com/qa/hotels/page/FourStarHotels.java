package com.qa.hotels.page;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class FourStarHotels  extends BasePage{
	
WebDriver driver;
ElementUtil elementUtil;
JavaScriptUtil javaScriptUtil;


//Locators
	
By fourstar=By.id("f-star-rating-4");
By fifthstar=By.id("f-star-rating-5");	
//By distance= By.linkText("Distance");
//By citycenter=By.xpath("//a[contains(text(),'City center']");
By citycenter=By.xpath("//a[text()='City center']");
//By distance= By.xpath("//a[contains(text(),'Distance']");
By distance=By.linkText("Distance");
By hotelMiles = By.xpath("//ul[@class='property-landmarks']/li[contains(text(), 'City center')]");

	

//Constractors
   public FourStarHotels(WebDriver driver) {
	this.driver=driver;
	elementUtil=new ElementUtil(driver);
	javaScriptUtil=new JavaScriptUtil(driver);
	
}



public void  fourStarCitycenter() throws InterruptedException {
elementUtil.doClick(fourstar);
elementUtil.moveToElement(distance, citycenter);
for(int second = 0;; second++){
	if(second >=60){
		break;
	}
//javaScriptUtil.scrollDownPage(1000, driver);
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
	//System.out.println("Four star hotel list in 10 miles from city center");
	System.out.println(hotelNames.get(i).getText() + " " + radius);
}
}
}

public FiveStarHotels gotoFiveStarHotelsPage() throws InterruptedException {
	fourStarCitycenter(); 
	return new  FiveStarHotels(driver);

}}
//  
//public boolean verifyHotelsAreWithin10Miles(){
// List<String> distanceFromCity=new ArrayList();
//	    List<WebElement>distances=driver.findElements(milescity);
//	    for (WebElement distance : distances ){
//	        distanceFromCity.add(distance.getText()); }
//	    ArrayList<Double> distanceInNumbers=new ArrayList<Double>();
//	    for(int i=0; i<distanceFromCity.size(); i++){
//	        distanceInNumbers.add(Double.parseDouble(distanceFromCity.get(i).substring(0,3)));
//	    //    (distanceFromCity.get(i).substring(0,5)));
//     }
//	        for(int i=0; i<distanceInNumbers.size(); i++){
//	            if(distanceInNumbers.get(i)>10){
//	                return true;
//            }
//	        }
//	        return true;}
//}
//





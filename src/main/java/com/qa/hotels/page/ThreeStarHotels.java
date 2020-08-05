package com.qa.hotels.page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.AppConstants;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;
public class ThreeStarHotels extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	

	
	//Locators
	By threestar=By.id("f-star-rating-3");
	By fourstar=By.id("f-star-rating-4");
	By fifthstar=By.id("f-star-rating-5");
	//By distance= By.linkText("Distance");
	//By citycenter=By.xpath("//a[contains(text(),'City center']");
	By citycenter=By.xpath("//a[text()='City center']");
	//By distance= By.xpath("//a[contains(text(),'Distance']");
	By distance=By.linkText("Distance");
	By hotelList = By.xpath("//li//a[@class='property-name-link'][contains(text(),'')] ");
    By hilton3star = By.xpath("//li//a[@class='property-name-link'][contains(text(),'Hilton')]");
//  By hilton3star = By.xpath("//li//a[@class='property-name-link']");
	By milescity = By.xpath("//li[contains(text(),'miles to City center')] ");
     By hotelName = By.xpath("//a[@class='property-name-link']");

					
	
	//Constractors
	
	 public ThreeStarHotels(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		javaScriptUtil=new JavaScriptUtil(driver);
	
	}
	
	// Page title
		public String getPageTitle() {
			return elementUtil.waitForGetPageTitle(AppConstants.THREESTARHOTELS_PAGE_TITLE);
		}	
	
	//public void select3stars() throws InterruptedException {
//        elementUtil.getElement(threestar).click();
//        elementUtil.waitForElementPresent(hilton3star);
//        javaScriptUtil.scrollPageDown();

     
     
	
	   public void showHiltonAvailablein3Star() throws InterruptedException{
		   elementUtil.getElement(threestar).click();
// 	        elementUtil.waitForElementPresent(hilton3star);
//               javaScriptUtil.scrollDownPage(600, driver);
//	         List<WebElement> hotelsList = driver.findElements(hilton3star);
//			  for(WebElement hotels: hotelsList){
//	               javaScriptUtil.scrollDownPage(600, driver);
//				if (hotels.getText().contains("Hilton")) {
//					System.out.println("We have a Hilton  available");
//					System.out.println(hotels.getText());

		 List<WebElement>allhotel=driver.findElements(hotelList);
		 javaScriptUtil.scrollDownPage(1000, driver);
		   //List<WebElement> listHilton = driver.findElements(By.xpath("//a[contains(text(),‘Hilton’)]"));
					System.out.println(allhotel.size()+ " 3 star otels are available in the selected area.");
					for (int i = 0; i < allhotel.size(); i++) {
						String text = allhotel.get(i).getText();
						System.out.println(text);
						if (text.contains("Hilton")) {
							System.out.println("This hilton hotel available"+ text);
							
						}
		   
		   
	   
	   }}
			
	   
			public FourStarHotels gotoFourStarHotelsPage() throws InterruptedException {
				showHiltonAvailablein3Star();
				return new FourStarHotels(driver); 
	   
	   
	   }
}





			
					
					
			
			

	

	


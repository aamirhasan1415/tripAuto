package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	WebDriver driver;
	
	//constructor
	public OffersPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	//Locators
	By bannerText = By.xpath("//h2[normalize-space()='Great Offers & Amazing Deals']");
	
	
	//Action Mathods
	public boolean validateTitle() {
		
		String expectedTitle="Domestic Flights Offers | Deals on Domestic Flight Booking | Yatra.com";
		String actualTitle = driver.getTitle();
		return expectedTitle.equals(actualTitle);
	}
	
	public boolean validateBanner() {
		
		String expectedBannerText = "Great Offers & Amazing Deals";
		String actualBannerText = driver.findElement(bannerText).getText();
		return expectedBannerText.equals(actualBannerText);
		
	}
}

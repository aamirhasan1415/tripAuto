package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.ScreenshotUtil;
import Utility.WindowHandler;
import browserImplementation.BrowserConfigReader;
import configReader.ObjectReader;
import pages.BusPage;
import pages.HomePage;
import pages.OffersPage;


public class TripPackageTest {
	
	WebDriver driver;
	ObjectReader or;
	
	HomePage loginToHomePage;
	OffersPage offers;
	BusPage bus;
	
	WindowHandler currentWindow;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		BrowserConfigReader browser = new BrowserConfigReader();
		or =new ObjectReader();
		
		driver = browser.getBrowser(or.getBrowserName());
		driver.get(or.getBaseUrl());
		
		loginToHomePage = new HomePage(driver);
		offers = new OffersPage(driver);
		bus = new BusPage(driver);
		
		
		
	}
	
	@Test
	public void tripPackageTest() {
		String email = or.getEmailId();
		String password = or.getPassword();
		loginToHomePage.login(email, password);
		
		//going to new window - https://www.yatra.com/offer/dom/listing/domestic-flight-deals
		loginToHomePage.clickOffers();
		WindowHandler.switchToNewWindow(driver);
		//System.out.println(driver.getCurrentUrl());
		
		
		//validating offer page
		Assert.assertTrue(offers.validateTitle());
		Reporter.log("title validated success fully <br>");
		Assert.assertTrue(offers.validateBanner());
		Reporter.log("Banner validated success fully");
		
		//taking screen shot
		ScreenshotUtil.captureScreenshot(driver);
		
		
		//navigate bus section
		bus.navigateToBus();
		bus.clickCouponCard();
		
		//Switching to url - https://www.yatra.com/offer/details/ytbus-offer
		WindowHandler.switchToNewWindow(driver);
		//System.out.println(driver.getCurrentUrl());
		
		String source = or.getSourceCity();
		String destination = or.getDestinationCity();
		String seats = or.getNoOfSeats();
		bus.searchBus(source, destination,seats );
		
		
		bus.printBusDetails();
		
		
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}

package pages;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusPage {
	
	WebDriver driver;
	static String today;
	
	//constructor 
	public BusPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//static initializer initializes when class is loaded
	static {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		today = now.format(formatter);
	}
	
	
	//locators
	By clickOnBus = By.linkText("Bus");
	By clickCouponCard = By.xpath("//p[text()='Coupon Code : YTBUS']");
	
	By enterSource = By.xpath("//input[@id='BE_bus_from_station']");
	By firstOptionSource = By.xpath("//div[contains(@class,'origin_ac')]//li[1]");
	By enterDestination = By.xpath("//input[@id='BE_bus_to_station']");
	By firstOptionDest = By.xpath("//div[contains(@class,'dest_ac')]//li[1]");
	
	//Choosing CurrentDate in Locators
	By currentDate = By.xpath("//td[@id='"+ today +"']");
	By clickSeats = By.className("ddSpinnerPlus");
	By searchBtn = By.id("BE_bus_search_btn");
	
	
	//name of Buses 
	By nameOfBuses = By.xpath("//ul[@class='seat']/preceding-sibling::div");
	By priceOfBuses = By.xpath("//div[contains(@class,'seat-left')]/preceding-sibling::div");
	
	
	//Action method
	
	//navigate to bus section
	public void navigateToBus() {
		driver.findElement(clickOnBus).click();
	}
	
	//clicking on Coupon Card  - YTBUS
	public void clickCouponCard() {
		driver.findElement(clickCouponCard).click();
	}
	
	//search for Bus
	public void searchBus(String source, String destination, String numberOfSeats) {
		
		driver.findElement(enterSource).sendKeys(source);
		driver.findElement(firstOptionSource).click();
		driver.findElement(enterDestination).sendKeys(destination);
		driver.findElement(firstOptionDest).click();
		driver.findElement(currentDate).click();
		
		//selecting number of seats
		int noOfSeats = Integer.parseInt(numberOfSeats);
		for(int i =1;i<noOfSeats;i++) {
			driver.findElement(clickSeats).click();
		}
		
		//clicking search button
		driver.findElement(searchBtn).click();
		
	}
	
	//print bus details
	public void printBusDetails() {
		List<WebElement> nameOfAllBuses = driver.findElements(nameOfBuses);
		List<WebElement> pricesOfAllBus = driver.findElements(priceOfBuses);
		
		for(int i = 1;i<nameOfAllBuses.size();i++) {
			System.out.println(i+". "+nameOfAllBuses.get(i).getText()+"   ---->   "+pricesOfAllBus.get(i).getText());
		}
	}

}

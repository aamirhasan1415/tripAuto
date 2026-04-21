package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
	
	WebDriver driver;
	
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	//locator
	By enter_emailId = By.id("mobile-number");
	By continueBtn = By.className("style_btnRed__wlTvW");
	By enter_password = By.id("pass");
	By loginBtn = By.className("style_btnRed__wlTvW");
	By offersTxt = By.xpath("//div[contains(text(),'View all offers')]");
	
	//Action Method
	
	public void openSite(String baseUrl) {
		driver.get(baseUrl);
	}
	
	public void login(String email, String password) {
		driver.findElement(enter_emailId).sendKeys(email);
		driver.findElement(continueBtn).click();
		driver.findElement(enter_password).sendKeys(password);
		driver.findElement(loginBtn).click();
	}
	
	public void clickOffers() {
		driver.findElement(offersTxt).click();
	}
}

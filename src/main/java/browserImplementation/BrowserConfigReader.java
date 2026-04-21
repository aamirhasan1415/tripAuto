package browserImplementation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BrowserConfigReader {
	WebDriver driver;
	
	
	public WebDriver getBrowser(String browser) {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
	}
	

}
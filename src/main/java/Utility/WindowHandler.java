package Utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class WindowHandler {
		
	public static void switchToNewWindow(WebDriver driver) {
		
		
		List<String> allWindowsIds = new ArrayList<>(driver.getWindowHandles());
		
		int size = allWindowsIds.size();
		driver.switchTo().window(allWindowsIds.get(size-1));
		allWindowsIds.clear();
	}
}

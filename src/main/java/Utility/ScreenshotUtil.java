package Utility;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	//static method
	public static void captureScreenshot(WebDriver driver) {
			
			try {
				TakesScreenshot ts = (TakesScreenshot)driver;
				
				File SourceImage = ts.getScreenshotAs(OutputType.FILE);
				String location = System.getProperty("user.dir");
				File destFile = new File(location+"\\src\\test\\resources\\ScreenShots\\fullScreenShot.png");
				FileUtils.copyFile(SourceImage, destFile);
				System.out.println("ScreenShot taken Successfull");
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
}

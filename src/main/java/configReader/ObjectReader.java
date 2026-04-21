package configReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectReader {
	Properties pro;
	FileInputStream fis;
	
	//constructor
	public ObjectReader() throws IOException {
		
//		String objectFileLocation = System.getProperty("user.dir");
//		System.out.println(objectFileLocation);
		fis = new FileInputStream(
				"C:\\Users\\2480038\\eclipse-workspace2\\tripPackageAuto\\ObjectRepository\\object.properties");
		pro = new Properties();
		pro.load(fis);
	}

	// getter for Website URL
	public String getBaseUrl() {
		return pro.getProperty("BaseURl");
	}
	
	//getter for browserName
	public String getBrowserName() {
		return pro.getProperty("browser");
	}
	
	public String getEmailId() {
		return pro.getProperty("emailId");
	}
	
	public String getPassword() {
		return pro.getProperty("password");
	}
	
	public String getSourceCity() {
		return pro.getProperty("sourceCity");
	}
	
	public String getDestinationCity() {
		return pro.getProperty("destinationCity");
	}
	
	//return type is string you have to convert 
	public String getNoOfSeats() {
		return pro.getProperty("noOfSeats");
	}
	
		

}
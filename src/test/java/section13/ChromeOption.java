package section13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOption {

	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		
//		method to accept insecure certificates
		option.setAcceptInsecureCerts(true);
		
		
//		CHROME CAPABILITIES
		
//		 to set the Proxy in chrome
		 Proxy proxy=new Proxy();
		 proxy.setHttpProxy("ipAdd:8888");
		 option.setCapability("proxy",proxy);
		 
//		 to block the pop-up dialogs
		 option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		 
//		 to set the download directory
		 Map<String, Object> prefs=new HashMap<String, Object>();
		 prefs.put("download.default_directory", "/directory/path");
		 option.setExperimentalOption("prefs", prefs);		
		
		WebDriver driver=new ChromeDriver(option);
		
//		to maximize the window
		driver.manage().window().maximize();
		
//		to delete all the cookies
		driver.manage().deleteAllCookies();
		
//		It is better to delete the cookies in the beginning so that each test run starts with a clean slate 
//		and free from the influence of old session data, login tokens
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}

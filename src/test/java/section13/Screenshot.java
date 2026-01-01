package section13;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
//		to take the screenshot.
//		TakesScreenshot is an interface and we need to cast the driver for this
		
//		the below line stores the screenshot in a File Object.class This is usually a temporary file
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
//		This line copies the screenshot file from a temporary location to a permanent path on our system.
		FileUtils.copyFile(src,new File("C:\\Users\\ankit\\eclipse-workspace\\SeleniumLearning\\screenshots.png"));
		
		driver.quit();
	}

}

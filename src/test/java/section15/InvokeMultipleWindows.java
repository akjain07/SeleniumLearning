package section15;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Scenario : 1) navigate to https://rahulshettyacademy.com/angularpractice/
 * 2) Fill the name with the first course available at https://rahulshettyacademy.com/ 
 */

public class InvokeMultipleWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

////		We can invoke multiple windows/tabs using one driver Instance. This is a feature of Selenium 4.0
		driver.get("https://rahulshettyacademy.com/angularpractice/");

//		to open a new tab
		driver.switchTo().newWindow(WindowType.TAB);

//		to open a new window
//		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> windHandles = driver.getWindowHandles();
		Iterator<String> itr = windHandles.iterator();
		String par = itr.next();
		String child = itr.next();

		driver.switchTo().window(child);

		driver.get("https://rahulshettyacademy.com/");

//		if a class contains ":" then we need to use \\ in CSS to escape this
		String courseName = driver
				.findElements(By
						.cssSelector("h3.font-bold.text-lg.group-hover\\:text-primary.transition-colors.leading-tight"))
				.get(0).getText();

		System.out.println(courseName);

		driver.switchTo().window(par);

		WebElement name = driver.findElement(By.cssSelector("input[name='name']"));

		name.sendKeys(courseName);

//		taking the screenshot of an element instead of the whole page
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("element.png"));

//		get the height and width of an element
		int height = name.getRect().getDimension().getHeight();
		int width = name.getRect().getDimension().getWidth();
		System.out.println("height is "+height + " width is "+width);

		driver.quit();

	}

}

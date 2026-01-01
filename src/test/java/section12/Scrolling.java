package section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		To scroll the webpage
//		JavascriptExecutor is an interface that allows the driver to execute javascript commands directly within the browser
		
//		WebDriver instance need to be type casted
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
//		to execute the javascript for scrolling the webpage
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(5000);
//		to scroll the rows in a table
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<values.size();i++) {
//			to convert the string into an int
			sum+=Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		
		driver.quit();
	}

}

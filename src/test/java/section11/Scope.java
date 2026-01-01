package section11;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
	
//		Limiting the webdriver scope
//		Step1-> find the parent element
		WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
		
//		Step2-> search in the scope of parent element
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		WebElement colDriver = footerDriver.findElement(By.cssSelector("table[class='gf-t'] td ul"));
		
//		Counting the links in the column of footer section
		System.out.println(colDriver.findElements(By.tagName("a")).size());
		
//		To check the broken links in the column of footer section
		
		for(int i=0;i<colDriver.findElements(By.tagName("a")).size();i++) {
			
//			ctrl+click -> open the link in a different tab
			String clickingOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			colDriver.findElements(By.tagName("a")).get(i).sendKeys(clickingOnLink);
			
		}
		
//		Printing the titles of each window tab
		Set<String> windHandles=driver.getWindowHandles();
		Iterator<String> itr=windHandles.iterator();
		
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
	
		
		driver.quit();
	}

}

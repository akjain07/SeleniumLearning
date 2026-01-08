package section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
//		to maximize the window
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/droppable/");
		
//		switching to an iframe using webelement
//		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
//		to count the number of iframe in webpage
		int iframeSize = driver.findElements(By.tagName("iframe")).size();
		
		System.out.println(iframeSize);
		
//		switching to an iframe using index
//		driver.switchTo().frame(0);
		
//		switching to an iframe using WebElement
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		Actions act=new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));
		
//		drag and drop the elements
		act.dragAndDrop(source, target).build().perform();
		
		driver.quit();

	}

}

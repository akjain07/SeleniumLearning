package section10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		
		Actions act=new Actions(driver);
		WebElement signIn = driver.findElement(By.cssSelector("div#nav-link-accountList"));
		
//		build() is used to compile a sequence of chained actions into a single executable unit when multiple actions are involved
//		perform() is used to execute the defined actions
//		moveToElement -> moves to specific element
		act.moveToElement(signIn).contextClick().build().perform();
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
//		keyDown -> to hold the key
//		composite actions
		act.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("Ankit").doubleClick().build().perform();
	}

}

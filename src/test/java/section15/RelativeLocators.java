package section15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

//		name input field
		WebElement nameBox = driver.findElement(By.cssSelector("input[name='name']"));

//		locate the label of the name field which is having below html code
//		<label>Name</label>
//		To locate the above element, either we can traverse from parent to child or we can use relative locators

//		above() method
		String fieldName = driver.findElement(with(By.tagName("label")).above(nameBox)).getText();

		System.out.println(fieldName);

//		below() method
		WebElement passwdlabel = driver.findElement(By.cssSelector("label[for='exampleInputPassword1']"));
		driver.findElement(with(By.tagName("input")).below(passwdlabel)).click();

		Thread.sleep(5000);
		
//		toLeftOf() method ng-touched
		WebElement text = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(text)).click();
		
//		toRightOf() method
		WebElement btn = driver.findElement(By.cssSelector("#inlineRadio1"));
		String radioText = driver.findElement(with(By.tagName("label")).toRightOf(btn)).getText();
		System.out.println(radioText);
		
		driver.quit();

	}

}

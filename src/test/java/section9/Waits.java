package section9;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Waits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
//		Implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
//		Explicit Wait
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(5));

		String[] itemNeed = { "Cauliflower", "Beans", "Carrot" };

		addItems(driver, itemNeed);
		
//		Clicking on Cart button
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
//		Clicking on Proceed to Checkout button
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
//		Entering Promo Code
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
//		Clicking the Promo button
		driver.findElement(By.className("promoBtn")).click();
		

//		we have to pass the locator to the below method not the WebElement
//		driver.findElement(By.className("promoInfo")) --> webelement
//		By.className("promoInfo") --> locator
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
//		Grabbing the Promo Text
		String promoInfo = driver.findElement(By.className("promoInfo")).getText();
		
		System.out.println(promoInfo);
		
		driver.quit();
	
	}

	public static void addItems(WebDriver driver, String[] itemNeed) {
		int j = 0;

		List<WebElement> prodNames = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < prodNames.size(); i++) {

			String name = prodNames.get(i).getText().split("-")[0].trim();

//			Convert array into ArrayList as arrays use less space and in this way, arrayList will be declared at runtime
			List itemList = Arrays.asList(itemNeed);

			if (itemList.contains(name)) {

				j++;

//				ADD TO CART-> just a text value in the html
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemNeed.length) {
					break;
				}

			}

		}
	}
}

package section7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
//		Entering the Country
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("In");
		Thread.sleep(3000);
		
//		Storing the options in a list by using a generic xpath that highlights all the options
		List<WebElement> options = driver.findElements(By.cssSelector("li.ui-menu-item a"));
		
		for(WebElement option: options) {
			if(option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
		
//		To check if the checkbox is selected or not
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
//		Count number of Check boxes
//		input[type='check box'] is a generic locator for all check boxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
//		Selecting the Radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
//		getDomAttribute() to get the attribute value from html
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			System.out.println("enabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
	}

}

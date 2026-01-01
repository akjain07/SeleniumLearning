package section14;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterFunctionality {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
//		searching for rice in search bar
		driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys("Rice");
		
		List<WebElement> searchResult = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> actualResult = searchResult.stream().filter(vegg->vegg.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(searchResult.size(), actualResult.size());

	}

}

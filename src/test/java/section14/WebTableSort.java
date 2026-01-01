package section14;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.cssSelector("th[role='columnheader']:nth-child(1)")).click();

//		veggies
		List<WebElement> oriList = driver.findElements(By.xpath("//tr/td[1]"));

//		to get the text from each element
		List<String> originalList = oriList.stream().map(s -> s.getText()).collect(Collectors.toList());

//		sorting the original list to check the functionality
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(originalList.equals(sortedList));

//		get the price of veggie "Bean"
		List<String> priceList = oriList.stream().filter(s -> s.getText().contains("Beans"))
				.map(s -> getVeggiePrice(s)).collect(Collectors.toList());
		priceList.stream().forEach(s->System.out.println(s));
		List<String> rows;
		
//		Automating pagination scenarios
		do {
			List<WebElement> veggie = driver.findElements(By.xpath("//tr/td[1]"));
			rows = veggie.stream().filter(s -> s.getText().contains("Rice"))
					.map(s -> getVeggiePrice(s)).collect(Collectors.toList());
			rows.stream().forEach(s->System.out.println(s));
			
			if(rows.size()<1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
			
			
		}while(rows.size()<1);

//		driver.quit();
	}

	private static String getVeggiePrice(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}

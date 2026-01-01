package section8;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] itemNeed= {"Cauliflower","Beans","Carrot"};
		int j=0;
		
		List<WebElement> prodNames = driver.findElements(By.cssSelector("h4.product-name"));
		
		
		for(int i=0;i<prodNames.size();i++) {
			
			String name = prodNames.get(i).getText().split("-")[0].trim();
			
//			Convert array into ArrayList as arrays use less space and in this way, arrayList will be declared at runtime
			List itemList = Arrays.asList(itemNeed);
			
			if(itemList.contains(name)) {
				
				j++;
				
//				ADD TO CART-> just a text value in the html
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==itemNeed.length) {
					break;
				}
				
			}
		}
		
	}

}

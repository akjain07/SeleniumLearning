package section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class UpdatedDropDown {

	public static void main(String[] args) throws InterruptedException {
		
//		Opening the browser in Incognito mode
		ChromeOptions chrOpt=new ChromeOptions();
		chrOpt.addArguments("--incognito");
		
		WebDriver driver=new ChromeDriver(chrOpt);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
//		Opening the Drop down
		driver.findElement(By.id("divpaxinfo")).click();
		
		Thread.sleep(2000);
		//Adding Adults
		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
//		Clicking on Done button
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		

	}

}

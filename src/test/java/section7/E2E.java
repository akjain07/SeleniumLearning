package section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		
//		Opening the browser in Incognito mode
		ChromeOptions chrOpt=new ChromeOptions();
		chrOpt.addArguments("--incognito");
		
		WebDriver driver=new ChromeDriver(chrOpt);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
//		STATIC DROPDOWN
		WebElement currency=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select sel=new Select(currency);
		
//		Selecting using index
		sel.selectByIndex(3);
		
//		Opening the From Drop down
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
//		Selecting BLR
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		Thread.sleep(2000);
		
//		Selecting Chennai in Destination
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
//		Selecting the Radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
//		getDomAttribute() to get the attribute value from html
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
			System.out.println("disabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
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
		
		driver.findElement(By.cssSelector("input[name='ctl00$mainContent$btn_FindFlights']")).click();

	}

}

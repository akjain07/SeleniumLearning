package section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
//		STATIC DROPDOWN
		WebElement currency=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select sel=new Select(currency);
		
//		Selecting using index
		sel.selectByIndex(3);
		
//		Print the selected option
		System.out.println(sel.getFirstSelectedOption().getText());
		
//		Selecting using Visible text
		sel.selectByVisibleText("AED");
		
		System.out.println(sel.getFirstSelectedOption().getText());
		
//		Select using Value
//		<option value="INR">INR</option>
		sel.selectByValue("INR");
		
		driver.quit();

	}

}

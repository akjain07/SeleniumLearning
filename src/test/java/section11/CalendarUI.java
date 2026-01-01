package section11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String date="14";
		String month="6";
		String year ="2027";
		
//		Clicking the calendar field
		driver.findElement(By.cssSelector("div.react-date-picker__inputGroup")).click();
		
//		Opening the year
		driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
		
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		
//		Selecting the month
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		
//		Selecting the date
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		
//		Asserting the input and selected date
		String[] expected= {month,date,year};
		
		List<WebElement> actual=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(int i=0;i<actual.size();i++) {
			System.out.println(actual.get(i).getAttribute("value"));
			Assert.assertEquals(actual.get(i).getAttribute("value"), expected[i]);
		}
			
		
	}

}

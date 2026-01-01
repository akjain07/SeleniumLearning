package section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		String name = "Ankit";

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(name);

		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();

		System.out.println(driver.switchTo().alert().getText());

//		To accept the Alert
		driver.switchTo().alert().accept();

		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(name);

		driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();

		System.out.println(driver.switchTo().alert().getText());

//		To dismiss the Alert
		driver.switchTo().alert().dismiss();

	}

}

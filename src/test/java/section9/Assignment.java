package section9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		String[] text = driver.findElement(By.cssSelector("p[class='text-center text-white']")).getText().split(" ");
		String username = text[2].trim();
		String pass = text[6].replace(")", "");

		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(username);

		driver.findElement(By.cssSelector("input[id='password']")).sendKeys(pass);

//		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

		WebElement drpDown = driver.findElement(By.cssSelector("select[class='form-control']"));

		Select sel = new Select(drpDown);

		sel.selectByValue("consult");

		driver.findElement(By.id("signInBtn")).click();

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(" Checkout ( 0 ) ")));

		driver.findElements(By.xpath("//button[@class='btn btn-info']"));

//		driver.findElement(By.linkText(" Checkout ( 0 ) ")).click();

	}

}

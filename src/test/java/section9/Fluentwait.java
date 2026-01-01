package section9;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Fluentwait {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.cssSelector("div#start button")).click();
		
//		FluentWait implements wait interface
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
//				Tells FluentWait to ignore this exception during polling
				.ignoring(NoSuchElementException.class);

//				wait.until() keeps calling the given function until it returns a non-null value.
				WebElement foo = wait.until(new Function<WebDriver, WebElement>()

				{
//				function FluentWait repeatedly executes during polling.
				public WebElement apply(WebDriver driver)

				{
							if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
								return driver.findElement(By.cssSelector("div[id='finish'] h4"));
							}
							else {
								return null;
							}
				           

				}

				});


				System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());

				
	}
}

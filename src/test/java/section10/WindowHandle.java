package section10;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		Set<String> windHandle = driver.getWindowHandles();
		
		Iterator<String> itr=windHandle.iterator();
		
//		pointing to the first element
		String parId = itr.next();
		
//		pointing to the second element
		String childId = itr.next();
		
		driver.switchTo().window(childId);
		
		String email = driver.findElement(By.cssSelector(".im-para.red a")).getText();
		
		System.out.println(email);
		
		driver.switchTo().window(parId);
		
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(email);
		
	}

}

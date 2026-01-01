package section5_6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		String username = "ankit";
		String password=getPassword(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys(username);
		
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
//		String successMsg=driver.findElement(By.xpath("//div[@class='login-container']/p")).getText();
		
		String successMsg = driver.findElement(By.tagName("p")).getText();
		
		System.out.println(successMsg);
		
		Assert.assertEquals(successMsg, "You are successfully logged in.");
		
//		Verifying the username 
		String displUser = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		
		Assert.assertEquals(displUser,"Hello "+username+",");
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		driver.quit();

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
//		Please use temporary password 'rahulshettyacademy' to Login.
		String passText=driver.findElement(By.cssSelector("form p")).getText();
		
		String[] passArray=passText.split("'");
		String pass=passArray[1].split("'")[0];
		return pass;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

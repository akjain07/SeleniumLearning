package section5_6;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
//		to open the page in browser
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
//		entering username using ID LOCATOR
//		<input type="text" placeholder="Username" id="inputUsername" value="">

		driver.findElement(By.id("inputUsername")).sendKeys("ankit");
		
//		entering password using NAME LOCATOR
//		<input type="password" placeholder="Password" name="inputPassword" value="">
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		
//		clicking the Sign-In Button using CLASS locator
//		<button class="submit signInBtn" type="submit">Sign In</button>
		driver.findElement(By.className("signInBtn")).click();
//		driver.findElement(By.cssSelector("button.signInBtn")).click();
//		driver.findElement(By.cssSelector(".signInBtn.submit")).click();
		
//		Need to give the whole class while building customised xpath
//		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		
//		Thread.sleep(2000);
		
//		fetching error msg using CSS Selector
//		<p class="error" xpath="1">* Incorrect username or password </p>
		String errorMsg = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorMsg);
		
//		Clicking the 'Forgot your password link' using LINKTEXT locator
//		<a href="#">Forgot your password?</a>
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(2000);
		
		
//		Entering name using XPATH locator
//		<input type="text" placeholder="Name">
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ankit");
		
//		Entering email using CSS Selector
//		<input type="text" placeholder="Email">
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@bewakoof.com");
		
//		Clearing the Email field
//		INDEXING in X-path
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
//		Entering email again using INDEXING IN CSS SELECTOR
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		
//		Entering the phone number using PARENT TO CHILD TRAVERSAL
		driver.findElement(By.xpath("//div/form/input[3]")).sendKeys("98458877");
		
//		Clicking on the Reset button using class
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
//		Grabbing the info msg using tags in CSS Selector
		String infoMsg = driver.findElement(By.cssSelector("form p")).getText();
		
		System.out.println(infoMsg);
//		Please use temporary password 'rahulshettyacademy' to Login.
		
//		Clicking the Go to Login button 
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		Thread.sleep(1000);
		
//		Entering username 
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("naukri");
		
//		Entering password using REGULAR EXPRESSION IN CSS SELECTOR
//		<input type="password" placeholder="Password" name="inputPassword" value="">
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
//		Checking the checkbox
		driver.findElement(By.id("chkboxOne")).click();
		
//		Sign In button
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();		
		
	}

}

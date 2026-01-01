package section13;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));
		
//		allow a test to continue executing even after an assertion fails, recording all failures before reporting them at the end of the test method
		SoftAssert a =new SoftAssert();
		
		for(WebElement link: links) {
			
			String url = link.getAttribute("href");
			
//			HttpURLConnection class has methods to send HTTP request and capture HTTP response code. 
//			So, output of openConnection() method (URLConnection) is type casted to HttpURLConnection.
			
			HttpURLConnection conn = (HttpURLConnection)new URI(url).toURL().openConnection();
			
//			We can set Request type as “HEAD” instead of “GET”. So that only headers are returned and not document body.
			conn.setRequestMethod("HEAD");
			
//			actual connection to url is established and the request is sent.
			conn.connect();
			
			int resCode = conn.getResponseCode();
			System.out.println(resCode);
			
//			to check the condition and print the msg if the condition fails
			a.assertTrue(resCode<400, "the broken link is"+link.getText()+"and the response code is "+resCode);
			
//			if(resCode>400) {
//				System.out.println("the broken link is"+link.getText()+"and the response code is "+resCode);
//				Hard assertion as the script will fail once it reaches here
//				Assert.assertFalse(true);
//			}
			
		}
//		This method collects all the recorded failures and throws a single exception if any assertion failed, marking the test as "failed" in the report.
		a.assertAll();
		
		
		
		driver.quit();

	}

}

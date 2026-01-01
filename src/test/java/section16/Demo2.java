package section16;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2 {

	@Test
	public void firstMethod() {
		System.out.println("This is method 1 of Demo2 class");
	}
	
	@Test
	public void secondMethod() {
		System.out.println("This is method 2 of Demo2 class");
	}
	
	@Test(groups= {"Smoke"})
	public void thirdMethod() {
		System.out.println("This is method 3 of Demo2 class");
	}
	
	@Test
	public void fourthMethod() {
		System.out.println("This is method 4 of Demo2 class");
		Assert.assertTrue(false);
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("The method AfterTest is called in Demo2 class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("The method BeforeMethod is called in Demo2 class");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("The method AfterMethod is called in Demo2 class");
	}

}

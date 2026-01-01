package section16;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Demo3 {

	@Test
	public void firstMethod() {
		System.out.println("This is method 1 of Demo3 class");
	}
	
	@Test(groups= {"Smoke"})
	public void secondMethod() {
		System.out.println("This is method 2 of Demo3 class");
	}
	
	@Test
	public void thirdMethod() {
		System.out.println("This is method 3 of Demo3 class");
	}
	
	@Test(dependsOnMethods= {"thirdMethod"})
	public void fourthMethod() {
		System.out.println("This is method 4 of Demo3 class");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("The method BeforeSuite is called in Demo3 class");
	}

}

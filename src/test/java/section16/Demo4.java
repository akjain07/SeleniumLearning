package section16;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo4 {

	@Test
	public void firstMethod() {
		System.out.println("This is method 1 of Demo4 class");
	}

	@Test
	public void secondMethod() {
		System.out.println("This is method 2 of Demo4 class");
	}

	@Test
	public void thirdMethod() {
		System.out.println("This is method 3 of Demo4 class");
	}

	@Parameters({ "URL","Username" })
	@Test
	public void fourthMethod(String url, String username) {
		System.out.println("This is method 4.1 of Demo4 class");
		System.out.println("Value is coming from xml file "+url);
		System.out.println("Value is coming from xml file "+username);
	}

	@Test(groups = { "Smoke" })
	public void fourthPartMethod() {
		System.out.println("This is method 4.2 of Demo4 class");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("The method AfterSuite is called in Demo4 class");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("The method BeforeClass is called in Demo4 class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("The method AfterClass is called in Demo4 class");
	}

}

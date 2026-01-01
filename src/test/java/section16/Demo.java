package section16;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {

//	It is a core annotation in TestNG and it marks a method as a test case that TestNG should execute
	@Test(groups= {"Smoke"})
	public void firstMethod() {
		System.out.println("This is method 1 of Demo class");
	}
	

//	we can define multiple test in a single class
	@Test
	public void secondMethod() {
		System.out.println("This is method 2 of Demo class");
	}
	
	@Test
	public void thirdMethod() {
		System.out.println("This is method 3 of Demo class");
	}
	
	@Test
	public void fourthMethod() {
		System.out.println("This is method 4 of Demo class");
	}
	
//	For each <test> tag, TestNG will run the @BeforeTest methods that belong to classes included in that <test>.
	@BeforeTest
	public void beforeTest() {
		System.out.println("The method BeforeTest is called in Demo class");
	}
	

	
	/*
	 * What actually happens in TestNG
	 * 
	 * TestNG:
	 * 1) Looks at a <test> block in testng.xml
	 * 2) Loads only the classes listed under that <test>
	 * 3) From those classes only, it executes:
	 * -> @BeforeTest
	 * -> then the @Test methods
	 * -> then @AfterTest
	 * 
	 * So: If a class is not part of a <test>, its config methods are not considered for that <test>.
	 *  
	 */
	

}

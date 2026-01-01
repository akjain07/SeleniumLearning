package section17;

import org.testng.annotations.BeforeMethod;

public class Parent {

	public void parMethod1() {
		System.out.println("Running parMethod from parent class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("run me first");
	}

}

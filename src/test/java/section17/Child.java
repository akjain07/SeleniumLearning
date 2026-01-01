package section17;

import org.testng.annotations.Test;

public class Child extends Parent{
	
	/*
	 
	  The Parent class acts as a base class providing reusable utility methods and common setup using @BeforeMethod.
	  The Child class extends it and contains the actual test annotated with @Test. During execution, TestNG first 
	  runs the parent’s @BeforeMethod, then the child’s test method, demonstrating inheritance and TestNG lifecycle management.
	  
	 */
	
	
	@Test
	public void childMethod() {
//		we can execute parMethod1() without creating an object of Parent because of inheritance.
		parMethod1();
		
		int var=4;
		
//		Parametized constructor
		Construct con=new Construct(var);
		
		System.out.println(con.increement());
		System.out.println(con.decreement());
		
//		Multiply mul=new Multiply(var);
		
		System.out.println(con.multiByTwo());
		System.out.println(con.multiByThree());
	}
	
	
}

package section17;

public class Construct extends Multiply{
	
//	class variable
	int a;
	
//	The super(a) call in Construct ensures the parent class constructor is executed first, which initializes 
//	the inherited variable. This shows constructor chaining and proper object initialization.
	
//	we are passing instance variable
	public Construct(int a) {
//		this line 'super(a)' always have to be written first
		super(a); //calling constructor of parent class
		this.a=a;
	}

	public int increement() {
		a+=1;
		return a;
	}
	
	public int decreement() {
		a-=1;
		return a;
	}

}

package section17;

public class Multiply {

//	class variable
	int a;

//	we are passing instance variable
	public Multiply(int a) {
		this.a=a;
	}

	public int multiByTwo() {
		a *= 2;
		return a;
	}

	public int multiByThree() {
		a *= 3;
		return a;
	}
}

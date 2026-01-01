package section16;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	@Test(dataProvider="getData")
	public void mainFunction(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}

//	In TestNG, @DataProvider is used to run the same test method multiple times with different sets of data.
//	It’s perfect for data-driven testing (logins, forms, APIs, etc.).
	
	@DataProvider
	@Test
	public Object[][] getData() {
//		method which will give the test data to the main function
		
		Object[][] data=new Object[3][2];
		
		//data set1
		data[0][0]="Username1";
		data[0][1]="Password1";
		data[1][0]="Username2";
		data[1][1]="Password2";
		data[2][0]="Username3";
		data[2][1]="Password2";
		
		return data;
	}
}

package tests_michroTech;

import org.testng.annotations.Test;

import base.Base;

public class Test_Customer_Login extends Base {
	@Test (priority = 3)
	//Login as Customer 
	public static void test_Customer_Login() throws InterruptedException {
		p("MMM");
		navigate("https://it.microtechlimited.com");
		System.out.println( page.title() );
		Thread.sleep(2000);

		click("//a[@href='elogin.php']"); 
		click("//a[@href='clogin.php']");

		fill("//input[@name='mailuid']", "david@gmail.com");
		
		fill("//input[@name='pwd']", "1234");
		
		click("//input[@name='login-submit']");
		
		String welcomeMessage = innerText("//h2[1]");	
		System.out.println(welcomeMessage);
		
		String welcomeMessage1 =innerText("//h2[2]");		
		System.out.println(welcomeMessage1 );
	}

}

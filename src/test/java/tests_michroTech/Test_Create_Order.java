package tests_michroTech;

import org.testng.annotations.Test;

import base.Base;

public class Test_Create_Order extends Base{
	//Create Order page
	@Test (priority = 4)
	public static void test_Create_Order() throws InterruptedException {	
		navigate("https://it.microtechlimited.com");
		System.out.println( "Title page of  :-"+ page.title() );
		//assertion("x path","value");
		Thread.sleep(2000);
		click("//a[@href='elogin.php']");
		fill("//input[@name='mailuid']", "testpilot@gmail.com");	
		fill("//input[@name='pwd']","1234");		
		click("//input[@name='login-submit']");
		//verification of employee login
		assertion("//h2[2]", "Welcome Test");
		String welcomeMessage = innerText("//h2[2]");	
		System.out.println("Employee Login Landing message :-" + welcomeMessage);
		p("Employee Login Page Verification Done");
		Thread.sleep(1000);
		//Product order 
		click("//a[text()='Product Order']");
		Thread.sleep(1000);
		page.selectOption("//select[@name='prodId']", "Camera");
		Thread.sleep(1000);
		fill("//input[@name='ordDate']","11/21/2023");
		Thread.sleep(1000);
		click("//button[@type='submit']");	
		System.out.println("Order Done");
				
		 /* public static void count_Table_Head(String xpath,String xpath2) {//need to ask
		int num=page.locator(xpath).locator(xpath2).count();
		 System.out.println("Table head is : "+num);
		 
		 count_Table_Head("//table","//tr[1]/th");
		 //click("//select[@name='example_length']");
		//we clicked in the menu bar
		click("#example_length > label > select");
		//before clicking we need to find the select the div- meaning the main area at the beginning of code
		arrow down("div.dt-demo-selector__options");
		 
		 */
		

	}

}

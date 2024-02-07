package tests_swagLab;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;

public class Test_Swag_Lab_Logout extends Base {
	public static SoftAssert softAssert= new SoftAssert();
	@Test(priority = 0)
	public void logoutpage1() throws InterruptedException {
		// go to URL
		navigate("https://www.saucedemo.com/");
		// get title page
		System.out.println(page.title());
		// enter user name
		fill("//input[@placeholder='Username']", "standard_user");
		// enter password
		fill("//input[@placeholder='Password']", "secret_sauce");
		// click Login button
		click("//input[@type='submit']");
		// verify title page
		assertion("//div[text()='Swag Labs']", "Swag Labs");
		// verify Login title page Soft assertion
		String actualmessage = innerText("//div[text()='Swag Labs']");
		String expectedmessage = "Swag Labs";
		softAssert.assertEquals(actualmessage, expectedmessage);
		p("Home Page1 Verification Done");
		System.out.println("-------" + actualmessage + "----------");
		// click menu bar for log out
		Thread.sleep(1000);
		click("//button[@id='react-burger-menu-btn']");
		Thread.sleep(1000);
		// click log out
		click("#logout_sidebar_link");
		softAssert.assertAll();
	}

	@Test(priority = 1)
	public void logoutpage2() throws InterruptedException {
		// go to URL
		navigate("https://www.saucedemo.com/");
		// get title page
		System.out.println(page.title());
		// enter user name
		fill("//input[@placeholder='Username']", "standard_user");
		// enter password
		fill("//input[@placeholder='Password']", "secret_sauce");
		// click Login button
		click("//input[@type='submit']");
		// verify title page
		assertion("//div[text()='Swag Labs']", "Swag Labs");
		// click menu bar for log out
		Thread.sleep(1000);
		click("//button[@id='react-burger-menu-btn']");
		Thread.sleep(1000);
		// click log out
		click("#logout_sidebar_link");
		// Fail the Test
		Assert.fail();

	}

	@Test(priority = 3)
	public void logoutpage3() throws InterruptedException {
		// go to URL
		navigate("https://www.saucedemo.com/");
		// get title page
		System.out.println(page.title());
		// enter user name
		fill("//input[@placeholder='Username']", "standard_user");
		// enter password
		fill("//input[@placeholder='Password']", "secret_sauce");
		// click Login button
		click("//input[@type='submit']");
		// verify title page
		assertion("//div[text()='Swag Labs']", "Swag Labs");
		// click menu bar for log out
		Thread.sleep(1000);
		click("//button[@id='react-burger-menu-btn']");
		Thread.sleep(1000);
		// click log out
		click("#logout_sidebar_link");
		if (true)
			throw new SkipException("----Log out Page3 test skip----------");
	}

}

package tests_swagLab;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import base.Base;

public class HomePageVerification extends Base {
	public static SoftAssert softAssert = new SoftAssert();
	@Test(priority = 0, dependsOnMethods="homePage1",alwaysRun=true)
	public void homePage() { // Soft Assertion for pass the Test
		// go to URL
		navigate("https://www.saucedemo.com/");
		// get title page
		System.out.println(page.title());
		// title page verification
		assertThat(page).hasTitle("Swag Labs");
		String name1 = "Swag Labs";
		String name2 = "Swag Labs";
		softAssert.assertEquals(name1, name2);
		softAssert.assertAll("------homePageVerify1 Test is Pass--will not print--------------");
		// softAssert.assertAll();
	}
	@Test(priority = 1)
	public void homePage1() { // Soft Assertion for Fail the Test
		// go to URL
		navigate("https://www.saucedemo.com/");
		// get title page
		System.out.println(page.title());
		// title page verification
		assertThat(page).hasTitle("Swag Labs");
		String name1 = "Swag Labs";
		String name2 = "Swag Labs";
		softAssert.assertEquals(name1, name2);
		softAssert.assertAll("------homePageVerify1 Test is Fail--will print message--------------");
		// softAssert.assertAll();
	}
	@Test(priority = 2)
	public void homepage2() throws InterruptedException {
		// go to URL
		navigate("https://www.saucedemo.com/");
		// get title page
		System.out.println(page.title());
		// title page verification
		assertThat(page).hasTitle("Swag Labs");
		// enter user name
		fill("//input[@placeholder='Username']", "standard_user");
		// enter password
		fill("//input[@placeholder='Password']", "secret_sauce");
		// click Login button
		click("//input[@type='submit']");
		// verify Login title page Hard assertion
		assertion("//div[text()='Swag Labs']", "Swag Labs");
		Thread.sleep(1000);
		// verify Login title page Soft assertion
		String actualmessage = innerText("//div[text()='Swag Labs']");
		String expectedmessage = "Swag Labs";
		softAssert.assertEquals(actualmessage, expectedmessage);
		p("Home Page1 Verification Done");
		System.out.println("-------" + actualmessage + "----------");
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void homePage3() throws InterruptedException { // Fail the Test
		// go to URL
		navigate("https://www.saucedemo.com/");
		// get title page
		System.out.println(page.title());
		// title page verification
		assertThat(page).hasTitle("Swag Labs");
		// enter user name
		fill("//input[@placeholder='Username']", "standard_user");
		// enter password
		fill("//input[@placeholder='Password']", "secret_sauce");
		// click Login button
		click("//input[@type='submit']");
		// verify title page
		assertion("//div[text()='Swag Labs']", "Swag Labs");
		// Assert.fail();
		Assert.fail("-------------homePage3 test Fail---------------------");
	}

	@Test(priority = 4)
	public void logoutpage4() throws InterruptedException { // Skip the Test
		// go to URL
		navigate("https://www.saucedemo.com/");
		// get title page
		System.out.println(page.title());
		// title page verification
		assertThat(page).hasTitle("Swag Labs");
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
			throw new SkipException("----Log out test skip----------");
	}

}

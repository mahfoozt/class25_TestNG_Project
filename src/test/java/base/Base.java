package base;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Base {
	public static Page page;
	public static Browser browser;
	public static Playwright playwright;

	@BeforeSuite
	public void startUp() {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		// Playwright playwright;
		playwright = Playwright.create();

		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");

		LaunchOptions launchOptions;
		launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments)
				.setExecutablePath(Paths.get(chromePath));

		// Browser browser;
		browser = playwright.chromium().launch(launchOptions);

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

		page = context.newPage();
	}

	public static void fill(String locator, String value) {
		page.locator(locator).fill(value);
	}

	public static void navigate(String url) {
		page.navigate(url);
	}

	public static void click(String locator) {
		page.locator(locator).click();
	}

	public static String innerText(String locator) {
		String s = page.locator(locator).innerText();
		return s;
	}

	public static void assertion(String xpath, String text) {
		assertThat(page.locator(xpath)).hasText(text);
	}

	public static void p(String s) {
		System.out.println(s);
	}

	public static void Selection(String path, String value) {
		page.selectOption(path, value);
	}
//			private static LocatorAssertions asserThat(Locator first) {
//				
//				return null;
//			}
//			private static String assertion1(Locator locator) {
//				assertThat(locator);
//				return null;
//			}

	private static APIResponse title() {
		return null;
	}

	@AfterSuite
	public void Close_All() {
		page.close();
		browser.close();
		playwright.close();
	}

}

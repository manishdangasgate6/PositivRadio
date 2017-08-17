package PR_Signup;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SocialFacebookSignUpTest {
	File file = new File("ChromeDriver/phantomjs");				
	   
	public String st = System.setProperty("phantomjs.binary.path", file.getAbsolutePath());

	public  WebDriver driver = new PhantomJSDriver();

	@Test
	public void Email_Validation() throws InterruptedException {

		driver.get("http://positivradio.test.gate6.com/web/#/register");
		driver.findElement(By.className("facebook")).click();

		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window

		Thread.sleep(5000);
		String PopURL = driver.getCurrentUrl();
		System.out.println("TEst" + PopURL);
		// Now you are in the popup window, perform necessary actions here

		driver.findElement(By.id("email")).sendKeys("arti.chouhantest@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("gatesix#12");
		driver.findElement(By.name("login")).click();
		// driver.switchTo().window(parentWindowHandler); // switch back to parent
		// window
		// //Thread.sleep(5000);
		// String PerentURL = driver.getCurrentUrl();
		// System.out.println(PerentURL);
		// System.out.println("Here is working");

	}

	@BeforeTest
	public void beforeTest() {

		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}
}
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

public class Signup_Test {
	// public String st = System.setProperty("phantomjs.binary.path",
	// file.getAbsolutePath());
	//
	// public WebDriver driver = new PhantomJSDriver();

	public String st = System.setProperty("webdriver.gecko.driver", "home/mpatil/geckodriver");

	public  WebDriver driver = new FirefoxDriver();

	@Test(priority = 1)
	public void CheckApp_Status() {

		driver.get("http://positivradio.test.gate6.com/web/");
		driver.findElement(By.className("facebook"));
		System.out.print("Application is working");

	}


	@Test(priority = 2)
	public void BlankEmail() {

		driver.get("http://positivradio.test.gate6.com/web/#/register");
		driver.findElement(By.name("fullName")).sendKeys("Manish Dangas");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/#/register");

	}

	@Test(priority = 3)
	public void BlankFullName() {

		driver.get("http://positivradio.test.gate6.com/web/#/register");
		driver.findElement(By.name("fullName")).sendKeys("");
		driver.findElement(By.id("email")).sendKeys("manish.dangas@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/#/register");

	}

	@Test(priority = 4)
	public void InvalidEmail() {

		driver.get("http://positivradio.test.gate6.com/web/#/register");
		driver.findElement(By.name("fullName")).sendKeys("Manish Dangas");
		driver.findElement(By.id("email")).sendKeys("manish@.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("@.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();

	}

	@Test(priority = 5)
	public void InvalidPassword() {

		driver.get("http://positivradio.test.gate6.com/web/#/register");
		driver.findElement(By.name("fullName")).sendKeys("Manish Dangas");
		driver.findElement(By.id("email")).sendKeys("manish.dangas@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Gate2");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/#/register");

	}

	@Test(priority = 6)
	public void ValidSignup() {

		driver.get("http://positivradio.test.gate6.com/web/#/register");
		driver.findElement(By.name("fullName")).sendKeys("Manish Dangas");
		driver.findElement(By.id("email")).sendKeys("manish.dangas@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/#/register");

	}

	@Test(priority = 7)
	public void FaceBookSignup() throws InterruptedException {

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

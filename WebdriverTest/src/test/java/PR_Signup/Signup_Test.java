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

	// Chrome Windows
	//public String st = System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	//public WebDriver driver = new ChromeDriver();

	// Linux firefox
	 //public String st = System.setProperty("webdriver.gecko.driver",
	 //"/home/mpatil/geckodriver");
	// public WebDriver driver = new FirefoxDriver();
	 
	 // Chrome Linux
	public String st = System.setProperty("webdriver.chrome.driver", "home/mpatil/chromedriverLin");
	public WebDriver driver = new ChromeDriver();

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

		driver.switchTo().window(parentWindowHandler);

	}

	@Test(priority = 8)
	public void GoogleSignup() throws InterruptedException {

		driver.get("http://positivradio.test.gate6.com/web/#/register");
		driver.findElement(By.cssSelector("button.google")).click();

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

		driver.findElement(By.id("identifierId")).sendKeys("gate6.info@gate6.com");
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Goole2010A!!");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();

		driver.switchTo().window(parentWindowHandler);

	}

	@Test(priority = 9)
	public void Invalid_EmailLogin() {

		driver.get("http://positivradio.test.gate6.com/web/#/login");
		driver.findElement(By.name("email")).sendKeys("manish.dangas@gate62.com");
		driver.findElement(By.name("password")).sendKeys("gate6@123");
		driver.findElement(By.cssSelector("button.btn.custom-btn")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/#/login");

	}

	@Test(priority = 10)
	public void Invalid_PasswordLogin() {

		driver.get("http://positivradio.test.gate6.com/web/#/login");
		driver.findElement(By.name("email")).sendKeys("manish.dangas@gate6.com");
		driver.findElement(By.name("password")).sendKeys("gatesix#12");
		driver.findElement(By.cssSelector("button.btn.custom-btn")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/#/login");

	}

	@Test(priority = 11)
	public void Valid_Login() throws InterruptedException {

		driver.get("http://positivradio.test.gate6.com/web/#/login");
		driver.findElement(By.name("email")).sendKeys("manish.dangas@gate6.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.cssSelector("button.btn.custom-btn")).click();
		Thread.sleep(2000);

		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/#/");

	}
	
	@Test(priority = 12)
	public void Logout_Test() throws InterruptedException

	{

		driver.findElement(By.cssSelector("button.btn-signout.radius8px")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.btn.default")).click();
	}

	@Test(priority = 13)
	public void Forgot_Password_with_registerd_user() throws InterruptedException {
		Thread.sleep(5000);
		driver.get("http://positivradio.test.gate6.com/web/#/sendotp");
		driver.findElement(By.name("email")).sendKeys("test12@gate6.com");
		driver.findElement(By.cssSelector("button.btn.custom-btn")).click();

		Thread.sleep(10000);
		String URL_OTP = driver.getCurrentUrl();

		Assert.assertEquals("http://positivradio.test.gate6.com/web/#/login", URL_OTP);

	}

	@Test(priority = 14)
	public void Forgot_Password_with_invalid__user() throws InterruptedException {
		Thread.sleep(5000);
		driver.get("http://positivradio.test.gate6.com/web/#/sendotp");
		driver.findElement(By.name("email")).sendKeys("t12est12@gate6.com");
		driver.findElement(By.cssSelector("button.btn.custom-btn")).click();

		Thread.sleep(10000);
		String URL_OTP = driver.getCurrentUrl();

		Assert.assertEquals("http://positivradio.test.gate6.com/web/#/sendotp", URL_OTP);

	}

	@BeforeTest
	public void beforeTest() {

		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {

		// driver.quit();
	}
}
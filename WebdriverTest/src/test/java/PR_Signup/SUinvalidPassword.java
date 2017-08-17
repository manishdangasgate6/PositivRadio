package PR_Signup;

import java.io.File;

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

public class SUinvalidPassword {
//	public String st = System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
//
//	public  WebDriver driver = new PhantomJSDriver();
	
	public String st = System.setProperty("webdriver.chrome.driver", "ChromeDriver/Chromedriver.exe");

		public WebDriver driver = new ChromeDriver();
	@Test
	public void Password_Validation() {

		driver.get("http://positivradio.test.gate6.com/web/#/register");
		driver.findElement(By.name("fullName")).sendKeys("Manish Dangas");
		driver.findElement(By.id("email")).sendKeys("manish.dangas@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Gate2");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		String URL = driver.getCurrentUrl();

	Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/#/register");

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
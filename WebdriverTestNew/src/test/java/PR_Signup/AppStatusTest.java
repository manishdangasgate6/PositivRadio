package PR_Signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class AppStatusTest {
	public String st = System.setProperty("webdriver.chrome.driver", "ChromeDriver/ChromedriverLinux");

	public WebDriver driver = new ChromeDriver();

	@Test
	public void CheckApp_Status() {

		driver.get("http://positivradio.test.gate6.com/web/");
		driver.findElement(By.className("facebook"));
		System.out.print("Application is working");

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

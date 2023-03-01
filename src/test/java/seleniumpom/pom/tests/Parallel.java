package seleniumpom.pom.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Parallel {
	ThreadLocal<WebDriver> localDriver=new ThreadLocal<WebDriver>();
	ThreadLocal<HomePage> localHomePage=new ThreadLocal<HomePage>();
	//WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		localDriver.set(new ChromeDriver());
		wait=new WebDriverWait(localDriver.get(),Duration.ofSeconds(15));
		localHomePage.set(new HomePage(localDriver.get()));
	}
	
	@Test
	  void test1() {
		HomePage homePage = new HomePage(localDriver.get());
		homePage.loadHomepage();
		homePage.enterTextInSearchFieldAndClickEnter("hello");
	}
	@Test
	  void test4() {
		HomePage homePage = new HomePage(localDriver.get());
		homePage.loadHomepage();
		homePage.enterTextInSearchFieldAndClickEnter("test");
	}
	@Test
	  void test2() {
		HomePage homePage = new HomePage(localDriver.get());
		homePage.loadHomepage();
		homePage.enterTextInSearchFieldAndClickEnter("live");
	}
	@Test
	  void test3() {
		HomePage homePage = new HomePage(localDriver.get());
		homePage.loadHomepage();
		homePage.enterTextInSearchFieldAndClickEnter("world");
	}
	

}

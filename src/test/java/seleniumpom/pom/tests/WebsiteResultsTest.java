package seleniumpom.pom.tests;

import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.SearchResultPage;
import dataProviders.searchWordsDataProvider;

import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class WebsiteResultsTest {

 WebDriver driver;
WebDriverWait wait;
HomePage homePage;
SearchResultPage searchResultPage;
	@BeforeMethod
	void setup() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		homePage=new HomePage(driver);
		searchResultPage=new SearchResultPage(driver);
	}
	@Test(dataProvider = "returnSearchWordData",dataProviderClass=searchWordsDataProvider.class)


	public void test1(String searchWord) {
		homePage.loadHomepage();
		homePage.enterTextInSearchFieldAndClickEnter(searchWord);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultPage.websiteResults));
		System.out.println("Results size is "+ driver.findElements(searchResultPage.websiteResults).size());
		for(WebElement element : driver.findElements(searchResultPage.websiteResults)) {
			System.out.println("Result is "+element.getText().toLowerCase());
		
			String resultText=  element.getText().toLowerCase().trim();
			
			if(!(resultText.isEmpty())){
			if(!(resultText.contains("hello"))) {
				
				Assert.assertTrue(false,"Unable to hello text in search result");
				
			}
		}
		}
		
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}


}

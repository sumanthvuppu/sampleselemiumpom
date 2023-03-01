package seleniumpom.pom.tests;

import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.SearchResultPage;

import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataProviders.searchWordsDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class VideoResultsTest {
 //WebDriver driver;
WebDriverWait wait;
HomePage homePage;

SearchResultPage searchResultPage;
ThreadLocal<WebDriver> local=new ThreadLocal<WebDriver>();


	@BeforeMethod
	void setup() {
		WebDriverManager.chromedriver().setup();
		 local.set(new ChromeDriver());
		 wait=new WebDriverWait(local.get(),Duration.ofSeconds(30));
		 homePage=new HomePage(local.get());
		 searchResultPage=new SearchResultPage(local.get());
	}
	

	@Test(dataProvider = "returnSearchWordData",dataProviderClass=searchWordsDataProvider.class)
	
	public void test1(String searchWord) {
		
		homePage.loadHomepage();
		System.out.println("search word is "+searchWord);
		
		homePage.enterTextInSearchFieldAndClickEnter(searchWord);
		
	ArrayList<String> results=	searchResultPage.getResults();
	for(String resultText:results) {
		if(!(resultText.isEmpty())){
			if(!(resultText.contains(searchWord))) {
				
				Assert.assertTrue(false,"Unable to "+searchWord+" text in search result");
				
			}
			}
		
		}
	}
		

	       HashMap<String,String> getSearchData(){
	    		  HashMap<String,String> searchData=new HashMap<>();
	    		  String userDetails="test@gmail.com-123456";
	    		searchData.put("userlogin","test@gmail.com-123456");
	    		searchData.put("adminlogin","admin@gmail.com-123456");
	    		String[] resultAftersplit=  userDetails.split("-");
	    		
	    		System.out.println(resultAftersplit[0]);
	    			System.out.println(resultAftersplit[1]);
	    		  
	    		return searchData;
	      }
	       
	       
	       @Test
	       public void displayAllContentsInHashMap() {
	    	 HashMap<String,String >  results= getSearchData();
	    	 
	    for(Map.Entry<String,String> entry:results.entrySet()) {
	    	System.out.println(entry.getKey() +" : "+ entry.getValue());
	   
	    	
	    	
	    }
	       }
	       
	
	
	@Test
	public void searchResultTestUsingMapData() {
		 HashMap<String,String >  dataResults= getSearchData();
		 
		   for(Map.Entry<String,String> entry:dataResults.entrySet()) {
				String searchWord=entry.getValue();
		   
				homePage.loadHomepage();
				System.out.println("search word is "+searchWord);
				
				homePage.enterTextInSearchFieldAndClickEnter(searchWord);
				
			ArrayList<String> results=	searchResultPage.getResults();
			for(String resultText:results) {
				if(!(resultText.isEmpty())){
					if(!(resultText.contains(searchWord))) {
						
						Assert.assertTrue(false,"Unable to "+searchWord+" text in search result");
						
					}
					}
				
				}
		    	
		    }
		 
	
	
	}
	
	
	@AfterMethod
	void teardown() {
		local.get().quit();
	}

}

package PageObject;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	WebDriverWait wait;

	
	WebDriver driver;
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		 wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
	}
public 	By videoResults=By.cssSelector("[class=\"cHaqb\"]");
public By websiteResults=By.cssSelector("[class=\"yuRUbf\"] h3");

public ArrayList<String> getResults() {
	ArrayList<String> results = new ArrayList<String>();
wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(websiteResults));
System.out.println("Results size is "+ driver.findElements(websiteResults).size());
for(WebElement element : driver.findElements(websiteResults)) {
	System.out.println("Result is "+element.getText().toLowerCase());

	String resultText=  element.getText().toLowerCase().trim();
	results.add(resultText);
	}
return results;


}

}

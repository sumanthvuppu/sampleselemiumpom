package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utils.Constants;

public class HomePage {
WebDriver driver;


public HomePage(WebDriver driver1) {
driver = driver1;
}
	
	 By searchInput=By.name("q");
	
public void loadHomepage() {
	driver.get(Constants.URL);
}
	 

	 
	public void  enterTextInSearchFieldAndClickEnter(String searchWord) {
		driver.findElement(searchInput).sendKeys(searchWord);
		driver.findElement(searchInput).sendKeys(Keys.ENTER);
	}
}

package dataProviders;

import org.testng.annotations.DataProvider;

public class searchWordsDataProvider {
	@DataProvider(name = "returnSearchWordData")
	public String[] returnSearchWordData() {
		
		String searchWordData[]= {"hello","live"};
		return searchWordData;
		
	}

}

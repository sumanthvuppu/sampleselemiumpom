package seleniumpom.pom;

public class TestClass {
	
	public static void main(String[] args) {
		customWebDriver driver=new customFireFoxDriver();
		driver.get();
		customWebDriver driver1=new customChromeDriver();
		driver1.get();
		
	}

}

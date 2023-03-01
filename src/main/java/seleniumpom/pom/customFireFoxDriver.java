package seleniumpom.pom;

public class customFireFoxDriver implements customWebDriver {

	@Override
	public void get() {
		// TODO Auto-generated method stub
		System.out.println("get method called in firefox driver");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("close method called in firefox driver");
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		System.out.println("quit method called in firefox driver");
	}

}

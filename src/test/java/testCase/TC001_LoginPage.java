package testCase;

import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC001_LoginPage extends BaseClass {
	
     @Test
	public void verify_Login()
	{
    	 AdminLogin();
    	 logger.info("Successfully Loggedin");
   }
}
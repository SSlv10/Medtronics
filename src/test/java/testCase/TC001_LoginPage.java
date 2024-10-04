package testCase;

import org.testng.annotations.Test;


import pageObject.AdminLogin;
import testBase.BaseClass;

public class TC001_LoginPage extends BaseClass {
	
     @Test
	public void verify_Login()
	{
		AdminLogin login = new AdminLogin(driver);
		login.setUserName("admin@mailinator.com");
		login.setPwd("Password4@");
		login.Login();
	}

}

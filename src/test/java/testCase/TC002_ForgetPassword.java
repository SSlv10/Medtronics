package testCase;

import org.testng.annotations.Test;

import pageObject.ForgetPassword;
import testBase.BaseClass;

public class TC002_ForgetPassword extends BaseClass{
	
	@Test
	public void verify_ForgetLink() {
		logger.info("***Verify Forget Page***");
		ForgetPassword fp = new ForgetPassword(driver);
		 logger.info("***Open the login page***");
		fp.clickForgetLink();
		 logger.info("***Forget Link selected***");
		fp.setEmail(p.getProperty("adminEmail"));
		 logger.info("***Email id entered***");
		fp.submit();
		 logger.info("***Submitted***");
	}

}

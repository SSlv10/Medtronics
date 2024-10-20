package testCase;

import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AdminLogin;
import pageObject.NewUserAccount;
import testBase.BaseClass;

public class TC003_AddUser extends BaseClass {
	
	@Test
	public void verify_login1 () throws InterruptedException
	{
		try {
		logger.info("***verify to add a new user***");
	/*	AdminLogin login = new AdminLogin(driver);
		login.setUserName(p.getProperty("adminEmail"));
		login.setPwd(p.getProperty("adminPassword"));
		login.Login();
		 logger.info("***LoggedIn Success***");
		login.setCaptcha();
		 logger.info("***Captcha updated***");
		  Thread.sleep(2000);
		login.setOTP();
		 logger.info("***OTP Entered***");
		login.submitOTP();
		 logger.info("***Submitted***"); */
		
		AdminLogin();

		logger.info("***add user check started***");
		NewUserAccount user = new NewUserAccount(driver);
		user.clickUserAcc();
		logger.info("***Entered into UserAccounts Page***");
		user.clickNewUserPopup();
		logger.info("***Opened the new user popup***");
		/*String ExpectedTitle = user.getPopupTitle();
		String ActualTitle = "Add User Account";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		logger.info("***Popup Title verified***");*/
		logger.error("***started to fill the fields***");
		user.orgName("abc PVT Ltd");
		logger.error("***OrgName Updated***");
		
		user.postalCode("SW1A 1AA");
		logger.error("***Postalcode Updated***");
		user.search();
		logger.error("***Searched***");
		Thread.sleep(1000);;
	   // user.logDropdownOptions();
		//user.selectDropdownOptionByJS("Colicci /Ecsi Ltd, The Mall, London, SW1A 1AA");
	//	user.addressFilter();
		logger.error("***Address Updated***");
		
		user.setFName(randomString());
		logger.error("***FName Updated***");
		user.setLName(randomInteger());
		logger.error("***LName Updated***");
		user.setEmail(randomAlphaNm());
		logger.error("***Email Updated***");
		Thread.sleep(1000);
		//user.setPCode();
		//logger.error("***PCode Updated***");
		user.setPNum(randomInteger());
		logger.error("***PNum Updated***");
		Thread.sleep(1000);
		//user.setOrgType();
		//logger.info("***Values are entered***");
		user.saveValues();
		logger.info("***Values saved***");
		}
		catch(Exception e)
		{
			logger.info("Test Failed");
			logger.error("Error occured");
			Assert.fail();
		}
		

	}

}

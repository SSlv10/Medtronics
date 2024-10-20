package testBase;

import java.io.FileReader;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObject.AdminLogin;

public class BaseClass {
	
	public WebDriver driver;
	public Properties p;
	public Logger logger;
	
	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	{
		FileReader file = new FileReader("./src//test//resources//properties");
		p=new Properties();
		p.load(file);	
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome": driver= new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver();break;
		default: System.out.println("Invalid browser"); return;
		}
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("adminUrl"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void AdminLogin()
	{
    	 try 
    	 
    	 {
    	 logger.info("***Open the login page***");
		AdminLogin login = new AdminLogin(driver);
		login.setUserName(p.getProperty("adminEmail"));
		login.setPwd(p.getProperty("adminPassword"));
		login.Login();
		 logger.info("***LoggedIn Success***");
		login.setCaptcha();
		 logger.info("***Captcha updated***");
		  Thread.sleep(1000);
		login.setOTP();
		 logger.info("***OTP Entered***");
		login.submitOTP();
		 logger.info("***Submitted***");
		
		String ActualTitle = login.getHomeTitle();
		Assert.assertEquals(ActualTitle, "Medtronic Syncope clinic management");
		 logger.info("***Home Title verified***");
	} catch (Exception e)
    	 {
		logger.error("Test failed");
		Assert.fail();
    	 }
	}
	
	//RandomString methods
		public String randomString()
		{
			String generatedstring  = RandomStringUtils.randomAlphabetic(10);
			return generatedstring;
			
		}
		
		public String randomInteger()
		{
			String generatednumber = RandomStringUtils.randomNumeric(10);
			return generatednumber;
		}
		
		public String randomAlphaNm()
		{
			String generatedstring = RandomStringUtils.randomAlphabetic(10);
			String generatednumber = RandomStringUtils.randomNumeric(3);
			return (generatedstring + "@"+ generatednumber);
		}

}

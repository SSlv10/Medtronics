package pageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin extends BasePage {
	
	//constructor
	
	public AdminLogin(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(xpath = "//input[@type = 'password']")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement logIn;
	
	@FindBy(xpath = "//iframe[@title='reCAPTCHA']")
	WebElement frame1;
	
	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	WebElement captcha;
	
	@FindBy(xpath = "//input[@placeholder='Enter the OTP']")
	WebElement otp;
	
	@FindBy(xpath = "//button[normalize-space()='Verify']")
	WebElement verifyOtp;
	
	@FindBy(xpath = "//body//app-root//h1[1]" )
	WebElement homeTitle;
	
	
	//Action methods
	public void setUserName(String user)
	{
		userName.sendKeys(user);
	}
	
	public void setPwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void Login()
	{
		logIn.click();
	}
	
	public void setCaptcha()
	{
		driver.switchTo().frame(frame1);
		captcha.click();
		driver.switchTo().defaultContent();
	}
	
	public void setOTP()
	{
		otp.sendKeys("111111");
	}
	
	public void submitOTP()
	{
		verifyOtp.click();
	}
	
	public String getHomeTitle()
	{
		try{
			return(homeTitle.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}

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
}

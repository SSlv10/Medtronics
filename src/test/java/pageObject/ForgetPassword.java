package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPassword extends BasePage {
	
	public ForgetPassword(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Forgot Password']")
	WebElement flink;
	
	@FindBy(xpath = "//input[@placeholder = 'Email address...']")
	WebElement email;
	
	@FindBy(xpath = "//div[@class='md:col-12 text-center ng-star-inserted']")
	WebElement button;
	
	public void clickForgetLink()
	{
		flink.click();
	}
	
	public void setEmail(String user)
	{
		email.sendKeys(user);
	}
	
	public void submit() 
	{
	button.click();
	}

}

package pageObject;

import java.time.Duration;
import java.util.List;

import org.codehaus.plexus.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewUserAccount extends BasePage {
	
	public NewUserAccount(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "//a[normalize-space() = 'User Accounts']")
	WebElement userAccLink;

	@FindBy(xpath = "//button[normalize-space()='New User Account']")
	WebElement newUserAccLink;
	
	@FindBy(xpath = "//p-dialog[@class='p-element ng-tns-c4042076560-3 ng-star-inserted']")
	WebElement viewPopup;
	
	@FindBy(xpath = "//span[@id='pn_id_33_header']")
	WebElement popuptitle;
	
	@FindBy(xpath = "//input[@formcontrolname='organisationname'][@type='text']")
	WebElement orgNameField;
	
	@FindBy(xpath = "//input[@class='form-control ng-untouched ng-pristine ng-invalid'][@placeholder='Enter Postcode *']")
	WebElement postalCodeTextField;
	
	@FindBy(xpath = "//img[@src='assets/images/search-white.png']")
	WebElement searchIcon;
	
	@FindBy(xpath = "//span[normalize-space()='Select Address...']")
	public WebElement dropdown;
	
	@FindBy(xpath = "//*[@id=\'pn_id_35_list\']/p-dropdownitem")
	WebElement ddList;
	
	@FindBy(xpath = "//*[@id=\'pn_id_35_list\']/p-dropdownitem[4]/li/span")
	WebElement ddListValue;
	
	@FindBy(xpath = "//input[@formcontrolname='firstname']")
	WebElement fName;
	
	@FindBy(xpath = "//input[@formcontrolname='lastname']")
	WebElement lName;
	
	@FindBy(xpath = "//input[@formcontrolname='email']")
	WebElement eMail;
	
	@FindBy(xpath  = "//div[@class='p-dropdown p-component p-dropdown-open']//span[@class='p-dropdown-label p-inputtext p-placeholder ng-star-inserted'][normalize-space()='Select']")
	WebElement pCode;
	
	@FindBy(xpath = "//input[@placeholder='XXXXXXXXXX']")
	WebElement pNum;
	
	@FindBy(xpath = "//span[normalized-space() = 'Select']")
	WebElement OrgType;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	
	public void clickUserAcc()
	{
	   
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(userAccLink)).click();
	}
	
	public void clickNewUserPopup()
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(newUserAccLink)).click();
		wait.until(ExpectedConditions.visibilityOf(viewPopup));
	}
	
	public String getPopupTitle()
	{
		try{
			return(popuptitle.getText());
		}catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	public void orgName(String user)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(orgNameField)).sendKeys(user);
	}
	
	public void postalCode(String user)
	{
		postalCodeTextField.sendKeys(user);
	}
	
	public void search()
	{
		searchIcon.click();
	}
	
	public void logDropdownOptions() {
	    try {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'pn_id_35_list\']/p-dropdownitem")));
	        
	        List<WebElement> options = driver.findElements(By.xpath("//*[@id=\'pn_id_35_list\']/p-dropdownitem"));
	      //*[@id="pn_id_35_list"]/p-dropdownitem[4]
	        System.out.println("Dropdown options loaded:");
	        for (WebElement option : options) {
	            System.out.println(option.getText());
	        }
	    } catch (Exception e) {
	        System.out.println("Error while logging dropdown options: " + e.getMessage());
	    }
	}
	public void selectDropdownOptionByJS( String optionText)
{
		try {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", dropdown);
	System.out.println("Dropdown Opened");
	
	wait.until(ExpectedConditions.visibilityOfAllElements(ddList));
	List<WebElement> ddOptions = wait.until(ExpectedConditions.visibilityOfAllElements(ddList));

	for (WebElement option : ddOptions) {
        if (option.getText().equals(optionText)) {
            js.executeScript("arguments[0].scrollIntoView(true);", option);
            js.executeScript("arguments[0].click();", option);
            System.out.println("Dropdown selected:"+optionText);
            return;
        }}
	System.out.println("Error:DD not found");
}
	catch(Exception e)
        {
        	System.out.println("Error while selecting dd option"+e.getMessage());
        }
}


	public void addressFilter()
	{
		
		
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
		List<WebElement>ddOptions = wait.until(ExpectedConditions.visibilityOfAllElements(ddList));
		
		for(WebElement options:ddOptions)
		{
			if(options.getText().equals("Colicci /Ecsi Ltd, The Mall, London, SW1A 1AA")) {
				options.click();
				break;
			}
		}
	}
	

	
	public void setFName(String user)
	{
		fName.sendKeys(user);
	}
	
    public void setLName(String user)
    {
	lName.sendKeys(user);
    }
    public void setEmail(String user)
    {
    	eMail.sendKeys(user);
    }

    public void setPCode()
    {
    	Select code = new Select(pCode);
    	code.selectByIndex(1);
    }
    
    public void setPNum(String user)
    {
    	pNum.sendKeys("1234567817");
    }
    
    public void setOrgType()
    {
     Select org = new Select(OrgType);
     org.selectByIndex(2);
    }
    
    public void saveValues() {
    	saveButton.click();
    }

}

package testBase;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public WebDriver driver;
	//public Properties p;
	@BeforeClass
	public void setup() throws IOException
	{
		//FileReader file = new FileReader("./src//test//resources//properties");
		//p.load(file);	
		//p=new Properties();
		
		driver = new ChromeDriver();
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev.medtronic.cyb.co.uk/");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}

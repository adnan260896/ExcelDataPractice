package DataDrivenExcel.ExcelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserLaunchTest {
	WebDriver driver;
	LoginPage lp;
	public WebDriver initialize_webdriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\ExcelDataDriven\\BrowserDetails\\Browser.properties");
	    prop.load(fis);
	    if (prop.getProperty("browser").contains("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    }
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	@BeforeTest
	public LoginPage LaunchBrowser() throws IOException
	{
		driver =initialize_webdriver();
		 lp = new LoginPage(driver);
		lp.URL();
		return lp;
		
	}
	
	//@AfterTest
	/*public void closeBrowser()
	{
		driver.close();
	}*/
}

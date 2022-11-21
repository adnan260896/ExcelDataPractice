package DataDrivenExcel.ExcelDataDriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement Loginbutton;
	
	public void Enter_username(String str)
	{
		username.sendKeys(str);
	}
	
	public void Enter_pwd(String str2)
	{
		password.sendKeys(str2);
	}
	
	public void Click_button()
	{
		Loginbutton.click();
	}
	
	public void URL()
	{
		driver.get("https://rahulshettyacademy.com/client/auth/login");
	}
}

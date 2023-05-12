package pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCCP_Login_Page
{
	//POM CLASS 01
	
	//declaration
	@FindBy(xpath = "//input[@id='username']") private WebElement uN;
    //private webelement UN=driver.findelement(By.xpath(xpath expression));
	
	@FindBy(xpath = "//input[@id='passInput']") private WebElement pWD;
	
	@FindBy(xpath = "//button[@type='submit']") private WebElement loginButton;
	
	//Initialization
	public ACCCP_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Usage
	//Enter UserName
	public void inpACCPLoginPageUN(String userName)
	{
		uN.sendKeys(userName);
	}
	
	//Enter PassWord
	public void inpACCPLoginPagePWD(String passWord)
	{
		pWD.sendKeys(passWord);
	}

	//click on the Login button
	public void clickACCPpageLoginBtn()
	{
		loginButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

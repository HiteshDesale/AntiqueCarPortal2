package pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCP_Search_Page 
{
	//POM CLASS 02
	
	//Declaration
	@FindBy(xpath = "//i[@class = 'aa-icon search']") private WebElement serachIcon;
	
	@FindBy(xpath = "//input[@id=\"searchpolicyId\"]") private WebElement enterPolicyNumber;
	
	@FindBy(xpath = "//button[@id=\"searchButton\"]") private WebElement searchButton;
	
	@FindBy(xpath = "//a[text() = 'AAP 0104676']") private WebElement policyNumber;
	
	@FindBy(xpath= "//a[@class='dropdown-toggle']") private WebElement userTab;
	
	@FindBy(xpath ="//button[@class='btn btn-bordered']") private WebElement logOut;
	
	
	//Initialization
	public ACCP_Search_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	    //Usage
		//click on search icon
		public void clickonSearchIcon()
		{
			serachIcon.click();
		}
		
		//Enter policy number
		public void enterPolicyInitials(String policyNumber)
		{
			enterPolicyNumber.sendKeys(policyNumber);
		}

		//click on the search button
		public void clickOnSearchButton()
		{
			searchButton.click();
		}
		
		//Get Policy Number to verify
		public String getPolicyNumberToVerify()
		{
			String actPolicyNumber = policyNumber.getText();
			return actPolicyNumber;
		}
		
		//click on user id tab
		public void clickOnSearchPageUserTab()
		{
			userTab.click();
		}
		
		//click on the Logout button
		public void clickOnLogoutButton()
		{
			logOut.click();
		}
	
	
	
	

}

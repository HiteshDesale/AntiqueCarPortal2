package test.classes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import dev.failsafe.Timeout;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import library.files.Base_Class;
import library.files.Utility_Class;
import pom.classes.ACCCP_Login_Page;
import pom.classes.ACCP_Search_Page;

public class ACCPLoginTest extends Base_Class
{
	//TEST CLASS

	private static final int TCID = 0;
	ACCCP_Login_Page loginPage;
	ACCP_Search_Page searchPage;

	@Severity(SeverityLevel.CRITICAL)
	@Step("Opening the browser and launching the ACCP URL")
	@BeforeClass
	public void openBrowser()
	{
		initializeBrowser();

		org.apache.logging.log4j.Logger logger = LogManager.getLogger(ACCPLoginTest.class);

		driver.get("https://m2.assurant.com/accp/agent/login");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		loginPage = new ACCCP_Login_Page(driver);

		searchPage = new ACCP_Search_Page(driver);

	}

	@Severity(SeverityLevel.MINOR)
	@Step("Logging in to the application and searching the policy")
	@BeforeMethod
	public void loginToApp() throws IOException
	{
		loginPage.inpACCPLoginPageUN(Utility_Class.getTestData(0, 0));

		loginPage.inpACCPLoginPagePWD(Utility_Class.getTestData(0, 1));

		loginPage.clickACCPpageLoginBtn();

		searchPage.clickonSearchIcon();

		searchPage.enterPolicyInitials(Utility_Class.getTestData(0, 2));

		searchPage.clickOnSearchButton();

	}

	@Severity(SeverityLevel.BLOCKER)
	@Step("Verifying whether actual policy number is matching with the expected policy number")
	@Test 
	public void verifyPolicyNumber() throws IOException
	{
		String actPolicyNumber = searchPage.getPolicyNumberToVerify();
		String expPolicyNumber = Utility_Class.getTestData(0, 3);

		Assert.assertEquals(actPolicyNumber, expPolicyNumber, "Failed : both results are different");

	}

   
	@Severity(SeverityLevel.NORMAL)
	@Step("Taking a screenshot of failed test case and doing logout from the application")
	@Description("This method will be skipped if Verify Policy number method fails")
	@AfterMethod 
	public void logoutFromApp(ITestResult result) throws IOException
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			Utility_Class.captureScreenShotofFailedTestCase(driver, TCID);
		}
			
		searchPage.clickOnSearchPageUserTab();

		searchPage.clickOnLogoutButton();
	}

	@Severity(SeverityLevel.MINOR)
	@Step("Closing the browser and clearing the memory from the objects")
	@Description("This method will be skipped if Verify Policy number method fails")
	@AfterClass
	public void closeBrowser()
	{
		driver.close();		
		loginPage=null;
		searchPage=null;
		driver=null;
	}


}

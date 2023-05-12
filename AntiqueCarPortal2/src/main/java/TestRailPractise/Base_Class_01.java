package TestRailPractise;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.gurock.testrail.APIException;

public class Base_Class_01 
{
	protected String testCaseID;
	@BeforeSuite
	public void configBS()
	{

	}

	@BeforeTest
	public void configBT()
	{

	}

	@BeforeClass
	public void configBC()
	{

	}

	@BeforeMethod
	public void configBM()
	{

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, APIException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			TestRailManager.addResultForTestCase(testCaseID, TestRailManager.TEST_CASE_PASSED_STATUS, "");
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			TestRailManager.addResultForTestCase(testCaseID, TestRailManager.TEST_CASE_FAILED_STATUS,"");
		}

	}
























}

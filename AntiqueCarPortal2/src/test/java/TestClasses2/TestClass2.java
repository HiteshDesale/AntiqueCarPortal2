package TestClasses2;

import org.apache.hc.core5.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TestClass2 
{
	@Severity(SeverityLevel.MINOR)
	@Description("Verify the test case 3 ")
	@Story("Verifying the expected and actual output")
	@Test(priority = 0)
	public void test1() 
	{
		Assert.assertTrue(false);
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("Verify the test case 4 ")
	@Story("Verifying the expected and actual output")
	@Test(dependsOnMethods = "test1")
	public void test2()
	{
		Assert.assertFalse(true);
	}
}

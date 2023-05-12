package TestClasses2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story(value = "verifying the test cases by applying the assertions")
@Severity(value =SeverityLevel.CRITICAL)
@Epic(value = "Login Functionality")
@Link("https://www.seleniumeasy.com/selenium-tutorials/allure-report-example-with-annotations")
public class TestClass1 
{
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify the test case1 ")
	@Story("Verifying the expected and actual output")
	@Test
	public void test1() 
	{
		Assert.assertTrue(true);

	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verying the test case2")
	@Story("Verifying the expected and actual output")
	@Test(dependsOnMethods = "test1")
	public void test2()
	{
		System.out.println("Test 1 failed hence test2 is skipped");
	}
}

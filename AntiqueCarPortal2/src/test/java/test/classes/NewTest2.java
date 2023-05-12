package test.classes;

import org.asynchttpclient.util.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class NewTest2 
{


	@Test
	public void test2() 
	{
		Assert.assertFalse(true);
		System.out.println("Test2 is working as expected");
	}
	
	@Test(dependsOnMethods = "test2")
	public void test3()
	{
		System.out.println("Test2 will be skipped if test2 is failing");
	}


}

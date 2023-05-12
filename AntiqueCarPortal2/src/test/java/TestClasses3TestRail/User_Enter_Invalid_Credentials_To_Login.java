package TestClasses3TestRail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestRailPractise.Base_Class_01;
import io.github.bonigarcia.wdm.WebDriverManager;

public class User_Enter_Invalid_Credentials_To_Login extends Base_Class_01
{
	@Test
	public void User_Enter_Invalid_Credentials_LoginTest()
	{
		testCaseID= "10";

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://m2.assurant.com/accp/agent/login");
		driver.findElement(By.name("assurant")).sendKeys("hdesale1@rdalabs.com");
		driver.findElement(By.name("dashboard")).sendKeys("assuranttest", Keys.ENTER);
		//Assert.assertTrue(false);
		driver.close();
		driver.quit();

	}


}

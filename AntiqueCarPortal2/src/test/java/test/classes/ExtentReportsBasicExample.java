package test.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasicExample 
{
	private static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("ExtentReports.html");
		
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test1 = extent.createTest("Google Search test1", "This is a test to validate Google Search functionality");
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 test1.log(Status.INFO, "Starting the test case execution");
		 driver.get("https://www.google.com/");
		 test1.pass("Navigated to the Google search");
		 
		 test1.log(Status.INFO, "Entering the input");
		 driver.findElement(By.name("q")).sendKeys("Automation");
		 
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("(//span[text()='automation'])[1]")).click();
		 test1.pass("Entered Automation as an Input in the search bar and clicked on the first auto-suugestion");
		 
		 test1.log(Status.INFO, "Closing the browser");
		 driver.close();
		 driver.quit();
		 test1.pass("Closed the browser");
		 
		 test1.log(Status.INFO, "test is completed");
		 
		 extent.flush();
		 
		 
		 
			 

		
		
	}

}

package library.files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class 
{

	protected WebDriver driver;
	ExtentSparkReporter htmlReporter;
	protected ExtentReports extent;

	public void initializeBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public void getExtentReport()
	{
		htmlReporter = new ExtentSparkReporter("Extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}


}

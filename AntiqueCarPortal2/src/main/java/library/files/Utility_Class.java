package library.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.collect.Table.Cell;

import io.qameta.allure.Attachment;

public class Utility_Class 
{

	public static String getTestData(int rowIndex, int cellIndex) throws IOException
	{

		FileInputStream file=new FileInputStream("C:\\Users\\Hitesh\\Desktop\\ACCP Insurance\\TestData.xlsx");

		org.apache.poi.ss.usermodel.Sheet sh=WorkbookFactory.create(file).getSheet("DDF");

		String value = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();

		return value;

	}

	@Attachment
	public static void captureScreenShotofFailedTestCase(WebDriver driver, int TCID) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\Hitesh\\Desktop\\ACCP Insurance\\Screenshots of failed test cases\\testCaseID" + TCID + ".jpg");
		FileHandler.copy(source, destination);
	}

	
}

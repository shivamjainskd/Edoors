package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst{
	
	public WebDriver driver;
	
	static
	{
		System.setProperty(KEY, VALUE);
	}
	@BeforeMethod
	public void openApp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(APP_URL);
	}
	@AfterMethod
	
	public void closeApp(ITestResult iTestResult)
	{
		int status=iTestResult.getStatus();
		String name=iTestResult.getName();
		if(status==1)
		{
			Reporter.log("Test" +name+ " is pass", true);
		}
		else
		{
			Reporter.log("Test" +name+ " is fail/skip", true);
			AutoLib.getPhoto(driver, IMG_PATH+name+".png");
		}
		driver.close();
	}
	

}

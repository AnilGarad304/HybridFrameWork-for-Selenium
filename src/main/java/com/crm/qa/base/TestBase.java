package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.utilities.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException
	{
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:/Users/Anil Garad/workspace/HybridFrameWork_POM_DD/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void initilization()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("Chrome"))
		{
			String CDpath="C://Chrome//chromedriver.exe";
		    System.setProperty("webdriver.chrome.driver",CDpath);
	        driver = new ChromeDriver();		
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitlyWait,TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
}

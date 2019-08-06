package com.crm.qa.testcases;
import java.io.IOException;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.HomePage;

public class LoginPageTest extends TestBase
{

	LoginPage LoginPage;
	HomePage homepage;
	
	
	
	//Constructor
	public LoginPageTest() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws Exception 
	{
		initilization();
		LoginPage= new LoginPage();
		
		
	}
	
	
	@Test(priority=1)
	public void validateLoginPageTitleTest()
	{
		
		String title=LoginPage.verifytheTitleofpage();
		Assert.assertEquals(title,"Free CRM software for any Business");
	}
	
	@Test(priority=2)
	public void ClickonLogonTest()
	{
		LoginPage.clickOnLogin();
		String title=LoginPage.verifytheTitleofpage();
		Assert.assertEquals(title,"CRM");
	}
	@Test (priority=3)
	
	public void loginTest() throws IOException
	{
		LoginPage.clickOnLogin();
		homepage= LoginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	@AfterMethod 
	public void tearDown()
	{
		driver.quit();
		
	}
}

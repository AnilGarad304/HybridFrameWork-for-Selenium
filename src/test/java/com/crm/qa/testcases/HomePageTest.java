package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase 
{
	
	LoginPage LoginPage;
	HomePage homepage;
	ContactsPage contactspage;
	
	
	//Constructor
	public HomePageTest() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws Exception 
	{
		initilization();
		LoginPage= new LoginPage();
		homepage=new HomePage();	
		contactspage =new ContactsPage();
		LoginPage.clickOnLogin();
		homepage= LoginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void validateHomePageTitleTest()
	{
		String title=homepage.verifytheTitleofHomePage();
		Assert.assertEquals(title,"CRM");
	}
	

	@Test(priority=3)
	public void verifyLogged_user_name_Test()
	{
		Assert.assertTrue(homepage.verifyloggedUser());
	}
	
	@Test(priority=2)
	public void verifycontactlinkTest() throws IOException
	{
		contactspage=homepage.clickOnContactsLink();
	}
	
	@AfterMethod 
	public void tearDown()
	{
		driver.quit();
		
	}

}

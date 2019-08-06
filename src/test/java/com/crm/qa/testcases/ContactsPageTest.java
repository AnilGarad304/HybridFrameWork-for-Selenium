package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase 
{
	//objects of different page class
	LoginPage LoginPage;
	HomePage homepage;
	ContactsPage contactspage;
	String sheetName="Contacts";
	//Constructor
	public ContactsPageTest() throws IOException 
	{
		super();
		
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
		homepage.clickOnContactsLink();
	}
	
	@DataProvider
	public Object[][] get_test_data_for_New_Contacts()
	{
		Object data [][]=TestUtil.getTestData(sheetName);
		return data;
	
	}
	@Test(priority=1, dataProvider="get_test_data_for_New_Contacts")
	public void createNewContactTest(String FirstName,String LastName,String Company)
	{
		System.out.println("Contact Insert Test");
		contactspage.click_on_new_contact();
		//contactspage.click_on_new_contact();
		//contactspage.create_new_contact("Komal", "Patilaa", "TCS");
		contactspage.create_new_contact(FirstName,LastName,Company);
	}
	
	
	@AfterMethod 
	public void tearDown()
	{
		
		driver.quit();
		
	}

}
